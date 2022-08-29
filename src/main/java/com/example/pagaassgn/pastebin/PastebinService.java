package com.example.pagaassgn.pastebin;

import com.example.pagaassgn.auth.UserService;
import com.example.pagaassgn.kgs.KGS;
import com.example.pagaassgn.kgs.Key;
import com.example.pagaassgn.kgs.KeyCollisionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PastebinService {

    private UserService userService;
    private PastebinRepository pastebinRepository;

    @Autowired
    private KGS kgs;

    @Autowired
    public PastebinService(UserService userService, PastebinRepository pastebinRepository) {

        this.userService = userService;
        this.pastebinRepository = pastebinRepository;

    }

    public String getAnonymousBin(String id) {
        Optional<Pastebin> binEntry = this.pastebinRepository.findNonExpiredById(id, new Date()); // Todo: let database handle this.
        return binEntry.map(Pastebin::getContent).orElse(null);
    }


    public String createAnonymousBin(String content, Integer duration) {
        Key key = kgs.getUnusedKey();
        String id;
        if (key != null) {
            id = key.getKey();
        } else {
            try {
                key = kgs.generateNewKey();
                id = key.getKey();
            } catch (KeyCollisionException e) {
                System.out.println("Key collision occurred."); //Todo: switch to system logger
                return null;
            }
        }

        Pastebin bin = pastebinRepository.save(new Pastebin(id, 0, content));
        kgs.activateKey(id);

        if (duration != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(bin.getCreatedOn());
            calendar.add(Calendar.HOUR_OF_DAY, duration);

            bin.setExpiry(calendar.getTime()); // Todo: have the database manage this calculation
            bin = pastebinRepository.save(bin);

        }
        return bin.getId();
    }


    public List<String> deleteExpiredPasteBins() {
        return this.pastebinRepository.deleteExpiredBins(new Date())
                .stream().map(Pastebin::getId).collect(Collectors.toList());
    }


}

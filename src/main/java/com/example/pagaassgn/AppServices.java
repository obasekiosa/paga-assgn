package com.example.pagaassgn;

import com.example.pagaassgn.kgs.KGS;
import com.example.pagaassgn.kgs.KeyCollisionException;
import com.example.pagaassgn.pastebin.PastebinService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppServices {

    @Autowired
    private static KGS kgs;

    @Autowired
    private static PastebinService pastebinService;

    private static final Logger LOGGER = Logger.getLogger(AppServices.class.getName());

    public static int generateKeys(int numOfKeys) {
        if (numOfKeys <= 0 ) return  0;

        int collisionCount = 0;
        for (int i = 0; i < numOfKeys; i++) {
            try {
                kgs.generateNewKey();
            } catch (KeyCollisionException e) {
                System.out.println("Key collision occurred. Collision Count: " + (++collisionCount)); //Todo: switch to system logger
            } catch (Exception e) {
                System.out.println("Unexpected error"); //Todo: switch to system logger
            }
        }

        return numOfKeys - collisionCount;
    }

    public static int removeExpiredBins() {
        List<String> keys = pastebinService.deleteExpiredPasteBins();
        int reactivatedCount = kgs.batchActivateKeys(keys);
        if (keys.size() != reactivatedCount) {
            LOGGER.log(Level.INFO, "Number of Re-Activated keys (" + keys.size() + ")" +
                    " is not the same as Number of deleted keys (" + reactivatedCount + ")");
        }
        return keys.size();
    }
}

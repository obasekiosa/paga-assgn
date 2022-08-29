package com.example.pagaassgn;

import com.example.pagaassgn.kgs.KGS;
import com.example.pagaassgn.kgs.KeyCollisionException;
import com.example.pagaassgn.pastebin.PastebinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AppServices {

    @Autowired
    private KGS kgs;

    @Autowired
    private PastebinService pastebinService;

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public int generateKeys(int availableMax) {
        if (availableMax <= 0) return 0;

        int numOfKeys = availableMax - kgs.getNumberOfInactiveKeys();

        if (numOfKeys <= 0 ) return  0;

        int collisionCount = 0;
        for (int i = 0; i < numOfKeys; i++) {
            try {
                kgs.generateNewKey();

            } catch (KeyCollisionException e) {
                LOGGER.warning("Key collision occurred. Collision Count: " + (++collisionCount));
            } catch (Exception e) {
                LOGGER.severe("Unexpected error");
            }
        }

        int numOfAddedKeys = numOfKeys - collisionCount;
        LOGGER.info("Added " + numOfAddedKeys + " new key" + (numOfAddedKeys > 1 ? "s.": ".") );

        return numOfAddedKeys;
    }

    public int removeExpiredBins() {
        List<String> keys = pastebinService.deleteExpiredPasteBins();
        int reactivatedCount = kgs.batchActivateKeys(keys);

        LOGGER.info("Removed " + keys.size() + " key" + (keys.size() > 1 ? "s.": "."));
        LOGGER.info("Reactivated " + reactivatedCount + " key" + (reactivatedCount > 1 ? "s.": "."));

        if (keys.size() != reactivatedCount) {
            LOGGER.warning("Number of Re-Activated keys (" + keys.size() + ")" +
                    " is not the same as Number of deleted keys (" + reactivatedCount + ")");
        }

        return keys.size();
    }
}

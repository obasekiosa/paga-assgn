package com.example.pagaassgn;

import com.example.pagaassgn.kgs.KGS;
import com.example.pagaassgn.kgs.KeyCollisionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class AppServices {

    @Autowired
    private static KGS kgs;

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
}

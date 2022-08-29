package com.example.pagaassgn.kgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

@Service
public class KGS {
    private KeyRepository keyRepository;


    private int KEY_LENGTH = 6;

    @Autowired
    public KGS(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    public Key getUnusedKey() {

        return null;
    }

    private String byteToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%X", b));

            if (sb.length() >= this.KEY_LENGTH) {
                break;
            }
        }

        return sb.substring(0, this.KEY_LENGTH).toString();
    }

    public Key generateNewKey() throws KeyCollisionException {
        String uuid = null;
        try {
            MessageDigest salt = null;
            try {
                salt = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));

            uuid = byteToHex(salt.digest());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // check for collision here //

        Key key = new Key(uuid, false);
        return this.keyRepository.save(key);
    }

    public boolean deleteKey(Key key) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean deactivateKey(Key key) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean activateKey(String key) {
        Optional<Key> keyEntry = keyRepository.findById(key);
        if (keyEntry.isPresent() ) {
            Key keyValue = keyEntry.get();
            if (!keyValue.isActive()) {
                keyValue.setActive(true);
                keyRepository.save(keyValue);
            }
            return true;
        }

        return false;
    }

    public Key getKey(String key) {
        Optional<Key> keyEntry = keyRepository.findById(key);
        if (keyEntry.isPresent()) {
            return  keyEntry.get();
        }

        return null;
    }


}

package com.example.pagaassgn.kgs;

import org.springframework.beans.factory.annotation.Autowired;

public class KGS {
    private KeyRepository keyRepository;

    @Autowired
    public KGS(KeyRepository repository) {
        this.keyRepository = repository;
    }

    public Key getUnusedKey() {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public Key generateNewKey() {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean deleteKey(Key key) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean deactivateKey(Key key) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public boolean activateKey(Key key) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }
}

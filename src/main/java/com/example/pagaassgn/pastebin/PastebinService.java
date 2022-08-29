package com.example.pagaassgn.pastebin;

import org.springframework.beans.factory.annotation.Autowired;

public class PastebinService {

    private UserRepository userRepository;
    private PastebinRepository pastebinRepository;

    @Autowired
    public PastebinService(UserRepository userRepository, PastebinRepository pastebinRepository) {

        this.userRepository = userRepository;
        this.pastebinRepository = pastebinRepository;
    }





}

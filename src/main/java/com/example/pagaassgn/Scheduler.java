package com.example.pagaassgn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

//    @Value("#{app.config.max_inactive_keys:#{100}")
    @Value("#{new Integer('${app.config.max_inactive_keys:100}')}")
    private Integer MAX_AVAILABLE_KEYS;

    @Autowired
    private AppServices appServices;

    // run every 12 hrs
    @Scheduled(cron = "${app.schedule.cron.generate_keys}")
    public void generateKeys() {
        appServices.generateKeys(MAX_AVAILABLE_KEYS);
    }

    // run every minute
    @Scheduled(cron = "${app.schedule.cron.expired_bins}")
    public void removedExpiredBins() {
        appServices.removeExpiredBins();
    }
}

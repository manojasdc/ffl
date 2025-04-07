package com.BisagN.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class HitCounter {
    private int totalHits;
    private int hitsToday;
    private LocalDate lastUpdateDate;

    public HitCounter() {
        this.totalHits = 0;
        this.hitsToday = 0;
        this.lastUpdateDate = LocalDate.now();
    }

    public synchronized void increment() {
        totalHits++;
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(lastUpdateDate)) {
            hitsToday = 0;
            lastUpdateDate = currentDate;
        }
        hitsToday++;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getHitsToday() {
        return hitsToday;
    }
}
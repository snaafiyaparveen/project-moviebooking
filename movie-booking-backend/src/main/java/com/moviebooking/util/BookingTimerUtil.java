package com.moviebooking.util;

import java.time.Duration;
import java.time.LocalDateTime;

public class BookingTimerUtil {

    private static final int LOCK_DURATION = 10;

    public static boolean isLockExpired(String lockedAt) {

        LocalDateTime lockTime = DateUtil.parse(lockedAt);
        LocalDateTime now = LocalDateTime.now();

        return Duration.between(lockTime, now).toMinutes() >= LOCK_DURATION;
    }

    public static LocalDateTime getExpiryTime(String lockedAt) {

        LocalDateTime lockTime = DateUtil.parse(lockedAt);
        return lockTime.plusMinutes(LOCK_DURATION);
    }
}

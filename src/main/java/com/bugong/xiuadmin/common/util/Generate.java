package com.bugong.xiuadmin.common.util;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Generate {

    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    public static Date getNow() {

        return Date.from(Instant.now(AppClock.getClock()));
    }
}

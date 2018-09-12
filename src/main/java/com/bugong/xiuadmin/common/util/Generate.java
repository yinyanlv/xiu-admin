package com.bugong.xiuadmin.common.util;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Generate {

    public static Date getNow() {
        return Date.from(Instant.now(AppClock.getClock()));
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

package com.bugong.xiuadmin.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class Generate {

    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    public static Date getNow() {

        try {
            SimpleDateFormat dateFormatUtc = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
            dateFormatUtc.setTimeZone(TimeZone.getTimeZone("UTC"));

            SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

            return dateFormatLocal.parse(dateFormatUtc.format(Date.from(Instant.now(AppClock.getClock()))));
        } catch (ParseException e) {

            throw new RuntimeException(e);
        }
    }
}

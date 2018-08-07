package com.bugong.xiuadmin.common.util;

import java.time.Clock;

public class AppClock {

    private static ThreadLocal<Clock> clock = ThreadLocal.withInitial(Clock::systemDefaultZone);

    public static Clock getClock() {
        return clock.get();
    }

    public static void setClock(Clock clock) {
        AppClock.setClock(clock);
    }
}

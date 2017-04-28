package com.wlz.rxretrofit;

import com.hwangjr.rxbus.Bus;

/**
 * Created by WaiLynnZaw on 4/28/17.
 */

public class RxBusProvider {

    private static Bus sBus;

    public static synchronized Bus get() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}

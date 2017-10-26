package com.managePatient.Key;

import java.util.UUID;

/**
 * Created by tmoshasha on 2017/10/13.
 */
public class Generator {
    public static String getEntityId() {
        return UUID.randomUUID().toString();
    }
}

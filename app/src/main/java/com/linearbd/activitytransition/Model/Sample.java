package com.linearbd.activitytransition.Model;

import android.support.annotation.ColorRes;

import java.io.Serializable;

/**
 * Created by Genius 03 on 8/27/2017.
 */

public class Sample implements Serializable {
    final int color;
    private final String name;

    public Sample(@ColorRes int color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}

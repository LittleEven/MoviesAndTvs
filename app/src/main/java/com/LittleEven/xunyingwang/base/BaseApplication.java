package com.LittleEven.xunyingwang.base;

import android.app.Application;
import android.graphics.Typeface;

import java.lang.reflect.Field;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFont();
    }

    private void initFont() {
        Typeface fz = Typeface.createFromAsset(getAssets(), "yuan.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("SERIF");
            field.setAccessible(true);
            field.set(null, fz);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

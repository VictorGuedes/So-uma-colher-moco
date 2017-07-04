package br.edu.utfpr.md.umacolher.config;

import android.hardware.SensorManager;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

/**
 * Created by victor on 20/06/17.
 */

public class DeviceSettings {

    private static SensorManager sensormanager;

    public static void setSensorManager(SensorManager sensorManagerRef) {
        sensormanager = sensorManagerRef;
    }

    public static CGPoint screenResolution(CGPoint gcPoint) {
        return gcPoint;
    }

    public static float screenWidth() {
        return winSize().width;
    }

    public static float screenHeight() {
        return winSize().height;
    }

    public static CGSize winSize() {
        return CCDirector.sharedDirector().winSize();
    }

    public static SensorManager getSensormanager() {
        return sensormanager;
    }


}

package com.seamlessly.utilities;

public class BrowserUtility {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {

        }
    }



}

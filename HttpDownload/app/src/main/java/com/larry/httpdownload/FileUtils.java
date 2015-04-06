package com.larry.httpdownload;

import android.os.Environment;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by heart-blood on 2015/3/29.
 */
public class FileUtils {
    private String SDCARD_PATH;

    public FileUtils() {
        SDCARD_PATH = Environment.getExternalStorageDirectory() + "/";
    }
    public String getSDCARD_PATH() {
        return SDCARD_PATH;
    }

    public void write2sd(String str, InputStream is) {
        try {
            byte[] buffer = new byte[1024];
            FileOutputStream fileOut = new FileOutputStream(SDCARD_PATH + str);
            while (is.read(buffer) != -1) {
                fileOut.write(buffer);
            }
            System.out.println("complete write");
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

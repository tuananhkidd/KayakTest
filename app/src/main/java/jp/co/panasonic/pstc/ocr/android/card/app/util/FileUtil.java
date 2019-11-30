package jp.co.panasonic.pstc.ocr.android.card.app.util;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    public static void saveDictionaryAndLicenseFile(Activity activity, String fileName) {
        AssetManager assetManager = activity.getAssets();
        InputStream input;
        try {
            input = assetManager.open(fileName);

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/data/jp.co.panasonic.pstc.ocr");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, fileName);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(buffer);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

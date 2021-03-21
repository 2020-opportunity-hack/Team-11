package com.ichangemycity.ichangemycommunity.utils.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.ichangemycity.ichangemycommunity.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CameraUtils {

    static final int REQUEST_CODE_PERMISSIONS = 10;
    static final int REQUEST_EXTERNAL_STORAGE = 1;
    static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    static final double RATIO_4_3_VALUE = 4.0 / 3.0;
    static final double RATIO_16_9_VALUE = 16.0 / 9.0;
    static final String CAMERA_PERMISSIONS[] = {Manifest.permission.CAMERA};

    public boolean isCameraPermissionGranted(Activity context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    public void requestCameraPermission(Activity context) {
        ActivityCompat.requestPermissions(
                context, CAMERA_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
    }

    public void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public File createFile(File baseFolder, String format, String extension) {
        return new File(baseFolder, new SimpleDateFormat(format, Locale.US).format(System.currentTimeMillis()) + extension);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public File getOutputDirectory(Context context) {

        Context appContext = context.getApplicationContext();
        String fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
        File mediaStorageDir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), appContext.getResources().getString(R.string.app_name));

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
            Log.d("APP_TAG", "failed to create directory");
        }

        // Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + fileName);

        return file;
        /*Context appContext = context.getApplicationContext();
        File[] mediaDir = context.getExternalMediaDirs();
        if (mediaDir != null) {
            File file = new File(mediaDir[0], appContext.getResources().getString(R.string.app_name));
            return file;
        }
        return appContext.getFilesDir();*/
    }
}

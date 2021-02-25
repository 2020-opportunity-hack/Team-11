package com.ichangemycity.ichangemycommunity.utils.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

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

    public File createFile(File baseFolder, String format, String extension){
         return new File(baseFolder, new SimpleDateFormat(format, Locale.US).format(System.currentTimeMillis()) + extension);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public File getOutputDirectory(Context context) {
        Context appContext = context.getApplicationContext();
        File[] mediaDir = context.getExternalMediaDirs();
        if (mediaDir != null)
            return mediaDir[0];
      return appContext.getFilesDir();
    }
}

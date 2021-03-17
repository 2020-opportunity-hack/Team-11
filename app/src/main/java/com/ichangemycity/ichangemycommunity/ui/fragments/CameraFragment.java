package com.ichangemycity.ichangemycommunity.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

import com.google.common.util.concurrent.ListenableFuture;
import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.ui.listeners.ReplaceInputContainerListener;
import com.ichangemycity.ichangemycommunity.utils.camera.CameraUtils;
import com.ichangemycity.ichangemycommunity.utils.map.MapInputContainerEnum;
import com.ichangemycity.ichangemycommunity.utils.map.SurveyDropDownEnum;
import com.ichangemycity.ichangemycommunity.utils.map.UserClient;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CameraFragment extends Fragment {

    private static final String TAG = CameraFragment.class.getSimpleName();
    private UserClient userClient;
    private ReplaceInputContainerListener replaceInputContainerListener;
    private CameraUtils cameraUtils;
    private Button mCaptureBtn;
    private static final String FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS";
    private static final String PHOTO_EXTENSION = ".jpg";
    Preview preview;
    ImageCapture imageCapture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userClient = (UserClient) getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_activity, null, false);
        cameraUtils = new CameraUtils();
        cameraUtils.verifyStoragePermissions(requireActivity());
        mCaptureBtn = view.findViewById(R.id.camera_capture_button);

        PreviewView previewView = view.findViewById(R.id.viewFinder);
        startCamera(previewView);

        mCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        replaceInputContainerListener = (ReplaceInputContainerListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        replaceInputContainerListener = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void captureImage() {

        File photoFile =  cameraUtils.getOutputDirectory(requireContext()); //cameraUtils.createFile(cameraUtils.getOutputDirectory(requireContext()), FILENAME, PHOTO_EXTENSION);

        ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(photoFile).build();

        imageCapture.takePicture(outputFileOptions, Executors.newSingleThreadExecutor(),
                new ImageCapture.OnImageSavedCallback() {

                    @Override
                    public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
                        Uri savedUri = Uri.fromFile(photoFile);
                    }

                    @Override
                    public void onError(ImageCaptureException error) {
                        Log.d("TAG", error.toString());

                    }
                });
    }

    private void startCamera(PreviewView previewView) {
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreviewAndImageCapture(cameraProvider, previewView);
            } catch (ExecutionException | InterruptedException e) {
                // No errors need to be handled for this Future.
                // This should never be reached.
            }
        }, ContextCompat.getMainExecutor(requireContext()));
    }

    public void bindPreviewAndImageCapture(@NonNull ProcessCameraProvider cameraProvider, PreviewView previewView) {

        preview = new Preview.Builder().build();
        imageCapture = new ImageCapture.Builder().setTargetRotation(previewView.getDisplay().getRotation()).build();


        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        cameraProvider.unbindAll();
        cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, preview, imageCapture);
    }

}

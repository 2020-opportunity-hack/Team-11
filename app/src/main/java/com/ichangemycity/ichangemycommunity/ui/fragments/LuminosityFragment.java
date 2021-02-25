package com.ichangemycity.ichangemycommunity.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.ui.activities.CameraActivity;
import com.ichangemycity.ichangemycommunity.ui.listeners.ReplaceInputContainerListener;
import com.ichangemycity.ichangemycommunity.utils.camera.CameraUtils;
import com.ichangemycity.ichangemycommunity.utils.map.UserClient;

public class LuminosityFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = LuminosityFragment.class.getSimpleName();
    private UserClient userClient;
    private ReplaceInputContainerListener replaceInputContainerListener;

    private Button mOpenCameraBtn;
    private Button mBackHomeBtn;
    private CameraUtils cameraUtils;
    static final int REQUEST_CODE_PERMISSIONS = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userClient = (UserClient) getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_luminosity, null, false);

        mOpenCameraBtn = view.findViewById(R.id.open_camera_button);
        mOpenCameraBtn.setOnClickListener(this::onClick);
        mBackHomeBtn = view.findViewById(R.id.back_home_button);
        mBackHomeBtn.setOnClickListener(this::onClick);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_camera_button:
                cameraUtils = new CameraUtils();
                if (cameraUtils.isCameraPermissionGranted(requireActivity())) {
                    Intent i = new Intent(getActivity(), CameraActivity.class);
                    startActivity(i);
                } else {
                    cameraUtils.requestCameraPermission(requireActivity());
                }
                break;

            case R.id.back_home_button:
                // TODO: action on home button
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (cameraUtils.isCameraPermissionGranted(requireActivity())) {
                Intent i = new Intent(getActivity(), CameraActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(requireActivity(), "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

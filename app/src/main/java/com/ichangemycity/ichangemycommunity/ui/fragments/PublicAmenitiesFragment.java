package com.ichangemycity.ichangemycommunity.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.ui.listeners.ReplaceInputContainerListener;
import com.ichangemycity.ichangemycommunity.utils.camera.CameraUtils;
import com.ichangemycity.ichangemycommunity.utils.map.MapInputContainerEnum;
import com.ichangemycity.ichangemycommunity.utils.map.UserClient;

public class PublicAmenitiesFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = LuminosityFragment.class.getSimpleName();
    private UserClient userClient;
    private ReplaceInputContainerListener replaceInputContainerListener;

    private Button mProceedToLocationBtn;
    private Button mBackHomeBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userClient = (UserClient) getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_public_amenities, null, false);

        mProceedToLocationBtn = view.findViewById(R.id.proceed_to_location);
        mProceedToLocationBtn.setOnClickListener(this::onClick);
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
            case R.id.proceed_to_location:
                userClient.setMapInputContainerEnum(MapInputContainerEnum.PublicAmenitiesProgressFragment);
                replaceInputContainerListener.onReplaceInputContainer();

            case R.id.back_home_button:
                // TODO: action on home button
                break;
        }
    }

}

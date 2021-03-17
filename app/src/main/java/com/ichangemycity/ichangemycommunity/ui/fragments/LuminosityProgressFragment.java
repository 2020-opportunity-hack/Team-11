package com.ichangemycity.ichangemycommunity.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.ui.listeners.ReplaceInputContainerListener;
import com.ichangemycity.ichangemycommunity.utils.camera.CameraUtils;
import com.ichangemycity.ichangemycommunity.utils.map.UserClient;

import static android.content.Context.SENSOR_SERVICE;

public class LuminosityProgressFragment extends Fragment implements View.OnClickListener, SensorEventListener {
    private static final String TAG = LuminosityFragment.class.getSimpleName();
    private UserClient userClient;
    private ReplaceInputContainerListener replaceInputContainerListener;

    private Button mTakeAnotherPhotoBtn;
    private Button mSubmitBtn;
    private ImageView thumbnail;
    private TextView thumbnailText;
    private CameraUtils cameraUtils;
    static final int REQUEST_CODE_PERMISSIONS = 10;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private SensorManager mSensorManager;
    private Sensor mLuminosity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userClient = (UserClient) getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_captured_image, null, false);

        mSensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        mLuminosity = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        thumbnail = view.findViewById(R.id.thumbnail);
        thumbnailText = view.findViewById(R.id.thumbnail_text);
        thumbnail.setImageBitmap(getArguments().getParcelable("thumbnail"));
        mTakeAnotherPhotoBtn = view.findViewById(R.id.take_another_photo_button);
        mTakeAnotherPhotoBtn.setOnClickListener(this::onClick);
        mSubmitBtn = view.findViewById(R.id.submit_luminosity);
        mSubmitBtn.setOnClickListener(this::onClick);

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
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLuminosity, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.take_another_photo_button:

                /**
                 cameraUtils = new CameraUtils();
                if (cameraUtils.isCameraPermissionGranted(requireActivity())) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                } else {
                    cameraUtils.requestCameraPermission(requireActivity());
                }
                break; **/

            case R.id.submit_luminosity:
                // TODO: action on home button
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(requireActivity(), "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(requireActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            thumbnail.setImageBitmap(photo);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            float currentReading = sensorEvent.values[0];
            thumbnailText.setText(currentReading + " Lumens");
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

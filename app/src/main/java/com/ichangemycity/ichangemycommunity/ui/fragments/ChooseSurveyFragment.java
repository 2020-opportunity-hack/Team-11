package com.ichangemycity.ichangemycommunity.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.ui.listeners.ReplaceInputContainerListener;
import com.ichangemycity.ichangemycommunity.utils.map.MapInputContainerEnum;
import com.ichangemycity.ichangemycommunity.utils.map.UserClient;

public class ChooseSurveyFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = LuminosityFragment.class.getSimpleName();
    private UserClient userClient;
    private ReplaceInputContainerListener replaceInputContainerListener;

    private Button mToiletsBtn;
    private Button mSeatingBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userClient = (UserClient) getContext().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_survey, null, false);
        mToiletsBtn = view.findViewById(R.id.take_survey_toilets_button);
        mToiletsBtn.setOnClickListener(this::onClick);
        mSeatingBtn = view.findViewById(R.id.take_survey_seating_button);
        mSeatingBtn.setOnClickListener(this::onClick);

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
            case R.id.take_survey_toilets_button:
                //TODO: Call to backend to fetch questions
                userClient.setMapInputContainerEnum(MapInputContainerEnum.SurveyQuestionsFragment);
                replaceInputContainerListener.onReplaceInputContainer();
                break;

            case R.id.take_survey_seating_button:
                //TODO: Call to backend to fetch questions
                userClient.setMapInputContainerEnum(MapInputContainerEnum.SurveyQuestionsFragment);
                replaceInputContainerListener.onReplaceInputContainer();
                break;

        }
    }
}

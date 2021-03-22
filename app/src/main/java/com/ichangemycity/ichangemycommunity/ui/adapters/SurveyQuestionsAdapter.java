package com.ichangemycity.ichangemycommunity.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.model.LuminosityRowItem;
import com.ichangemycity.ichangemycommunity.model.SurveyQuestions;

public class SurveyQuestionsAdapter extends RecyclerView.Adapter<SurveyQuestionsAdapter.ViewHolder> {

    private SurveyQuestions surveyQuestions[];

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView question;
        private final RadioGroup options;

        public ViewHolder(View view) {
            super(view);
            options = view.findViewById(R.id.thumbnail);
            question = view.findViewById(R.id.thumbnail_text);
        }

        public TextView getQuestion() {
            return question;
        }

        public RadioGroup getOptions() {
            return options;
        }
    }

    public SurveyQuestionsAdapter(SurveyQuestions surveyQuestions[]) {
        this.surveyQuestions = surveyQuestions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        /*holder.options.setImageBitmap(surveyQuestions[position].getImage());
        holder.question.setText(surveyQuestions[position].getLumens() + " Lumens");*/
    }

    @Override
    public int getItemCount() {
        return surveyQuestions.length;
    }
}

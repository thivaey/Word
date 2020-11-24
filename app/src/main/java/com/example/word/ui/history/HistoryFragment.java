package com.example.word.ui.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;
import com.example.word.handleInvitation.ReactionActivity;
import com.example.word.ui.newchallenge.NewChallengeViewModel;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        Challenge[] invitations = DataUtils.getPendingInvitation(DataUtils.getCurrUser());
        System.out.println(invitations.length);

        TextView description1 = (TextView) root.findViewById(R.id.history_description1);
        TextView date1 = (TextView) root.findViewById(R.id.history_date1);
        TextView challenger1 = (TextView) root.findViewById(R.id.history_challenger1);
        TextView description2 = (TextView) root.findViewById(R.id.history_description2);
        TextView date2 = (TextView) root.findViewById(R.id.history_date2);
        TextView challenger2 = (TextView) root.findViewById(R.id.history_challenger2);
        LinearLayout challenge1 = (LinearLayout) root.findViewById(R.id.history_1);
        LinearLayout challenge2 = (LinearLayout) root.findViewById(R.id.history_2);

        if (invitations.length > 0) {

            description1.setText(invitations[0].getDescription());

            if (invitations[0].getStatus() == Challenge.SEND)
                challenger1.setText("@" + invitations[0].getChallenger() + " Challenged you:");
            else
                challenger1.setText("@" + invitations[0].getChallenged() + "'s Counter Challenge:");
            date1.setText(invitations[0].getEndDate());
        } else challenge1.setVisibility(View.GONE);

        if (invitations.length > 1) {
            description2.setText(invitations[1].getDescription());

            if (invitations[1].getStatus() == Challenge.SEND)
                challenger2.setText("@" + invitations[1].getChallenger() + " Challenged you:");
            else
                challenger2.setText("@" + invitations[1].getChallenged() + "'s Counter Challenge:");
            date2.setText(invitations[1].getEndDate());
        } else challenge2.setVisibility(View.GONE);
        return root;
    }
}

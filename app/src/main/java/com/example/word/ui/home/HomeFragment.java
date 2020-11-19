package com.example.word.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.word.R;
import com.example.word.ResolutionActivity;
import com.example.word.ResolveActivity;
import com.example.word.SettlementWinActivity;
import com.example.word.WinningActivity;
import com.example.word.WinningResolutionActivity;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        String username = getActivity().getIntent().getStringExtra("username");
        String username = DataUtils.getCurrUser();

        Challenge[] active_challenges = DataUtils.getActiveChallenge(username);

        TextView challenger1 = (TextView) root.findViewById(R.id.active_challenges_challenger1);
        TextView description1 = (TextView) root.findViewById(R.id.active_challenges_description1);
        TextView date1 = (TextView) root.findViewById(R.id.active_challenges_date1);

        TextView challenger2 = (TextView) root.findViewById(R.id.active_challenges_challenger2);
        TextView description2 = (TextView) root.findViewById(R.id.active_challenges_description2);
        TextView date2 = (TextView) root.findViewById(R.id.active_challenges_date2);

        Challenge[] unresolved_challenges = DataUtils.getUnresolvedChallenge(username);

        TextView un_challenger1 = (TextView) root.findViewById(R.id.unresolved_challenges_challenger1);
        TextView un_description1 = (TextView) root.findViewById(R.id.unresolved_challenges_description1);
        TextView un_date1 = (TextView) root.findViewById(R.id.unresolved_challenges_date1);

        Challenge[] pending_challenges = DataUtils.getUnresolvedChallenge(username);

        TextView pend_challenger1 = (TextView) root.findViewById(R.id.pending_challenges_challenger1);
        TextView pend_description1 = (TextView) root.findViewById(R.id.pending_challenges_description1);
        TextView pend_date1 = (TextView) root.findViewById(R.id.pending_challenges_date1);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                challenger1.setText(active_challenges[0].getChallenger());
                description1.setText(active_challenges[0].getDescription());
                date1.setText("End Date:  " + active_challenges[0].getEndDate());
                ((LinearLayout)root.findViewById(R.id.active_challenges_1)).setOnClickListener(HomeFragment.this);

                challenger2.setText(active_challenges[1].getChallenger());
                description2.setText(active_challenges[1].getDescription());
                date2.setText("End Date:  " + active_challenges[1].getEndDate());
                ((LinearLayout)root.findViewById(R.id.active_challenges_2)).setOnClickListener(HomeFragment.this);

                un_challenger1.setText(unresolved_challenges[0].getChallenger());
                un_description1.setText(unresolved_challenges[0].getDescription());
                un_date1.setText("End Date:  " + unresolved_challenges[0].getEndDate());
                ((LinearLayout)root.findViewById(R.id.unresolved_challenges_1)).setOnClickListener(HomeFragment.this);

                pend_challenger1.setText(unresolved_challenges[0].getChallenger());
                pend_description1.setText(unresolved_challenges[0].getDescription());
                pend_date1.setText("End Date:  " + unresolved_challenges[0].getEndDate());
                ((LinearLayout)root.findViewById(R.id.pending_challenges_1)).setOnClickListener(HomeFragment.this);

            }
        });
        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.unresolved_challenges_1){
            startActivity(new Intent(getActivity(), SettlementWinActivity.class));
        } else if (view.getId() == R.id.pending_challenges_1) {
            startActivity(new Intent(getActivity(), WinningActivity.class));
        } else {
            Intent intent = new Intent(getActivity(), ResolveActivity.class);
            startActivity(intent);
        }

    }
}
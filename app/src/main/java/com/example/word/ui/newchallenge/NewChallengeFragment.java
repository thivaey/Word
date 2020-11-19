package com.example.word.ui.newchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.MainActivity;
import com.example.word.R;
import com.example.word.data.DataUtils;

import java.util.List;

public class NewChallengeFragment extends Fragment implements View.OnClickListener {

    private NewChallengeViewModel newChallengeViewModel;

    private String username;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newChallengeViewModel =
                new ViewModelProvider(this).get(NewChallengeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_challenge, container, false);
//        final TextView textView = root.findViewById(R.id.text_new_challenge);
//        ListView listView = root.findViewById(R.id.new_challenge_friend_list);
        newChallengeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

//        username = getActivity().getIntent().getExtras().getString("username");
        username = DataUtils.getCurrUser();
        Button friend1 = (Button) root.findViewById(R.id.new_challenge_friend1);
        Button friend2 = (Button) root.findViewById(R.id.new_challenge_friend2);
        Button friend3 = (Button) root.findViewById(R.id.new_challenge_friend3);
        Button friend4 = (Button) root.findViewById(R.id.new_challenge_friend4);
        Button friend5 = (Button) root.findViewById(R.id.new_challenge_friend5);
        Button friend6 = (Button) root.findViewById(R.id.new_challenge_friend6);
        Button friend7 = (Button) root.findViewById(R.id.new_challenge_friend7);
        Button friend8 = (Button) root.findViewById(R.id.new_challenge_friend8);
        Button friend9 = (Button) root.findViewById(R.id.new_challenge_friend9);
        Button friend10 = (Button) root.findViewById(R.id.new_challenge_friend10);

        friend1.setOnClickListener(this);
        friend2.setOnClickListener(this);
        friend3.setOnClickListener(this);
        friend4.setOnClickListener(this);
        friend5.setOnClickListener(this);
        friend6.setOnClickListener(this);
        friend7.setOnClickListener(this);
        friend8.setOnClickListener(this);
        friend9.setOnClickListener(this);
        friend10.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String friendName = button.getText().toString();

        Intent intent = new Intent(getContext(), NewChallengeActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("friendName", friendName);
        getContext().startActivity(intent);

    }
}
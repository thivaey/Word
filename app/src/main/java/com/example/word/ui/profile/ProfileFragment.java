package com.example.word.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.User;
import com.example.word.ui.newchallenge.NewChallengeActivity;

import static com.example.word.data.DataUtils.getUser;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final TextView fullNameTextView = root.findViewById(R.id.profile_full_name);
        final TextView userNameTextView = root.findViewById(R.id.profile_user_name);
        final TextView ratingTextView = root.findViewById(R.id.profile_rating);

        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                String curr_user = DataUtils.getCurrUser();
                User user = getUser(curr_user);

                fullNameTextView.setText(user.getFullName());
                userNameTextView.setText(curr_user);
                ratingTextView.setText(String.valueOf(user.getRating()) + "★");
            }
        });

        return root;
    }
}
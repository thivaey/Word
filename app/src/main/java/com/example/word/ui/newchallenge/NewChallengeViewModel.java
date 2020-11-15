package com.example.word.ui.newchallenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewChallengeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewChallengeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the new challenge fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
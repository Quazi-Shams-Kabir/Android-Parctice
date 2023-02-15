package com.example.navigationdrawerdemo.ui.personalDocs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalDocsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PersonalDocsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is docs fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.navigationdrawerdemo.ui.personalDocs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.navigationdrawerdemo.databinding.FragmentPersonaldocsBinding;

public class PersonalDocsFragment extends Fragment {

    private FragmentPersonaldocsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PersonalDocsViewModel personalDocsViewModel =
                new ViewModelProvider(this).get(PersonalDocsViewModel.class);

        binding = FragmentPersonaldocsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDocs;
        personalDocsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
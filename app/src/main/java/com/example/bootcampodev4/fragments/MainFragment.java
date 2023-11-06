package com.example.bootcampodev4.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bootcampodev4.R;
import com.example.bootcampodev4.databinding.FragmentMainBinding;
import com.google.android.material.snackbar.Snackbar;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);

        binding.buttonAFromMain.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(MainFragmentDirections.mainToA());
        });

        binding.buttonXFromMain.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(MainFragmentDirections.mainToX());
        });

        OnBackPressedCallback backPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Snackbar.make(binding.textViewMain,"Uygulamadan çıkmak istiyor musunuz?",
                        Snackbar.LENGTH_SHORT).setAction("Evet",v -> {
                            setEnabled(false);
                            requireActivity().getOnBackPressedDispatcher().onBackPressed();
                }).show();
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),backPressedCallback);


        return binding.getRoot();
    }
}
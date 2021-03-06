package com.example.androidjetpacknavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_first_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_boolean", true);

        final NavController navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.my_nav_host_fragment);

        Button button = view.findViewById(R.id.button1_frag1);
        button.setOnClickListener(view1 -> navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle));

        //#1
        /*View.OnClickListener s = Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment);

        Button button = view.findViewById(R.id.button_frag1);
        button.setOnClickListener(s);*/

        //#2
        /*final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });*/

        //#3
        /*final NavDirections navDirections = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(navDirections);
            }
        });*/

    }

}

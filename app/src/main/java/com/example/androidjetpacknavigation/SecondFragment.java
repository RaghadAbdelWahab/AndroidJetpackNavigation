package com.example.androidjetpacknavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.button_frag2);
        button.setOnClickListener(view1 -> {
            /*All you need to do is to create navigation graph for your app and call navigate method of NavController
            by passing Destination ID or Action ID on user action(like button press)
            and it will take care of either fragment transaction or starting activity depending on your destination.
            Would show you how all this can be implemented */
            final NavController navController = Navigation.findNavController(Objects.requireNonNull(SecondFragment.this.getActivity()), R.id.my_nav_host_fragment);
            navController.navigateUp();

            navController.addOnDestinationChangedListener((controller, destination, arguments) -> Log.d("TAG", destination.getLabel() + " "));

            /* Old functions for the pre-1.0 alpha
            navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
                @Override
                public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                    Log.d("TAG", destination.getLabel() + " ");
                }
            });*/
        });
    }

}
package com.example.resturantraterapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RestaurantFragment extends Fragment {

    private DishViewModel viewModel;
    private TextView tvLastDish;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLastDish = view.findViewById(R.id.tvLastDish);

        viewModel = new ViewModelProvider(requireActivity()).get(DishViewModel.class);

        viewModel.getDishName().observe(getViewLifecycleOwner(), name -> updateDishInfo());
        viewModel.getDishType().observe(getViewLifecycleOwner(), type -> updateDishInfo());
        viewModel.getDishRating().observe(getViewLifecycleOwner(), rating -> updateDishInfo());
    }

    private void updateDishInfo() {
        String name = viewModel.getDishName().getValue();
        String type = viewModel.getDishType().getValue();
        Float rating = viewModel.getDishRating().getValue();

        if (name != null && type != null && rating != null) {
            tvLastDish.setText("Last Rated Dish:\n" +
                    name + " (" + type + ")\nRating: " + ratin);
            tvLastDish.setVisibility(View.VISIBLE);
        }
    }
}

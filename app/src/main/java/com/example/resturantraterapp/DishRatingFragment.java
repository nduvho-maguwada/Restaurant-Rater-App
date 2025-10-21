package com.example.resturantraterapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

public class DishRatingFragment extends Fragment {

    private DishViewModel viewModel;
    private TextInputEditText etDishName;
    private Spinner spinnerDishType;
    private RatingBar ratingBarDish;
    private Button btnSubmitDish;
    private TextView tvDishInfo;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dish_rating, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etDishName = view.findViewById(R.id.etDishName);
        spinnerDishType = view.findViewById(R.id.spinnerDishType);
        ratingBarDish = view.findViewById(R.id.ratingBarDish);
        btnSubmitDish = view.findViewById(R.id.btnSubmitDish);
        tvDishInfo = view.findViewById(R.id.tvDishInfo);

        viewModel = new ViewModelProvider(requireActivity()).get(DishViewModel.class);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.dish_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDishType.setAdapter(adapter);

        btnSubmitDish.setOnClickListener(v -> {
            String name = etDishName.getText().toString();
            String type = spinnerDishType.getSelectedItem().toString();
            float rating = ratingBarDish.getRating();

            viewModel.setDishInfo(name, type, rating);

            tvDishInfo.setText("Dish: " + name + "\nType: " + type + "\nRating: " + rating);
            tvDishInfo.setVisibility(View.VISIBLE);
        });
    }

}

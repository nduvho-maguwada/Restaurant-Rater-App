package com.example.resturantraterapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DishViewModel extends ViewModel {

    private final MutableLiveData<String> dishName = new MutableLiveData<>();
    private final MutableLiveData<String> dishType = new MutableLiveData<>();
    private final MutableLiveData<Float> dishRating = new MutableLiveData<>();

    public void setDishInfo(String name, String type, float rating) {
        dishName.setValue(name);
        dishType.setValue(type);
        dishRating.setValue(rating);
    }

    public LiveData<String> getDishName() { return dishName; }
    public LiveData<String> getDishType() { return dishType; }
    public LiveData<Float> getDishRating() { return dishRating; }
}

package com.example.androidarchitecturepractice.ui.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidarchitecturepractice.R;
import com.example.androidarchitecturepractice.repos.MainRepository;
import com.example.androidarchitecturepractice.repos.util.Observer;
import com.example.androidarchitecturepractice.ui.state_holders.EditFragmentState;

public class EditViewModel extends ViewModel
{
    /**
     * View models are the bridge between the ui elements and the data layer.
     *
     * View models have access to the data layer only through repositories.
     *
     * As the view model, we know which kinds of data we will need for our ui element, therefore,
     * we know which repo(s) we need.
     *
     * In this case, we know we need the MainRepository, which by its name, indicates that it
     * can give us access to general data for the app.
     *
     * We expect this repository to be application wide, therefore we cannot create a new one,
     * and must have it passed.
     */
    private MainRepository repo;

    private final MutableLiveData<EditFragmentState> state;


    public EditViewModel(MainRepository repo)
    {
        this.repo =repo;
        state = new MutableLiveData<>(null);
        repo.getCurrentColor().subscribe(new Observer<Integer>()
        {
            @Override
            public void update(Integer data)
            {
                EditFragmentState newState = new EditFragmentState(data);
                state.setValue(newState);
            }
        });
    }

    public LiveData<EditFragmentState> getState()
    {
        return state;
    }

    public void clickBlueButton()
    {
        // Makes the color change persist for app life, not just fragment life.
        repo.setCurrentColor(R.color.blue);
    }

    public void clickGreenButton()
    {
        repo.setCurrentColor(R.color.green);
    }

    public void clickRedButton()
    {
        repo.setCurrentColor(R.color.red);
    }

    public void clickClearButton()
    {
        repo.setCurrentColor(R.color.white);
    }
}

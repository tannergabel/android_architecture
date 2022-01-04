package com.example.androidarchitecturepractice.ui.elements;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidarchitecturepractice.AppContainer;
import com.example.androidarchitecturepractice.MyMainApplication;
import com.example.androidarchitecturepractice.R;
import com.example.androidarchitecturepractice.repos.MainRepository;
import com.example.androidarchitecturepractice.ui.view_models.EditViewModel;

public class EditFragment extends Fragment
{
    /**
     * Since this fragment will have some sort of business logic, we require the use
     * of a view model.
     *
     * We expect the model to provide us with some sort of "state holder" which we use to define
     * what we display to the user.
     *
     * A state holder will be a simple java class with fields that we can use to determine what
     * we display, such as an EditFragmentState object.
     *
     * We expect that our view model will allow us to observe one of these state holder objects
     * so we can automatically update once the state changes.
     *
     * It is our duty as the ui element to notify the view model of user events, such as a button
     * click.
     *
     * To do this, we expect that our view model has methods for us to call in specific events.
     *
     * It is also our duty to handle navigation. Once again, we can determine this information
     * from the state holder.
     */
    private EditViewModel viewModel;

    private TextView target;
    private Button btnBlue, btnRed, btnGreen, btnClear;

    public EditFragment()
    {
        super(R.layout.fragment_edit);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // The model takes a repository which is most likely contained in our app container.
        viewModel = new EditViewModel(getMainRepository());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        findViews(view);

        viewModel.getState().observe(getViewLifecycleOwner(), editFragmentState ->
                target.setBackgroundColor(getResources().getColor(
                        editFragmentState.getTargetColorId(),
                        null
                )));

        assignOnClickListeners();
    }

    private void assignOnClickListeners()
    {
        btnBlue.setOnClickListener(view1 -> viewModel.clickBlueButton());
        btnGreen.setOnClickListener(view12 -> viewModel.clickGreenButton());
        btnRed.setOnClickListener(view13 -> viewModel.clickRedButton());
        btnClear.setOnClickListener(view14 -> viewModel.clickClearButton());
    }

    private void findViews(View parentView)
    {
        target = parentView.findViewById(R.id.txt_target);
        btnBlue = parentView.findViewById(R.id.btn_blue);
        btnGreen = parentView.findViewById(R.id.btn_green);
        btnRed = parentView.findViewById(R.id.btn_red);
        btnClear = parentView.findViewById(R.id.btn_clear);
    }

    private MainRepository getMainRepository()
    {
        return getAppContainer().mainRepository;
    }

    private AppContainer getAppContainer()
    {
        /*
        Note that we cannot require the activity as early as the constructor since some lifecycle
        events need to occur before this fragment is added to an activity.
         */
        return ((MyMainApplication) requireActivity().getApplication()).appContainer;
    }
}

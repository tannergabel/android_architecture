package com.example.androidarchitecturepractice.ui.elements;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.androidarchitecturepractice.R;

/**
 * This class is a simple ui with no logic and only navigation, so we do not use a ViewModel here.
 */
public class HomeFragment extends Fragment
{
    private Button btnLetsGo;
    private final static String LOG_TAG = HomeFragment.class.getSimpleName();

    private NavController navController;

    public HomeFragment()
    {
        super(R.layout.fragment_main);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        navController = NavHostFragment.findNavController(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        btnLetsGo = view.findViewById(R.id.btnLetsGo);

        if (btnLetsGo == null)
        {
            Log.e(LOG_TAG, "Could not find btnLetsGo");
        } else
        {
            btnLetsGo.setOnClickListener(view1 ->
            {
                navController.navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment());
            });
        }
    }
}

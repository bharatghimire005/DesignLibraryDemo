package bharatghimire.com.designsupportlibrarydemo.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bharatghimire.com.designsupportlibrarydemo.R;


public class FloatingButton extends Fragment {




    public FloatingButton() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floating_button, container, false);
    }








}

package bharatghimire.com.designsupportlibrarydemo.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bharatghimire.com.designsupportlibrarydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FloatingText extends Fragment {


    public FloatingText() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_floating_text, container, false);
    }


}

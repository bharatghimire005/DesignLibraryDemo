package bharatghimire.com.designsupportlibrarydemo.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bharatghimire.com.designsupportlibrarydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollapsingToolbar extends Fragment {


    public CollapsingToolbar() {
        // Required empty public constructor
    }

    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.fragment_collapsing_toolbar, container, false);

        ((AppCompatActivity) getActivity()). setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
        collapsingToolbarLayout = (CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Collapsing");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        return view;
    }


}

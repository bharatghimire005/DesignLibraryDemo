package bharatghimire.com.designsupportlibrarydemo.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import bharatghimire.com.designsupportlibrarydemo.R;



public class CoordinatorLayoutDemo extends Fragment {

    private FloatingActionButton floatingActionButton;
    private RelativeLayout coordinatorLayout;
    private Button buttonCustom;

int snackbarId;
    public CoordinatorLayoutDemo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_coordinator_layout, container, false);
        coordinatorLayout= (RelativeLayout) view.findViewById(R.id.coordinator_layout);
       floatingActionButton= (FloatingActionButton) view.findViewById(R.id.btnFloatingActionButton);
       // buttonCustom= (Button) view.findViewById(R.id.button_custom_behaviour);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Snackbar.make(coordinatorLayout, "FAB button clicked", Snackbar.LENGTH_LONG).show();
               Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Undo", onClickListener);
                snackbar.setActionTextColor(Color.RED);
                View snackbarView = snackbar.getView();

               snackbarView.setBackgroundColor(Color.DKGRAY);
                snackbar.show();
            }
        });

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         int viewId=v.getId();

            Toast.makeText(getActivity(),"Clicked on Snackbar",Toast.LENGTH_LONG).show();
        }
    };
}

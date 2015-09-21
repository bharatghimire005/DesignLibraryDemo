package bharatghimire.com.designsupportlibrarydemo;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import bharatghimire.com.designsupportlibrarydemo.fragments.CollapsingToolbar;
import bharatghimire.com.designsupportlibrarydemo.fragments.CoordinatorLayoutDemo;
import bharatghimire.com.designsupportlibrarydemo.fragments.FloatingButton;
import bharatghimire.com.designsupportlibrarydemo.fragments.FloatingText;
import bharatghimire.com.designsupportlibrarydemo.fragments.TabLayoutFragement;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView textViewHeader;
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        linkViewbyId();
       // addMenuItem();
        navigationViewItemSelected();
        actionBarToggle();

    }


    private void actionBarToggle() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }


    private void linkViewbyId() {
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigationview);

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        textViewHeader= (TextView) findViewById(R.id.textview_navigation_header);
        textViewHeader.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.textview_navigation_header:
                    Toast.makeText(context,"Header is Clicked",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
    private void navigationViewItemSelected() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        int id = menuItem.getItemId();
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        //noinspection SimplifiableIfStatement
                        switch (id) {
                            case R.id.floating_label:
                                Log.i("Button Clicked", "floating_label");
                                toolbar.setTitle("Floating Label");

                                transaction.replace(R.id.framelayout_container, new FloatingText());
                                transaction.commit();
                                break;
                            case R.id.floating_button:
                                Log.i("Button Clicked", "floating button");
                                transaction.replace(R.id.framelayout_container, new FloatingButton());
                                transaction.commit();
                                break;
                            case R.id.coordinator_layout:
                                Log.i("Button Clicked", "coordinator_layout");
                                transaction.replace(R.id.framelayout_container, new CoordinatorLayoutDemo());
                                transaction.commit();
                                break;
                            case R.id.appbar_layout:
                                Log.i("Button Clicked", "appbar_layout");
                                transaction.replace(R.id.framelayout_container, new TabLayoutFragement());
                                transaction.commit();
                                break;
                            case R.id.collapsing_toolbar:
                                Log.i("Button Clicked", "coordinator_layout");
                                Intent intent =new Intent(context,CollapsingToolbarActivity.class);
                                startActivity(intent);
//                                transaction.replace(R.id.framelayout_container, new CollapsingToolbar());
//                                transaction.commit();
                                break;
                        }
                        return true;
                    }
                }

        );
    }

//Add programatically menu item
 private void addMenuItem() {
     final Menu menu = navigationView.getMenu();
     for (int i = 1; i <= 3; i++) {
         menu.add("Item No. " + i);
     }

     for (int i = 0, count = navigationView.getChildCount(); i < count; i++) {
         final View child = navigationView.getChildAt(i);
         if (child != null && child instanceof ListView) {
             final ListView menuView = (ListView) child;
             final HeaderViewListAdapter adapter = (HeaderViewListAdapter) menuView.getAdapter();
             final BaseAdapter wrapped = (BaseAdapter) adapter.getWrappedAdapter();
             wrapped.notifyDataSetChanged();
         }
     }
 }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (isDrawerOpen()) {
            closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}

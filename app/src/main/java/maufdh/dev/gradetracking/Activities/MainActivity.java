package maufdh.dev.gradetracking.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.github.rubensousa.floatingtoolbar.FloatingToolbar;
import com.github.rubensousa.floatingtoolbar.FloatingToolbarMenuBuilder;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import maufdh.dev.gradetracking.Fragments.HomeFragment;
import maufdh.dev.gradetracking.Fragments.ProfileFragment;
import maufdh.dev.gradetracking.Fragments.SearchFragment;
import maufdh.dev.gradetracking.R;


public class MainActivity extends AppCompatActivity {
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar=(BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.tab_home:
                        HomeFragment homeFragment= new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,homeFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.tab_profile:
                        ProfileFragment profileFragment= new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                        case R.id.tab_search:
                        SearchFragment searchFragment= new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,searchFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }


}

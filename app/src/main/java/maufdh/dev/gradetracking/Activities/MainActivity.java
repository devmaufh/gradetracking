package maufdh.dev.gradetracking.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
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
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar=(BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(R.id.tab_home);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId){
                    case R.id.tab_home:
                       changeFragment(new HomeFragment());
                        changeStatusBarColor(R.color.colorPrimary);
                        break;
                    case R.id.tab_profile:
                        changeFragment(new ProfileFragment());
                        changeStatusBarColor(R.color.colorPrimaryDark);
                        break;
                        case R.id.tab_search:
                            changeFragment(new SearchFragment());
                            changeStatusBarColor(R.color.colorAccent);
                        break;
                }
            }
        });
    }
    private void changeFragment(android.support.v4.app.Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }
    private void changeStatusBarColor(int source){
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(source)));
    }


}

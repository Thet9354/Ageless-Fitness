package com.example.agelessfitness;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.agelessfitness.Adapter.DrawerAdapter;
import com.example.agelessfitness.Fragment.Articles;
import com.example.agelessfitness.Fragment.Home;
import com.example.agelessfitness.Fragment.LeaderBoard;
import com.example.agelessfitness.Fragment.ProgressTracker;
import com.example.agelessfitness.Model.DrawerItem;
import com.example.agelessfitness.Model.SimpleItem;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MaterialToolbar topAppBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();

        pageDirectories();

    }

    private void initUI() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new Home());
        fragmentTransaction.commit();
    }

    private void pageDirectories() {

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id)
                {
                    case R.id.nav_home:
                        //---> Lead to the home page
                        replaceFragment(new Home());
                        break;

                    case R.id.nav_leaderboard:
                        //---> Lead to the planet page
                        replaceFragment(new LeaderBoard());
                        break;

                    case R.id.nav_progressTracker:
                        //---> Lead to the ticket page
                        replaceFragment(new ProgressTracker());
                        break;

                    case R.id.nav_article:
                        //---> Lead to the MyCart page
                        replaceFragment(new Articles());
                        break;

                    case R.id.nav_signOut:
                        System.exit(0);
                        break;

                    case R.id.nav_Exit:
                        System.exit(0);
                        break;

                }
                return false;
            }
        });

    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }


    private void initWidget() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        topAppBar = findViewById(R.id.topAppBar);

        initUI();

    }
}
package com.example.agelessfitness;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.agelessfitness.Adapter.DrawerAdapter;
import com.example.agelessfitness.Fragment.Articles;
import com.example.agelessfitness.Fragment.Home;
import com.example.agelessfitness.Fragment.LeaderBoard;
import com.example.agelessfitness.Fragment.ProgressTracker;
import com.example.agelessfitness.Model.DrawerItem;
import com.example.agelessfitness.Model.SimpleItem;
import com.google.android.material.navigation.NavigationView;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();

        initUI();

        pageDirectories();

    }

    private void initUI() {
        getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, new Home()).commit();

    }

    private void pageDirectories() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        //---> Lead to the home page
                        fragment = new Home();
                        break;

                    case R.id.nav_leaderboard:
                        //---> Lead to the planet page
                        fragment = new LeaderBoard();
                        break;

                    case R.id.nav_progressTracker:
                        //---> Lead to the ticket page
                        fragment = new ProgressTracker();
                        break;

                    case R.id.nav_article:
                        //---> Lead to the MyCart page
                        fragment = new Articles();
                        break;

                    case R.id.nav_signOut:
                        //TODO: SignOut of account
                        break;

                    case R.id.nav_Exit:
                        finish();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, fragment).commit();
                return true;
            }
        });

    }

    private void initWidget() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
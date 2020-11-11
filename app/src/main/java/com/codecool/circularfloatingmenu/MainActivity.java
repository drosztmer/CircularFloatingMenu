package com.codecool.circularfloatingmenu;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab, fabSun, fabCloud, fabMountain;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab_add);
        fabSun = findViewById(R.id.fab_sun);
        fabCloud = findViewById(R.id.fab_cloud);
        fabMountain = findViewById(R.id.fab_mountain);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        fabSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(MainActivity.this, R.string.fab_sun, Toast.LENGTH_SHORT).show();
            }
        });

        fabCloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(MainActivity.this, R.string.fab_cloud, Toast.LENGTH_SHORT).show();
            }
        });

        fabMountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                Toast.makeText(MainActivity.this, R.string.fab_mountain, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animateFab() {
        if (isOpen) {
            fab.startAnimation(rotateBackward);
            fabSun.startAnimation(fabClose);
            fabCloud.startAnimation(fabClose);
            fabMountain.startAnimation(fabClose);

            fabSun.setClickable(false);
            fabCloud.setClickable(false);
            fabMountain.setClickable(false);

            isOpen = false;
        } else {
            fab.startAnimation(rotateForward);
            fabSun.startAnimation(fabOpen);
            fabCloud.startAnimation(fabOpen);
            fabMountain.startAnimation(fabOpen);

            fabSun.setClickable(true);
            fabCloud.setClickable(true);
            fabMountain.setClickable(true);

            isOpen = true;
        }
    }

}
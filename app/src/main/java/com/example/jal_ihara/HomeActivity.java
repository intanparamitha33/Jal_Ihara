package com.example.jal_ihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isMenuVisible = false;
    private View slidingMenu;
    private TextView menuItem1;
    private TextView menuItem2;
    private TextView menuItem3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slidingMenu = findViewById(R.id.slidingMenuLayout);
        menuItem1 = findViewById(R.id.menu1);
        menuItem2 = findViewById(R.id.menu2);
        menuItem3 = findViewById(R.id.menu3);

        ImageView burger = findViewById(R.id.burger);
        TextView logo = findViewById(R.id.logo);

//        Intent fromLogin = getIntent();
//        viewUsername.setText(fromLogin.getStringExtra("username"));

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMenu();
            }
        });

        menuItem1.setOnClickListener(this);
        menuItem2.setOnClickListener(this);
        menuItem3.setOnClickListener(this);
    }

    private void toggleMenu() {
        if (slidingMenu.getVisibility() == View.VISIBLE) {
            slidingMenu.setVisibility(View.GONE);
        } else {
            Animation slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
            slidingMenu.startAnimation(slideDownAnimation);
            slidingMenu.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dropdown_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection for options menu here
//        switch (item.getItemId()) {
//            case R.id.option1:
//                // Handle option 1 click
//                return true;
//            case R.id.option2:
//                // Handle option 2 click
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu1:
                showToast("Clicked: Menu 1");
                break;
            case R.id.menu2:
                showToast("Clicked: Menu 2");
                break;
            case R.id.menu3:
                showToast("Clicked: Menu 3");
                break;
        }
        toggleMenu();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


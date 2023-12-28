package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainMenuActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainLayout = findViewById(R.id.main_layout); // Replace with your main layout ID
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_1) {
            // Add a button dynamically
            addButtonToLayout();
            return true;
        } else if (id == R.id.menu_2) {
            // Handle action for Menu 2
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addButtonToLayout() {
        // Create a new button
        Button dynamicButton = new Button(this);
        dynamicButton.setText("Click me!");

        // Set click listener for the button
        dynamicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainMenuActivity.this, "Hello Android", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the button to the layout
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.topToBottom = R.id.toolbar; // Align below the toolbar
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID; // Align to the left of the parent layout

        mainLayout.addView(dynamicButton, layoutParams);
    }
}
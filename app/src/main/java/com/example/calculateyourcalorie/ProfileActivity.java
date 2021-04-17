package com.example.calculateyourcalorie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private TextView textViewProfileName;
    private TextView textViewProfileGender;
    private TextView textViewProfileTarget;
    private TextView textViewProfileCalorieLimit;
    private Button buttonEdit;
    private Intent intent;
    private Bundle bundle;

    private String ProfileName;
    private String ProfileGender;
    private String ProfileTarget;
    private String ProfileCalorieLimit;


    //
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "name";
    public static final String GENDER = "gender";
    public static final String TARGET = "target";
    public static final String CALORIEliMIT = "calorielimit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        setTitle("Profile");

        intent = this.getIntent();
        bundle = intent.getExtras();

        textViewProfileName = findViewById(R.id.TextView_ProfileName);
        textViewProfileGender = findViewById(R.id.TextView_ProfileGender);
        textViewProfileTarget = findViewById(R.id.TextView_ProfileTarget);
        textViewProfileCalorieLimit = findViewById(R.id.TextView_ProfileCalorieLimit);

        if (bundle != null) {
            textViewProfileName.setText(bundle.getString("name"));
            textViewProfileGender.setText(bundle.getString("gender"));
            textViewProfileTarget.setText(bundle.getString("target"));
            textViewProfileCalorieLimit.setText(bundle.getString("calorielimit"));

            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(NAME, bundle.getString("name"));
            editor.putString(GENDER, bundle.getString("gender"));
            editor.putString(TARGET, bundle.getString("target"));
            editor.putString(CALORIEliMIT, bundle.getString("calorielimit"));
            editor.apply();

        }
        loadData();


        buttonEdit = findViewById(R.id.Button_EditProfile);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editProfile();
            }
        });
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        ProfileName = sharedPreferences.getString(NAME, "");
        ProfileGender = sharedPreferences.getString(GENDER, "");
        ProfileTarget = sharedPreferences.getString(TARGET, "");
        ProfileCalorieLimit = sharedPreferences.getString(CALORIEliMIT, "");

        textViewProfileName.setText(ProfileName);
        textViewProfileGender.setText(ProfileGender);
        textViewProfileTarget.setText(ProfileTarget);
        textViewProfileCalorieLimit.setText(ProfileCalorieLimit);
    }


    public void editProfile() {
        Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivity(intent);
    }
}
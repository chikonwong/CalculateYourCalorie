package com.example.calculateyourcalorie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {
    private EditText SetProfileName;
    private RadioGroup radioGroup;
    private RadioButton SetProfileGender;
    private EditText SetProfileTarget;
    private EditText SetProfileCalorieLimit;
    private Button buttonSave;

    private TextView SetNavHeaderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eidt_profile);
        getSupportActionBar().setTitle("Profile");


//        SetNavHeaderName = findViewById(R.id.TextView_NavHeaderName);


        radioGroup = findViewById(R.id.RadioGroup_Set_Gender);
        SetProfileName = findViewById(R.id.EditText_Edit_ProfileName);
        SetProfileTarget = findViewById(R.id.EditView_Edit_ProfileTarget);
        SetProfileCalorieLimit = findViewById(R.id.EditView_Edit_ProfileCalorieLimit);
        buttonSave = findViewById(R.id.Button_save_Profile);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SetNavHeaderName.setText(SetProfileName.getText().toString());

                saveProfile();
                Toast.makeText(EditProfileActivity.this,
                        "Name : " + SetProfileName.getText().toString() +
                                " Gender : "  + SetProfileGender.getText().toString()+
                                "Target : " + SetProfileTarget.getText().toString() +
                                "CalorieLimit : " + SetProfileCalorieLimit.getText().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        SetProfileGender = findViewById(radioId);

    }
    public void saveProfile(){
        Intent intent = new Intent(EditProfileActivity.this,ProfileActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("name" ,SetProfileName.getText().toString());
        bundle.putString("gender" ,SetProfileGender.getText().toString());
        bundle.putString("target" ,SetProfileTarget.getText().toString());
        bundle.putString("calorielimit" ,SetProfileCalorieLimit.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                SetProfileName.setText(bundle.getString("name"));
                SetProfileGender.setText(bundle.getString("gender"));
                SetProfileTarget.setText(bundle.getString("target"));
                SetProfileCalorieLimit.setText(bundle.getString("calorielimit"));
        }
    }
}

package com.example.calculateyourcalorie;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AddItemActivity extends AppCompatActivity {
    public static final String EXTRA_DATE = "com.example.calculateyourcalorie.EXTRA_DATE";
    public static final String EXTRA_PERIOD = "com.example.calculateyourcalorie.EXTRA_PERIOD";
    public static final String EXTRA_CATEGORY = "com.example.calculateyourcalorie.EXTRA_CATEGORY";
    public static final String EXTRA_FOODNAME = "com.example.calculateyourcalorie.EXTRA_FOODNAME";
    public static final String EXTRA_CALORIES = "com.example.calculateyourcalorie.EXTRA_CALORIES";

    private TextView tvDate;
    private RadioGroup radioGroupPeriod;
    private RadioButton SetItemPeriod;
    private RadioGroup radioGroupCategory;
    private RadioButton SetItemCategory;
    private EditText etFoodName;
    private EditText etCalories;
    private Button buttonAdd;

    DatePickerDialog.OnDateSetListener setListener;

    String systemDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Item");

        tvDate = findViewById(R.id.TextView_Date);
        
        // date picker dialog
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddItemActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);

            }
        };


        // get system date
        tvDate.setText(systemDate);
        radioGroupPeriod = findViewById(R.id.RadioGroup_Period);
        radioGroupCategory = findViewById(R.id.RadioGroup_Category);
        etFoodName = findViewById(R.id.EditText_FoodName);
        etCalories = findViewById(R.id.EditText_Calories);

        buttonAdd = findViewById(R.id.Button_AddData);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                systemDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss ", Locale.getDefault()).format(new Date());
                String date = systemDate;
                String period = SetItemPeriod.getText().toString();
                String category = SetItemCategory.getText().toString();
                String foodname = etFoodName.getText().toString();
                int calories = Integer.parseInt(etCalories.getText().toString());

                Intent data = new Intent();
                data.putExtra(EXTRA_DATE, date);
                data.putExtra(EXTRA_PERIOD, period);
                data.putExtra(EXTRA_CATEGORY, category);
                data.putExtra(EXTRA_FOODNAME, foodname);
                data.putExtra(EXTRA_CALORIES, calories);

                setResult(RESULT_OK, data);
                finish();

                Toast.makeText(AddItemActivity.this,
                        "Date" + tvDate.getText().toString() +
                                " Period : " + SetItemPeriod.getText().toString() +
                                " Catefory : " + SetItemCategory.getText().toString() +
                                " FoodName : " + etFoodName.getText().toString() +
                                " Calories : " + etCalories.getText().toString()
                        , Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onPeriodRadioButtonClicked(View view) {
        int radioId = radioGroupPeriod.getCheckedRadioButtonId();
        SetItemPeriod = findViewById(radioId);
    }

    public void onCategoryRadioButtonClicked(View view) {
        int radioId = radioGroupCategory.getCheckedRadioButtonId();
        SetItemCategory = findViewById(radioId);
    }

}

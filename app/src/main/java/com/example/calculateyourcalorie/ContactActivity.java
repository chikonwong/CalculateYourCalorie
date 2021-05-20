package com.example.calculateyourcalorie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ContactActivity extends AppCompatActivity {
    Button buttonSend;
    String textTo;
    EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        setTitle(getString(R.string.contactUs));

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textTo = "abc@gmail.com";
        textMessage = (EditText) findViewById(R.id.editTextMessage);

        Spinner spinner = findViewById(R.id.editTextSubject);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.emailSubjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String subject = spinner.getSelectedItem().toString();
                String message = textMessage.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{textTo});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
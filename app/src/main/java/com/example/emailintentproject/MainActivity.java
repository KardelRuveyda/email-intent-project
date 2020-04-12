package com.example.emailintentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText editTextTo;
private EditText editTextSubject;
private  EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTo= (EditText) findViewById(R.id.text_to);
        editTextMessage =(EditText) findViewById(R.id.text_message);
        editTextSubject=(EditText) findViewById(R.id.text_subject);

        Button sendMailButton = findViewById(R.id.send_mail);

        sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    sendMailActivty();
            }
        });

    }

    public void sendMailActivty(){
        String recipientList = editTextTo.getText().toString();
        //ruveydakardelcetin@gmail.com, kardelruveydacetin@gmail.com
        String[] recipients = recipientList.split(",");

        String subject =editTextSubject.getText().toString();
        String message = editTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc882");
        startActivity(Intent.createChooser(intent,"Choose an email Clients!"));

    }
}

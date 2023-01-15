package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.UUID;

public class MessageActivity extends AppCompatActivity {

    Button createMessage;
    TextInputEditText messageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        createMessage = findViewById(R.id.createMessageButton);
        messageField = findViewById(R.id.messageTextField);

        FirebaseDatabase database = FirebaseDatabase
                .getInstance("https://chatapplication-71de6-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");

        createMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = String.valueOf(messageField.getText());
                messageField.setText("");
                myRef.setValue(message);
            }
        });
    }
}
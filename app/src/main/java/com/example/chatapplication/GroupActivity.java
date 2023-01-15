package com.example.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GroupActivity extends AppCompatActivity {

    Button createGroup;
    EditText gruopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        createGroup = findViewById(R.id.createGroupButton);
        gruopName = findViewById(R.id.groupNameTextField);

        FirebaseDatabase database = FirebaseDatabase
                .getInstance("https://chatapplication-71de6-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("group");

        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = String.valueOf(gruopName.getText());
                gruopName.setText("");
                myRef.setValue(groupName);
            }
        });
    }
}
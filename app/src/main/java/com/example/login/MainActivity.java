package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               EditText Email = (EditText) findViewById(R.id.email);
               EditText Pass = (EditText) findViewById(R.id.pass);
               String email = Email.getText().toString().trim();
               String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
               if (email.matches(emailPattern)&&email.length()>0&&Pass.length()>=8&&Pass.length()<=30)
               {
                   Intent intent = new Intent(MainActivity.this, Home.class);
                   intent.putExtra("Email", Email.getText()+" ");
                   intent.putExtra("Pass", Pass.getText()+"");
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(getApplicationContext(),"Invalid email address and password ", Toast.LENGTH_SHORT).show();
               }

           }
       });
    }
}

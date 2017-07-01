package com.example.ramiro.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button_login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuar = ((EditText) findViewById(R.id.editText_usuario)).getText().toString();
                String pass = ((EditText) findViewById(R.id.editText_password)).getText().toString();

                if (usuar.equals("") && pass.equals("")) {
                    Toast.makeText(getApplicationContext(),"Escribe algo coño",Toast.LENGTH_SHORT).show();
                }
                else if (usuar.equals("")) {
                    Toast.makeText(getApplicationContext(),"Pon el usuario",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals("")) {
                    Toast.makeText(getApplicationContext(),"Pon la contraseña",Toast.LENGTH_SHORT).show();
                }

                else if (usuar.equals("JonatanBernal") && pass.equals("Jony1234")) {
                    Intent i = new Intent(MainActivity.this,entrada.class);
                    startActivity(i);

                }
                else {
                    Intent i = new Intent(MainActivity.this,error.class);
                    startActivity(i);

                }

            }
        });
    }
}

package com.example.MenuFloatingButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText et_email, et_password;
    Button login;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_main));

        et_email = findViewById(R.id.etEmail);
        et_password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btSignin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();


            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu,
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Memmbuat kondisi jika yang dipilih adalah id mendaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void validasi() {
        email = et_email.getText().toString();
        password = et_password.getText().toString();

        //mengeset email yang benar
        String email = "Fire@mail.com";

        //mengeset passord yang benar
        String pass = "123";

        if (email.equals(email) && password.equals(pass)) {
            Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();



            //membuat objek bundle
            Bundle b = new Bundle();

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("a", email.trim());

            //memasukkan value dari variabel nama dengan kunci "a"
            //dan dimasukkan kedalam bundle
            b.putString("b", password.trim());

            //membuat objek intent berpindah activity dari mainactivity ke activityHasil
            Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

            //memasukkan bundle intent untuk dikirimkan ke ActivityHasil
            i.putExtras(b);

            //berpindah ke ActivityHasil
            startActivity(i);



        } else if (email != (email) && password.equals(pass)) {
            Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();

        } else if (email.equals(email) && password != (pass)) {
            Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
        } else if (email != (email) && password != (pass)) {
            Toast.makeText(MainActivity.this, "Email dan Password Salah", Toast.LENGTH_SHORT).show();

        }
    }
}
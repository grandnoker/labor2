package com.grandnoker.lr2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.duglasher.lr2.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        binding.btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = binding.etNumber.getText().toString();
                String name = binding.etName.getText().toString();
                String surname = binding.etSurname.getText().toString();

                if (Utils.hasEmptyFields(phone, name, surname)) {
                    Toast.makeText(AuthActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.open(AuthActivity.this, phone, name, surname);
                    finish();
                }
            }
        });
    }

}
package com.azhar.ilmuanislam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.azhar.ilmuanislam.R;

public class IntroActivity extends AppCompatActivity {

    Animation one, two;
    Button btnStart;
    TextView txtIntro;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnStart = findViewById(R.id.btn_start);
        txtIntro = findViewById(R.id.txt_intro);
        imgLogo = findViewById(R.id.img_logo);

        // load animation
        one = AnimationUtils.loadAnimation(this, R.anim.one);
        two = AnimationUtils.loadAnimation(this, R.anim.two);

        // run animation
        btnStart.startAnimation(one);
        imgLogo.startAnimation(two);
        txtIntro.startAnimation(two);

    }

    public void start(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}

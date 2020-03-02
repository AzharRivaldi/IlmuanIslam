package com.azhar.ilmuanislam.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.azhar.ilmuanislam.R;
import com.azhar.ilmuanislam.model.MainModel;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "EXTRA_KEY";
    TextView tvName, tvYear, tvDesc;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MainModel dataMain = getIntent().getParcelableExtra(EXTRA_KEY);
        Toolbar tbNotif = findViewById(R.id.toolbar);
        setSupportActionBar(tbNotif);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Ilmuan");

        tvName = findViewById(R.id.tv_name);
        tvYear = findViewById(R.id.tv_year);
        tvDesc = findViewById(R.id.tv_desc);
        imgPhoto = findViewById(R.id.img_photo);

        tvName.setText(dataMain.getName());
        tvYear.setText(dataMain.getYear());
        tvDesc.setText(dataMain.getDesc());

        Glide.with(this)
                .load(dataMain.getPhoto())
                .into(imgPhoto);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

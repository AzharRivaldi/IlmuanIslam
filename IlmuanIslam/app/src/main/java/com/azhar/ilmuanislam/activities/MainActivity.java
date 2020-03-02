package com.azhar.ilmuanislam.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.azhar.ilmuanislam.R;
import com.azhar.ilmuanislam.adapter.MainAdapter;
import com.azhar.ilmuanislam.data.MainData;
import com.azhar.ilmuanislam.model.MainModel;
import com.azhar.ilmuanislam.support.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private SearchView srcView;
    private TextView titleMain, txtFooter;
    private ArrayList<MainModel> list = new ArrayList<>();
    Animation one, two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        srcView = findViewById(R.id.searchView);
        srcView.setQueryHint("Cari Ilmuan");
        titleMain = findViewById(R.id.txt_main);
        txtFooter = findViewById(R.id.txt_footer);
        rvMain = findViewById(R.id.rv_main);
        rvMain.setHasFixedSize(true);

        list.addAll(MainData.getListData());
        showRecyclerList();

        // load animation
        one = AnimationUtils.loadAnimation(this, R.anim.one);
        two = AnimationUtils.loadAnimation(this, R.anim.two);

        // run anim
        srcView.startAnimation(two);
        titleMain.startAnimation(two);
        rvMain.startAnimation(one);
        txtFooter.startAnimation(one);

    }

    private void showRecyclerList() {
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvMain);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvMain.setLayoutManager(linearLayoutManager);
        MainAdapter listMainAdapter = new MainAdapter(this);
        listMainAdapter.setListMain(list);
        rvMain.setAdapter(listMainAdapter);

        ItemClickSupport.addTo(rvMain).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // Menyimpan data ke dalam model
                MainModel mainModel = new MainModel();
                mainModel.setName(list.get(position).getName());
                mainModel.setYear(list.get(position).getYear());
                mainModel.setDesc(list.get(position).getDesc());
                mainModel.setPhoto(list.get(position).getPhoto());

                // Berpindah halaman dengan membawa data yang sudah disimpan di dalam model
                startActivity(new Intent(MainActivity.this, DetailActivity.class).putExtra(DetailActivity.EXTRA_KEY, mainModel));
            }
        });
    }

    public void openGithub(View view) {
        // Get the URL text.
        String url = "https://github.com/AzharRivaldi";

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Link tidak bisa di akses!", Toast.LENGTH_SHORT).show();
        }
    }
}

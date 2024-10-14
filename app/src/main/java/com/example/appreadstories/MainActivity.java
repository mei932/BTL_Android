package com.example.appreadstories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TruyenAdapter truyenAdapter;
    private TruyenRepository truyenRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        truyenRepository = new TruyenRepository();
        ArrayList<Truyen> truyenList = truyenRepository.getAllTruyen();

        truyenAdapter = new TruyenAdapter(truyenList, new TruyenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Truyen truyen) {
                Intent intent = new Intent(MainActivity.this, ChapterActivity.class);
                intent.putExtra("idTruyen", truyen.getId());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(truyenAdapter);
    }
}

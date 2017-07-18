package com.toong.androidrecyclerviewwithshowall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.toong.androidrecyclerviewwithshowall.adapter.MyRecyclerViewAdapter;
import com.toong.androidrecyclerviewwithshowall.base.BaseRecyclerViewAdapter;
import com.toong.androidrecyclerviewwithshowall.model.Item;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            itemList.add(new Item(" -- " + i + " ---", "b"));
        }

        MyRecyclerViewAdapter adapter =
                new MyRecyclerViewAdapter(this, 5, new BaseRecyclerViewAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                });

        adapter.add(itemList);
        recyclerView.setAdapter(adapter);
    }
}

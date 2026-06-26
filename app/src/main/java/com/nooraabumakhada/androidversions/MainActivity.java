package com.nooraabumakhada.androidversions;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<AndroidVersion> mVersionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private AndroidVersionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVersionList.addLast(new AndroidVersion(R.drawable.donut, "Donut", "1.6"));
        mVersionList.addLast(new AndroidVersion(R.drawable.eclair, "Éclair", "2.0-2.1"));
        mVersionList.addLast(new AndroidVersion(R.drawable.froyo, "Froyo", "2.2-2.2.3"));
        mVersionList.addLast(new AndroidVersion(R.drawable.gingerbread, "Gingerbread", "2.3-2.3.7"));
        mVersionList.addLast(new AndroidVersion(R.drawable.honeycomb, "Honeycomb", "3.0-3.2.6"));
        mVersionList.addLast(new AndroidVersion(R.drawable.ice_cream_sandwich, "Ice Cream Sandwich", "4.0-4.0.4"));
        mVersionList.addLast(new AndroidVersion(R.drawable.jelly_bean, "Jelly Bean", "4.1-4.3.1"));
        mVersionList.addLast(new AndroidVersion(R.drawable.kitkat, "KitKat", "4.4-4.4.4"));
        mVersionList.addLast(new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0-5.1.1"));
        mVersionList.addLast(new AndroidVersion(R.drawable.marshmallow, "Marshmallow", "6.0-6.0.1"));
        mVersionList.addLast(new AndroidVersion(R.drawable.nougat, "Nougat", "7.0-7.1.2"));
        mVersionList.addLast(new AndroidVersion(R.drawable.oreo, "Oreo", "8.0-8.1"));

        mRecyclerView = findViewById(R.id.recyclerView);

        mAdapter = new AndroidVersionAdapter(this, mVersionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
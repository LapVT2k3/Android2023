package com.lapvt.myapplication.recyclerviewb3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.lapvt.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewB3Activity extends AppCompatActivity {
    private TextView tvAdd;
    private List<Folder> folderList;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_b3);

        tvAdd = findViewById(R.id.tvAdd);
        folderList = creatFolderList();

        RecyclerView rcvDataFolder = findViewById(R.id.rcvDataFolder);

        FolderAdapter adapter = new FolderAdapter(folderList);
        rcvDataFolder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvDataFolder.setAdapter(adapter);

        adapter.setOnItemClick(new FolderAdapter.OnItemClick() {
            @Override
            public void clickName(String folderName) {
                Toast.makeText(RecyclerViewB3Activity.this, folderName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickDelete(int position) {
                folderList.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, folderList.size() - position);
            }
        });

        tvAdd.setOnClickListener(view -> {
            int i = folderList.size();
            if (!folderList.contains(new Folder("New Folder"))) {
                folderList.add(i, new Folder("New Folder"));
                adapter.notifyItemInserted(i);
            } else {
                int k = 1;
                while (folderList.contains(new Folder("New Folder " + k))) k++;
                folderList.add(i, new Folder("New Folder " + k));
                adapter.notifyItemInserted(i);
            }
        });
    }

    private List<Folder> creatFolderList() {
        List<Folder> folderList = new ArrayList<>();
        folderList.add(new Folder("Video"));
        folderList.add(new Folder("Android"));
        folderList.add(new Folder("Applock"));
        folderList.add(new Folder("Books"));
        folderList.add(new Folder("Map"));
        folderList.add(new Folder("Authenticate Using Google..."));
        folderList.add(new Folder("New Folder 3"));
        folderList.add(new Folder("New Folder 1"));
        return folderList;
    }
}
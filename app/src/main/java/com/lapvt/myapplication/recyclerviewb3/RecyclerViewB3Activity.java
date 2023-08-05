package com.lapvt.myapplication.recyclerviewb3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lapvt.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewB3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_b3);

        RecyclerView rcvDataFolder = findViewById(R.id.rcvDataFolder);

        FolderAdapter adapter = new FolderAdapter(creatFolderList());
        rcvDataFolder.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvDataFolder.setAdapter(adapter);

        adapter.setOnItemClick(new FolderAdapter.OnItemClick() {
            @Override
            public void clickName(String folderName) {
                Toast.makeText(RecyclerViewB3Activity.this, folderName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickItem() {
                Toast.makeText(RecyclerViewB3Activity.this, "Đây là item", Toast.LENGTH_SHORT).show();
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
        folderList.add(new Folder("New Folder"));
        folderList.add(new Folder("New Folder 1"));
        return folderList;
    }
}
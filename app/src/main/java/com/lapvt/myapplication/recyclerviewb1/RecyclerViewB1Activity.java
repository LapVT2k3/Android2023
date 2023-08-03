package com.lapvt.myapplication.recyclerviewb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lapvt.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewB1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_b1);

        RecyclerView rcvDataGroup = findViewById(R.id.rcvDataGroup);

        GroupAdapter adapter = new GroupAdapter(creatGroupList());
        rcvDataGroup.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvDataGroup.setAdapter(adapter);

        adapter.setOnItemClick(new GroupAdapter.OnItemClick() {
            @Override
            public void clickNameGroup(String nameGroup) {
                Toast.makeText(RecyclerViewB1Activity.this, nameGroup, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickNumberOfFans(String numberOfFans) {
                Toast.makeText(RecyclerViewB1Activity.this, numberOfFans, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickNumberOfLatestPosts(String numberOfLatestPosts) {
                Toast.makeText(RecyclerViewB1Activity.this, numberOfLatestPosts, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickStatus(String status) {
                Toast.makeText(RecyclerViewB1Activity.this, status, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickItem() {
                Toast.makeText(RecyclerViewB1Activity.this, "Đây là item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Group> creatGroupList() {
        List<Group> listGroup = new ArrayList<>();
        listGroup.add(new Group("Mua bán có tâm", 8, 10, "NHÓM ĐÓNG"));
        listGroup.add(new Group("Ăn để lăn", 8, 10, "NHÓM KÍN"));
        listGroup.add(new Group("Chia sẻ kiến thức tài liệu Montessori", 1.7,7, "NHÓM MỞ"));
        listGroup.add(new Group("Thực đơn Eat-Clean giảm cân khỏe đẹp", 11, 20, "NHÓM MỞ"));
        listGroup.add(new Group("Easy Kento for busy People", 8, 10, "NHÓM KÍN"));
        listGroup.add(new Group("OFFB", 8, 10, "NHÓM MỞ"));
        listGroup.add(new Group("Thực đơn Eat-Clean giảm cân khỏe đẹp", 11, 20, "NHÓM MỞ"));
        listGroup.add(new Group("Easy Kento for busy People", 8, 10, "NHÓM KÍN"));
        return listGroup;
    }
}
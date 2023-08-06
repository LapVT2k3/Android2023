package com.lapvt.myapplication.buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lapvt.myapplication.R;
import com.lapvt.myapplication.recyclerview.Student;
import com.lapvt.myapplication.recyclerview.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewVerticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_vertical);

        RecyclerView rcvData = findViewById(R.id.rcvData);

        // Khởi tạo adapter
        StudentAdapter adapter = new StudentAdapter(creatStudentList());
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapter);
        adapter.setOnItemClick(new StudentAdapter.OnItemClick() {
            @Override
            public void clickName(String name) {
                Toast.makeText(RecyclerViewVerticalActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickAge(String age) {
                Toast.makeText(RecyclerViewVerticalActivity.this, age, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickItem() {
                Toast.makeText(RecyclerViewVerticalActivity.this, "Đây là item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Student> creatStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Lập", 21, "B21DCCN479", "Thái Bình"));
        studentList.add(new Student("Sơn", 21, "B21DCCN110", "Thái Bình"));
        studentList.add(new Student("An", 20, "B21DCCN002", "Thái Bình"));
        studentList.add(new Student("Đạt", 22, "B21DCCN228", "Thái Bình"));
        studentList.add(new Student("Tùng", 19, "B21DCCN146", "Thái Bình"));
        studentList.add(new Student("Long", 18, "B21DCCN787", "Thái Bình"));
        studentList.add(new Student("Khánh", 22, "B21DCCN987", "Thái Bình"));
        studentList.add(new Student("Lập", 21, "B21DCCN479", "Thái Bình"));
        studentList.add(new Student("Sơn", 21, "B21DCCN110", "Thái Bình"));
        studentList.add(new Student("An", 20, "B21DCCN002", "Thái Bình"));
        studentList.add(new Student("Đạt", 22, "B21DCCN228", "Thái Bình"));
        studentList.add(new Student("Tùng", 19, "B21DCCN146", "Thái Bình"));
        studentList.add(new Student("Long", 18, "B21DCCN787", "Thái Bình"));
        studentList.add(new Student("Khánh", 22, "B21DCCN987", "Thái Bình"));
        return studentList;
    }
}
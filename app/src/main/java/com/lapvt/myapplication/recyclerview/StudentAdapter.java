package com.lapvt.myapplication.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

// Hiển thị danh sách học sinh trong lớp
// Có 2 cách để truyền dữ liệu vào adapter (dùng constructor, set get)
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList = null;
    private OnItemClick onItemClick;

    // C1: Truyền dữ liệu vào adapter bằng cách dùng constructor
    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    // C2: Dùng set để truyền dữ liệu vào adapter
    // Dữ liệu thường sẽ có được sau khi khởi tạo adapter
    // Dùng set khi dữ liệu hay bị thay đổi
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    // Tạo ra item (view holder là 1 cái view để giữ data)
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo ra 1 cái viewHolder bằng cách inflate
        // parent chính là recyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }
    // Set các dữ liệu cần thiết cho viewHolder vào đây
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        // C1: set dữ liệu cho các item view
//        holder.tvName.setText(studentList.get(position).getName());
//        holder.tvAge.setText(studentList.get(position).getAge() + "");
        // C2 (khuyến khích): thích hợp làm nhiều loại viewHolder
        holder.setData(studentList.get(position));

        holder.tvName.setOnClickListener(view -> {
            onItemClick.clickName(studentList.get(position).getName());
        });
        holder.tvAge.setOnClickListener(view -> {
            onItemClick.clickAge(studentList.get(position).getAge() + "");
        });
        holder.itemView.setOnClickListener(view -> {
            onItemClick.clickItem();
        });

    }
    // Hiển thị số lượng item mong muốn (hoặc đề bài yêu cầu)
    @Override
    public int getItemCount() {
        return studentList != null ? studentList.size() : 0;
    }

    protected class StudentViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvAge;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameBook);
            tvAge = itemView.findViewById(R.id.tvAge);
        }

        public void setData(Student student) {
            tvName.setText(student.getName());
            tvAge.setText("Tuổi: " + student.getAge());
        }
    }

    interface OnItemClick {
        // Bấm vào tên
        void clickName(String name);
        // Bấm vào tuổi
        void clickAge(String age);
        // Bấm vào cả item
        void clickItem();
    }

}

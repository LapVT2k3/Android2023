package com.lapvt.myapplication.recyclerviewb2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.lapvt.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewB2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_b2);

        RecyclerView rcvDataBook = findViewById(R.id.rcvDataBook);

        BookAdapter adapter = new BookAdapter(creatListBook());
        rcvDataBook.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvDataBook.setAdapter(adapter);

        adapter.setOnItemClick(new BookAdapter.OnItemClick() {
            @Override
            public void clickNameBook(String nameBook) {
                Toast.makeText(RecyclerViewB2Activity.this, nameBook, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickItem() {
                Toast.makeText(RecyclerViewB2Activity.this, "Đây là item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<Book> creatListBook() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("To Kill a Mockingbird"));
        bookList.add(new Book("To Kill a Mockingbird"));
        bookList.add(new Book("To Kill a Mockingbird"));
        bookList.add(new Book("To Kill a Mockingbird"));
        bookList.add(new Book("To Kill a Mockingbird"));
        return bookList;
    }
}
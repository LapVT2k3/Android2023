package com.lapvt.myapplication.recyclerviewb2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lapvt.myapplication.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> bookList;

    private OnItemClick onItemClick;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.setData(bookList.get(position));

        holder.tvNameBook.setOnClickListener(view -> {
            onItemClick.clickNameBook(bookList.get(position).getName());
        });

        holder.itemView.setOnClickListener(view -> {
            onItemClick.clickItem();
        });
    }

    @Override
    public int getItemCount() {
        return bookList != null ? bookList.size() : 0;
    }

    protected class BookViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNameBook;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameBook = itemView.findViewById(R.id.tvNameBook);
        }

        public void setData(Book book) {
            tvNameBook.setText(book.getName());
        }
    }

    interface OnItemClick {
        void clickNameBook(String nameBook);

        void clickItem();
    }
}

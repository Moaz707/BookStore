package com.muaadh_melhi_nycdeveloper.bookstore.recycleview_tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muaadh_melhi_nycdeveloper.bookstore.R;
import com.muaadh_melhi_nycdeveloper.bookstore.model.Book;

import java.util.List;

/**
 * Created by rapier pc on 1/10/2018.
 */

public class BookAadpter extends RecyclerView.Adapter<BookViewHolder> {
List<Book> bookList;

    public BookAadpter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item_view, parent, false);
        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.onBind(book);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}

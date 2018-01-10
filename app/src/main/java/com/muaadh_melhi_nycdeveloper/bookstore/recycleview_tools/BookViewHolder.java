package com.muaadh_melhi_nycdeveloper.bookstore.recycleview_tools;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muaadh_melhi_nycdeveloper.bookstore.MainActivity;
import com.muaadh_melhi_nycdeveloper.bookstore.MainFragment;
import com.muaadh_melhi_nycdeveloper.bookstore.R;
import com.muaadh_melhi_nycdeveloper.bookstore.model.Book;

/**
 * Created by rapier pc on 1/10/2018.
 */

class BookViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView author;
    private TextView price;
    private Button addToCart;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        author = itemView.findViewById(R.id.author);
        price = itemView.findViewById(R.id.price);
        addToCart = itemView.findViewById(R.id.add_to_cart);
    }

    public void onBind(final Book book) {
        title.setText(book.getName());
        author.setText(book.getAuthor());
        price.setText(String.valueOf(book.getPrice()));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainFragment = (MainActivity) itemView.getContext();
                mainFragment.move(book);
            }
        });
    }
}

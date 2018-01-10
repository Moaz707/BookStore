package com.muaadh_melhi_nycdeveloper.bookstore;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.muaadh_melhi_nycdeveloper.bookstore.model.Book;
import com.muaadh_melhi_nycdeveloper.bookstore.recycleview_tools.BookAadpter;
import com.muaadh_melhi_nycdeveloper.bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
private View rootview;
private BookService bookService;
private RecyclerView bookRecyclerView;
private RecyclerView.LayoutManager manger;
private final String TAG=MainFragment.class.getSimpleName();
    private List<Book> bookList;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootview=inflater.inflate(R.layout.fragment_main, container, false);
         bookList=new ArrayList<>();
         bookRecyclerView=rootview.findViewById(R.id.re);
        manger=new LinearLayoutManager(getActivity());
         return rootview;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        connectApi();

    }




    private void connectApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bookService = retrofit.create(BookService.class);

           Call<List<Book>> call=bookService.getBook();
           call.enqueue(new Callback<List<Book>>() {
               @Override
               public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                  bookRecyclerView.setLayoutManager(manger);
                  bookList=response.body();
                  BookAadpter bookAadpter=new BookAadpter(response.body());
                  bookRecyclerView.setAdapter(bookAadpter);
                   Log.d(TAG, "onResponse: ------------------------");
                   Log.d(TAG, "booklist " + response.body().get(1).getName());
               }

               @Override
               public void onFailure(Call<List<Book>> call, Throwable t) {
                            t.printStackTrace();
                            t.getMessage();
               }
           });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(getActivity(), "about clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getActivity(), "help clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sort:
                Toast.makeText(getActivity(), "sort clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}

package com.muaadh_melhi_nycdeveloper.bookstore.service;

import com.muaadh_melhi_nycdeveloper.bookstore.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rapier pc on 1/10/2018.
 */

public interface BookService {
    @GET("tamingtext/book/master/apache-solr/example/exampledocs/books.json")
    Call<List<Book>> getBook();
}

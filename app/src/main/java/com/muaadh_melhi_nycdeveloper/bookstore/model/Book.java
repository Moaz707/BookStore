package com.muaadh_melhi_nycdeveloper.bookstore.model;

import java.util.List;

/**
 * Created by rapier pc on 1/10/2018.
 */

public class Book {
    private String id;
    private List<String> cat;
    private String name;
    private String author;
    private String series_t;
    private int sequence_i;
    private String genre_s;
    private boolean inStock;
    private double price;
    private int pages_i;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCat() {
        return cat;
    }

    public void setCat(List<String> cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries_t() {
        return series_t;
    }

    public void setSeries_t(String series_t) {
        this.series_t = series_t;
    }

    public int getSequence_i() {
        return sequence_i;
    }

    public void setSequence_i(int sequence_i) {
        this.sequence_i = sequence_i;
    }

    public String getGenre_s() {
        return genre_s;
    }

    public void setGenre_s(String genre_s) {
        this.genre_s = genre_s;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages_i() {
        return pages_i;
    }

    public void setPages_i(int pages_i) {
        this.pages_i = pages_i;
    }
}


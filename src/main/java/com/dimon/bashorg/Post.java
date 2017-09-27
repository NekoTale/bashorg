package com.dimon.bashorg;

import java.net.URL;

/**
 * Created by dsv on 24.09.17.
 */
public class Post {
    private String author;


    public String getMangaAddress() {
        return mangaAddress;
    }

    public void setMangaAddress(String mangaAddress) {
        this.mangaAddress = mangaAddress;
    }

    private String mangaAddress;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;
    private String nameRu;
    private String nameEn;
    private String genre;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

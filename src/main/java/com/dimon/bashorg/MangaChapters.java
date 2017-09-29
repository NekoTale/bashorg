package com.dimon.bashorg;

public class MangaChapters {
    String chapterName;
    String chapterUrl;
    int chapterNumber;

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }
    public void outputAll (){
        System.out.println("****");
        System.out.println(this.chapterNumber);
        System.out.println(this.chapterName);
        System.out.println(this.chapterUrl);
        System.out.println("****");
    }
}

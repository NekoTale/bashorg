package com.dimon.bashorg;

public class MangaChapters {
    private String chapterName;
    private String chapterUrl;
    private int chapterNumber;

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(final int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(final String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(final String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public void outputAll() {
        System.out.println("****");
        System.out.println(this.chapterNumber);
        System.out.println(this.chapterName);
        System.out.println(this.chapterUrl);
        System.out.println("****");
    }
}

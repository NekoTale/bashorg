package com.dimon.bashorg.core;

import com.dimon.bashorg.MangaChapters;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PageParseImpl implements  PageParse{
    public MyLinkedList<MangaChapters> selectedMangaTitles (final String mangaPage){
        Document doc = Jsoup.parse(mangaPage);  //парсим страницу с мангой
        Elements chapterList = doc.select("div.expandable.chapters-link a");
        MyLinkedList<MangaChapters> mangaChaptersUrls = new MyLinkedList<MangaChapters>();
        for (Element element : chapterList){  // пролистываем все названия по очереди
            MangaChapters selectedMnagaChaptersList = new MangaChapters();
            mangaChaptersUrls.add(selectedMnagaChaptersList);
            String titleUrl = element.select("a").attr("href");
            String title = element.select("a").text();
            selectedMnagaChaptersList.setChapterName(title);
            selectedMnagaChaptersList.setChapterUrl("http://readmanga.me" + titleUrl);
        }
        mangaChaptersUrls.reverse();
        int num = 1;
        for (int i = 0; i<mangaChaptersUrls.length(); i++){
            mangaChaptersUrls.get(i).setChapterNumber(num);
            num++;
        }

        return mangaChaptersUrls;
    }


}

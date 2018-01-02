package com.dimon.mangaloader.core;

import com.dimon.mangaloader.Manga;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by dsv on 24.09.17.
 */
public class SearchResultsParseImpl implements Parser {


    public MyLinkedList<Manga> parseMangaSearchPage(final String mangaSearchPage) {
        Document doc = Jsoup.parse(mangaSearchPage);
        Elements selectResult = doc.select("div.tile.col-sm-6");
        MyLinkedList<Manga> mangas = new MyLinkedList<Manga>();
        int i = 1;
        for (Element element : selectResult) {
            Manga mangaTitle = new Manga();
            mangas.add(mangaTitle);
            Element elementsDesc = element.select("div.desc").first();
            String elementsNameRu = elementsDesc.select("h4").attr("title");
            String elementsAuthor = element.select("a.person-link").text();
            String elementsGenres = "";
            String elementsAddress = element.select("h3 a").attr("href");
            Elements genresAll = element.select("a.element-link");
            for (Element element1 : genresAll) {
                elementsGenres = elementsGenres + element1.text() + "; ";
            }
            String elementsNameEn = elementsDesc.select("h3 a").attr("title");
            mangaTitle.setNameEn(elementsNameEn);
            mangaTitle.setNameRu(elementsNameRu);
            if (elementsAddress.contains("http://")) {
                mangaTitle.setMangaAddress(elementsAddress);
            } else {
                mangaTitle.setMangaAddress("http://readmanga.me" + elementsAddress);
            }
            mangaTitle.setAuthor(elementsAuthor);
            mangaTitle.setGenre(elementsGenres);
            mangaTitle.setNumber(i);
            i++;
        }

        return mangas;
    }
}

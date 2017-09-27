package com.dimon.bashorg.core;

import com.dimon.bashorg.Post;
import com.dimon.bashorg.core.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dsv on 24.09.17.
 */
public class ParseSearchImpl implements Parser {


    public Collection<Post> parsMangaPage(final String mangaSearchPage) {
        Document doc = Jsoup.parse(mangaSearchPage);
        Elements selectResult = doc.select("div.tile.col-sm-6");
        ArrayList<Post> posts = new ArrayList<Post>();
        int i = 1;
        for (Element element : selectResult) {
            Post mangaTitle = new Post();
            posts.add(mangaTitle);
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
            mangaTitle.setMangaAddress("http://readmanga.me"+elementsAddress);
            mangaTitle.setAuthor(elementsAuthor);
            mangaTitle.setGenre(elementsGenres);
            mangaTitle.setNumber(i);
            i++;
        }

        return posts;
    }
}

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
public class ParserImpl implements Parser {


    public Collection<Post> parseBashorgPage(final String bashorgPage) {
        Document doc = Jsoup.parse(bashorgPage);
        Elements selectResult = doc.select("div.tile col-sm-6");
        ArrayList<Post> posts = new ArrayList<Post>();
        for (Element element : selectResult) {
            Post bashPost = new Post();
            posts.add(bashPost);
            Element elementsDesc = element.select("div.desc").first();
            String elementsNameRu = elementsDesc.select("h4.title").text();
          //  String elementsAuthor = element.select("a.person-link");
         //   String elementsGenres = element.select();
            String elementsNameEn = elementsDesc.select("h3.title").text();
            bashPost.setNameEn(elementsNameEn);
            bashPost.setNameRu(elementsNameRu);
          //  bashPost.setAuthor(elementsAuthor);
         //   bashPost.setGenre(elementsGenres);
        }

        return posts;
    }
}

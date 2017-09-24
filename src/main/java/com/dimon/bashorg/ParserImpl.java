package com.dimon.bashorg;

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
        Elements selectResult = doc.select("div.quote");
        ArrayList<Post> posts = new ArrayList<Post>();
        for (Element element : selectResult) {
            Post bashPost = new Post();
            posts.add(bashPost);
            Element elementsPost = element.select("div.text").first();
            String elementsHtml = elementsPost.html();
            String cleanString = Jsoup.clean(elementsHtml, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
            bashPost.setPost(cleanString);
            String elementsRate = element.select(".rating").text();
            String elementsDate = element.select(".date").text();
            bashPost.setDate(elementsDate);
            bashPost.setRating(elementsRate);
        }

        return posts;
    }
}

package com.dimon.bashorg;

import com.dimon.bashorg.core.Parser;
import com.dimon.bashorg.core.ParserImpl;
import com.dimon.bashorg.net.Downloader;
import com.dimon.bashorg.net.DownloaderImpl;

import java.util.Collection;

/**
 * Created by dsv on 24.09.17.
 */
public class Main {

    public static void main(String[] args) {

        Downloader downloader = new DownloaderImpl();
        String bashPage = downloader.download("http://bash.im");
        System.out.println(bashPage);
        Parser bashParser = new ParserImpl();
        Collection<Post> parsedQuotes = bashParser.parseBashorgPage(bashPage);
        for (Post quote : parsedQuotes) {
            System.out.println("***********");
            System.out.println(quote.getDate());
            System.out.println(quote.getRating());
            System.out.println(quote.getPost());
            System.out.println("***********");
        }
    }

}

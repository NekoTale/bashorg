package com.dimon.bashorg;

import com.dimon.bashorg.core.Parser;
import com.dimon.bashorg.core.ParserImpl;
import com.dimon.bashorg.net.Downloader;
import com.dimon.bashorg.net.DownloaderImpl;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Scanner;



/**
 * Created by dsv on 24.09.17.
 */
public class Main {

    public static void main(String[] args) {

        String request = "";
        System.out.println("Введите запрос");
        Scanner requestIn = new Scanner(System.in);
        request = requestIn.nextLine();
        request = request.replace(' ', '+');
        try {
            request = URLEncoder.encode(request,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(request);
        String url = "http://readmanga.me/search?q="+request+"&+=Search%21";
        System.out.println(url);

        Downloader downloader = new DownloaderImpl();
        String bashPage = downloader.download(url);
        System.out.println(bashPage);
        Parser bashParser = new ParserImpl();
        Collection<Post> parsedQuotes = bashParser.parseBashorgPage(bashPage);
        for (Post quote : parsedQuotes) {
            System.out.println("***********");
       //     System.out.println(quote.getAuthor());
            System.out.println(quote.getNameEn());
            System.out.println(quote.getNameRu());
     //     System.out.println(quote.getGenre());
            System.out.println("***********");
        }
    }

}

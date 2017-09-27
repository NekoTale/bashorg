package com.dimon.bashorg;

import com.dimon.bashorg.core.ParseMangaPage;
import com.dimon.bashorg.core.Parser;
import com.dimon.bashorg.core.ParseSearchImpl;
import com.dimon.bashorg.net.Downloader;
import com.dimon.bashorg.net.DownloaderImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        String mangaSearchPage = downloader.download(url);
        System.out.println(mangaSearchPage);
        Parser mangaParser = new ParseSearchImpl();
        Collection<Post> parsedQuotes = mangaParser.parsMangaPage(mangaSearchPage);
        for (Post quote : parsedQuotes) {
            System.out.println("***********");
            System.out.println(quote.getNumber());
            System.out.println(quote.getNameEn());
            System.out.println(quote.getNameRu());
            System.out.println(quote.getAuthor());
            System.out.println(quote.getGenre());
            System.out.println(quote.getMangaAddress());
            System.out.println("***********");
        }
        System.out.println("Введите номер манги для прогрузки");
        request = requestIn.nextLine();
        int i = Integer.parseInt(request);
        String chosenName = "";
        for (Post num : parsedQuotes){
            if (num.getNumber()==i){
                url = num.getMangaAddress();
                chosenName = num.getNameEn();
            }
        }
        String mangaPage = downloader.download(url);
        System.out.println("Выбрана манга " + chosenName);
        System.out.println(url);
        System.out.println(mangaPage);
        ParseMangaPage mangaPageParse = new ParseMangaPage();
        Collection<String> parsedTitles = mangaPageParse.selectedMangaTitles(mangaPage);

        for (String title : parsedTitles){
            System.out.println(title);
        }




    }

}

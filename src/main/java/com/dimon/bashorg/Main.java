package com.dimon.bashorg;

import com.dimon.bashorg.core.*;
import com.dimon.bashorg.net.Downloader;
import com.dimon.bashorg.net.DownloaderImpl;
import com.dimon.bashorg.net.ImageDownloader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;



/**
 * Created by dsv on 24.09.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

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
        Parser mangaParser = new SearchResultsParseImpl();
        MyLinkedList<Manga> parsedQuotes = mangaParser.parseMangaSearchPage(mangaSearchPage);
        for (int a = 1; a<=parsedQuotes.length(); a++) {
            parsedQuotes.get(a).outputAll();
        }
        System.out.println("Введите номер манги для прогрузки");
        request = requestIn.nextLine();
        int i = Integer.parseInt(request);
        String chosenName = parsedQuotes.get(i).getNameEn();
        url = parsedQuotes.get(i).getMangaAddress();
        mangaSearchPage = downloader.download(url);
        System.out.println("Выбрана манга " + chosenName); // выводим мангу которую выбрал юзер
        System.out.println(url);                           // вывод адреса манги
   //     System.out.println(mangaSearchPage);                     // вывод страницы манги
        mangaPageParseImpl mangaPageParse = new mangaPageParseImpl();  // создание парсера

        MyLinkedList<MangaChapters> parsedChapterNames = mangaPageParse.selectedMangaTitles(mangaSearchPage);

        for (int j = 1; j<=parsedChapterNames.length(); j++){ //выводим названия глав и их URL
            parsedChapterNames.get(j).outputAll();
        }
        System.out.println("Введите номер главы для ее загрузки");
        i = Integer.parseInt(requestIn.nextLine()); //получаем номер главы
        url = parsedChapterNames.get(i-1).getChapterUrl(); //получаем URL главы
        mangaSearchPage = downloader.download(url);  // скачиваем главу
        ImageUrlsGetterImpl ChapterURLs = new ImageUrlsGetterImpl();
        MyLinkedList<String> chapterImageURLs = ChapterURLs.chapterURLs(mangaSearchPage);
        ImageDownloader imageSave = new ImageDownloader();
        for (int k = 0; k<chapterImageURLs.length(); k++){
            System.out.println("начинаю загрузку с адреса");
            System.out.println(chapterImageURLs.get(k));
            imageSave.saveImage(chapterImageURLs.get(k));
        }


        LinkedList<String> cs = new LinkedList<String>();

        cs.iterator();

    }

}

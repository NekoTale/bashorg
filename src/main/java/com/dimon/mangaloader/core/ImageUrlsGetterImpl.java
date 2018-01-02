package com.dimon.mangaloader.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUrlsGetterImpl implements ImageURLsGetter {

    public MyLinkedList<String> chapterURLs(final String page) {
        final Pattern arrayItemPattern = Pattern.compile("\\[('.*?'),('.*?'),(\".*?\"),.*?,.*?],");
        int startIdx = page.indexOf("rm_h.init");
        int lastIdx = page.indexOf(", 0, false);");
        String urlMassive = page.substring(startIdx, lastIdx);
        MyLinkedList<String> urls = new MyLinkedList<String>();
        final String newStr = urlMassive + ",";
        final int i = 3;
        Matcher matcher = arrayItemPattern.matcher(newStr);
        while (matcher.find()) {
            String base = matcher.group(2).replace("'", "");
            String fldr = matcher.group(1).replace("'", "");
            String pic = matcher.group(i).replace("\"", "");
            String url = base + fldr + pic;
            if (!url.contains("http")) {
                url = "http://" + url;
            }
            urls.add(url);
        }

        return urls;
    }


}

package com.dimon.bashorg.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUrlsGetterImpl implements ImageURLsGetter{

    public ArrayList<String> chapterURLs (final String page){
        final Pattern arrayItemPattern = Pattern.compile("\\[('.*?'),('.*?'),(\".*?\"),.*?,.*?],");
        int startIdx = page.indexOf("rm_h.init");
        int lastIdx = page.indexOf(", 0, false);");
        String urlMassive = page.substring(startIdx, lastIdx);
        ArrayList<String> urls = new ArrayList<String>();
        final String newStr = urlMassive + ",";
        Matcher matcher = arrayItemPattern.matcher(newStr);
        while (matcher.find()){
            String base = matcher.group(2).replace("'","");
            String fldr = matcher.group(1).replace("'","");
            String pic = matcher.group(3).replace("\"","");
            String url = base + fldr + pic;
            if (!url.contains("http")){
                url = "http://" + url;
            }
            urls.add(url);
        }

        return urls;
    }




}

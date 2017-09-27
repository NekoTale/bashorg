package com.dimon.bashorg.net;

import com.dimon.bashorg.net.Downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dsv on 24.09.17.
 */
public class DownloaderImpl implements Downloader {

    public String download(final String url) {


        URL mangaUrl;
        InputStream is = null;
        BufferedReader br;
        String line;
        String result = "";

        try {
            mangaUrl = new URL(url);
            is = mangaUrl.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                result = result + line;
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
            }
        }

        return result;
    }
}

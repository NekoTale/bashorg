package com.dimon.bashorg.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDownloader {
    public static void saveImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        String destName = "C:/newfolder/" + fileName.substring(fileName.lastIndexOf("/"));
        System.out.println(destName);

        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destName);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}

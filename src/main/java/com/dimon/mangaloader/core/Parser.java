package com.dimon.mangaloader.core;

import com.dimon.mangaloader.Manga;

/**
 * Created by dsv on 24.09.17.
 */
public interface Parser {

    MyLinkedList<Manga> parseMangaSearchPage(final String bashorgPage);

}

package com.dimon.bashorg.core;

import com.dimon.bashorg.Manga;

/**
 * Created by dsv on 24.09.17.
 */
public interface Parser {

    MyLinkedList<Manga> parseMangaSearchPage(final String bashorgPage);

}

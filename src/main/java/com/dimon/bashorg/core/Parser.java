package com.dimon.bashorg.core;

import com.dimon.bashorg.Manga;

import java.util.ArrayList;

/**
 * Created by dsv on 24.09.17.
 */
public interface Parser {

    MyLinkedList<Manga> parsMangaPage(final String bashorgPage);

}

package com.dimon.bashorg.core;

import com.dimon.bashorg.MangaChapters;

public interface PageParse {
    MyLinkedList<MangaChapters> selectedMangaTitles(final String mangaPage);
}

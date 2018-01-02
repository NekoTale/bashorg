package com.dimon.mangaloader.core;

import com.dimon.mangaloader.MangaChapters;

public interface PageParse {
    MyLinkedList<MangaChapters> selectedMangaTitles(final String mangaPage);
}

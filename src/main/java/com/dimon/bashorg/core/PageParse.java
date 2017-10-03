package com.dimon.bashorg.core;

import com.dimon.bashorg.MangaChapters;

import java.util.Collection;

public interface PageParse {
    Collection<MangaChapters> selectedMangaTitles (final String mangaPage);
}

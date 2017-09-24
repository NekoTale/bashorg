package com.dimon.bashorg.core;

import com.dimon.bashorg.Post;

import java.util.Collection;

/**
 * Created by dsv on 24.09.17.
 */
public interface Parser {

    Collection<Post> parseBashorgPage(final String bashorgPage);

}

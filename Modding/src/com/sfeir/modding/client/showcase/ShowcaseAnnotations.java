package com.sfeir.modding.client.showcase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotations used in Showcase.
 */
public class ShowcaseAnnotations {

    /**
     * Indicates that a class variable should be included as source data in the example. All data
     * must have a JavaDoc style comment.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ShowcaseData {
    }

    /**
     * Indicates that a method or inner class should be included as source code in the example. All
     * source must have a JavaDoc style comment.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target( { ElementType.TYPE, ElementType.METHOD })
    public @interface ShowcaseSource {
    }
}

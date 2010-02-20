package com.sfeir.modding.client.content;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks an activity to respond to a specific action 
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface ModdingAction {
    /**
     * The name of the activity
     * @return
     */
    String value();
    /**
     * Set to true for used the Activity by default (for the home activity)
     * @return
     */
    boolean defaultActivity() default false;
}

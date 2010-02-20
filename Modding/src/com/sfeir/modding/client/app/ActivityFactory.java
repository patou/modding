package com.sfeir.modding.client.app;

/**
 * This class is generated at the compilation and allow to generate Activity Class
 * 
 *
 */
interface ActivityFactory {
    /**
     * Create a new Activity by is simple name or full name or name given by the anotation @ModdingAction
     * @param name The name of the activity to load
     * @return the Activity
     */
    public Activity createActivity(String name);
}

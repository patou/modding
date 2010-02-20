package com.sfeir.modding.client.app;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.component.menu.MenuBar;
import com.sfeir.modding.client.content.Intent;

/**
 * Base class
 * 
 * Extend this class to create a new activity
 *
 */
public abstract class Activity extends Composite {

    private boolean isStarted = false;
    private ActivityManager activityManager = ActivityManager.getInstance();
    private Intent intent;
    private SimplePanel panel = new SimplePanel();

    public Activity() {
        initWidget(panel);
        panel.setStylePrimaryName("Activity");
        panel.getElement().setId(getName());
    }

    /**
     * Called after the creation of the widget
     */
    public abstract void displayData();

    /**
     * Get the Name of the activity
     * @return
     */
    public abstract String getName();

    /**
     * Set the content view the widget to display
     * @param content
     */
    protected void setContentView(Widget content) {
        panel.setWidget(content);
    }

    /**
     * The activity comes to foreground
     */
    protected void onStart() {
        if(!isStarted) {
            this.isStarted = true;
            displayData();
        }
    }

    /**
     * The activity comes to foreground
     */
    protected void onResume() {}
    /**
     * The activity is no longer visible
     */
    protected void onStop() {}
    /**
     * The activity is shut down
     */
    protected void onDestroy() {}
    /**
     * Initialize the contents of the Activity's standard options menu.
     * menu    
     *  The options menu in which you place your items.
     * Returns
        You must return true for the menu to be displayed; if you return false it will not be shown.
     */

    protected boolean onCreateOptionsMenu(MenuBar menu) {
        return false;
    }

    /**
     * Start a new activity
     * @param intent The itent to start
     */
    protected void startActivity(Intent intent) {
        activityManager.startActivity(intent);
    }

    /**
     * Start the Home activity
     */
    protected void home() {
        activityManager.home();
    }

    /**
     * Finished the activity and go to the last activity
     */
    public void finish() {
        activityManager.back();
    }

    /**
     * 
     * @param intent
     */
    protected void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }
}

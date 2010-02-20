/**
 * 
 */
package com.sfeir.modding.client.app;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.app.event.ActivityChangeEvent;
import com.sfeir.modding.client.app.event.ActivityChangeHandler;
import com.sfeir.modding.client.content.Intent;

/**
 * Extend this class to create the Entry Point
 *
 */
public class ActivityEntryPoint implements EntryPoint, UncaughtExceptionHandler, ValueChangeHandler<String>, ActivityChangeHandler {

    ActivityManager manager = ActivityManager.getInstance();
    private Intent homeIntent = null;
    private Map<String, Intent> intents = new HashMap<String, Intent>();
    
    /**
     * Main function init Modding
     */
    @Override
    public void onModuleLoad() {
        init();
        History.addValueChangeHandler(this);
        manager.addActivityChangeHandler(this);
        startHome();
        addRootPanel(manager);
    }

    /**
     * Add the modding panel to the RootPanel
     * 
     * Can allow to add the modding panel to an another panel (Schowcase demo)
     * @param widget
     */
    protected void addRootPanel(Widget widget) {
        RootPanel.get().add(widget);
    }

    private void startHome() {
        homeIntent = getHomeIntent();
        if (homeIntent != null) {
            manager.startActivity(homeIntent);
        }
    }
    
    /**
     * Override this function to init your application
     */
    protected void init() {
        
    }
    
    /**
     * Get the first intent to display the first activity
     * @return
     */
    public Intent getHomeIntent() {
        return new Intent();
    }

    /**
     * Display the error message
     * And back to the last Activity
     */
    @Override
    public void onUncaughtException(Throwable e) {
        Window.alert(e.getMessage());
        if (manager.getCount() > 0) {
            manager.back();
        }
    }

    /**
     * Change with the history token
     */
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String name = event.getValue();
        if (name == null || name == "") {
            startHome();
        }
        else {
            if (intents.containsKey(name)) {
                Intent intent = intents.get(name);
                if (intent != null) {
                    Intent lastIntent = manager.getLastActivity();
                    while (!manager.isHome() && !intent.equals(lastIntent)) {
                        intents.remove(lastIntent);
                        manager.back();
                        lastIntent = manager.getLastActivity();
                    }
                    manager.startActivity(intent);
                }
            }
        }
    }

    /**
     * Called when a new activity is lauched
     */
    @Override
    public void onActivityChange(ActivityChangeEvent event) {
        Intent intent = event.getIntent();
        String name = intent.getHash();
            //intent.getHash() + intent.toString();
        if (!intents.containsKey(name)){
            intents.put(name, intent);
            History.newItem(name, false);
        }
    }  
}

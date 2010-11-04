/**
 * 
 */
package com.sfeir.modding.client.app;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
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
        manager.addActivityChangeHandler(this);
        startHome(History.getToken());
        History.addValueChangeHandler(this);
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

    /**
     * Start the home page
     * @param url
     */
    
    private void startHome(String url) {
    	GWT.log(url);
    	if (url != null && !url.isEmpty()) {
    		if (url.startsWith("!")) {
    			url = url.substring(1);
    		}
    		homeIntent = new Intent(url);
    	}
		if (homeIntent == null) {
			homeIntent = getHomeIntent();
		}
    	if (homeIntent != null) {
            manager.startActivity(homeIntent);
        }
        else {
        	Window.alert("There are no Home Activity, you must add the @ModdingAction(defaultActivity = true, value = \"home\") on a Activity or implement the getHomeIntent() method in the ActivityEntryPoint sub class");
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
        if (name != null && !name.isEmpty()) {
        	name = name.substring(1);
            if (intents.containsKey(name)) {
                Intent intent = intents.get(name);
                if (intent != null) {
                    Intent lastIntent = manager.getLastActivity();
                    while (!manager.isHome() && !intent.equals(lastIntent)) {
                        intents.remove(lastIntent.getUrl());
                        manager.back();
                        lastIntent = manager.getLastActivity();
                    }
                    manager.startActivity(intent);
                    return;
                }
            }
            else {
            	startHome(name);
            	return;
            }
        }
        startHome(null);
    }

    /**
     * Called when a new activity is launched
     * Add the Intent to the intent hash map
     * Add to history hash the intent url only if the activity isn't the first activity 
     */
    @Override
    public void onActivityChange(ActivityChangeEvent event) {
        Intent intent = event.getIntent();
        String name = intent.getUrl();
        if (!intents.containsKey(name)){
            intents.put(name, intent);
            if (!manager.isHome()) {
            	History.newItem("!" + name, false);
            }
        }
    }
}

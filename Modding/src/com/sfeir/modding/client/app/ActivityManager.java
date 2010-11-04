package com.sfeir.modding.client.app;

import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.mobile.client.MobileScrollPanel;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sfeir.modding.client.app.event.ActivityChangeEvent;
import com.sfeir.modding.client.app.event.ActivityChangeHandler;
import com.sfeir.modding.client.app.event.HasActivityChangeHandlers;
import com.sfeir.modding.client.component.menu.MenuBar;
import com.sfeir.modding.client.content.Intent;

/**
 * Activity Manager
 *
 */
public class ActivityManager extends Composite implements HasActivityChangeHandlers {

    private static ActivityManager activityManagerInstance = null;
    private FlowPanel panel = new FlowPanel();
    private MenuBar menuBar = new MenuBar();
    private DeckPanel content = new DeckPanel();
    private MobileScrollPanel scrollPanel = new MobileScrollPanel();
    private Stack<Intent> intentStack = new Stack<Intent>();
    private ActivityFactory factory = GWT.create(ActivityFactory.class);
    
    private ActivityManager() {
        init();
    }

    public static ActivityManager getInstance() {
        if (activityManagerInstance == null) {
            activityManagerInstance = new ActivityManager();
        }
        return activityManagerInstance;
    }

    /**
     * Init the manager
     */
    private void init() {
        initWidget(panel);
        int height = Window.getClientHeight();
        int width = Window.getClientWidth(); 
        panel.setSize(width + "px", height + "px");
        DOM.setStyleAttribute(panel.getElement(), "overflow", "hidden");
        panel.add(menuBar);
        panel.add(scrollPanel);
        menuBar.getElement().setId("menuBar");
        menuBar.setVisible(false);
        content.getElement().setId("activityManager");
        content.setHeight("100%");
        content.setAnimationEnabled(true);
        scrollPanel.add(content);
        scrollPanel.setWidth(width + "px");
    }

    /**
     * Get the number of history
     * 
     * @return
     */
    public int getCount() {
        return intentStack.size();
    }

    /**
     * Go to the last activity
     */
    public void back() {
        if (getCount() > 1) {
            Intent last = intentStack.pop();
            Activity lastActivity = last.getActivity();
            removeActivity(lastActivity);
            Intent currentIntent = intentStack.peek();
            showActivity(currentIntent.getActivity());
            ActivityChangeEvent.fireEvent(this, currentIntent);
        }
    }

    /**
     * Set the menu to display (used by the activity)
     * @param activity
     */
    private void setMenu(Activity activity) {
        menuBar.clear();
        if (!activity.onCreateOptionsMenu(menuBar)) {
            menuBar.setVisible(false);
        } else {
            menuBar.setVisible(true);
        }
    }

    /**
     * Start a new Activity
     * @param intent
     */
    @SuppressWarnings("deprecation")
	public void startActivity(Intent intent) {
        Activity activity = intent.getActivity();
        if (activity == null) {
            activity = factory.createActivity(intent.getAction());
            intent.setActivity(activity);
        }
        if (activity != null) {
            activity.setIntent(intent);
            activity.onStart();
            if (content.getWidgetIndex(activity) < 0) {
                content.add(activity);
            }
            showActivity(activity);
        }
        intentStack.add(intent);
        ActivityChangeEvent.fireEvent(this, intent);
    }

    /**
     * Display the given activity
     * Add the activity to the DOM,
     * Call the onResume to the activity class
     * Display the menu
     * @param activity
     */
    private void showActivity(Activity activity) {
        if (activity != null) {
            content.showWidget(content.getWidgetIndex(activity));
            activity.onResume();
            setMenu(activity);
        }
    }

    
    /**
     * Remove the given activity
     * Remove the activity from the DOM,
     * Call the onDestroy to the activity class
     * @param activity
     */
    private void removeActivity(Activity activity) {
        if (activity != null) {
            content.remove(activity);
            activity.onDestroy();
        }
    }

    /**
     * Return to the first activity, close all others activities
     */
    public void home() {
        while(getCount() > 1) {
        	Intent last = intentStack.pop();
            Activity lastActivity = last.getActivity();
            removeActivity(lastActivity);
        }
    }

    /**
     * Get the last Activity created
     * @return null if the are no activity
     */
    public Intent getLastActivity() {
        if (intentStack.size() > 0)
            return intentStack.peek();
        return null;
    }

    /**
     * Add a handler to listen all activity change event => When a new activity is started or when an activity is back
     */
    @Override
    public HandlerRegistration addActivityChangeHandler(ActivityChangeHandler handler) {
        return addHandler(handler, ActivityChangeEvent.getType());
    }

    /**
     * 
     * @return true if the home is the first
     */
    public boolean isHome() {
        return getCount() == 1;
    }
}

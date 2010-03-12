package com.sfeir.modding.client.app;

import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
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
        panel.setSize("100%", "100%");
        panel.add(menuBar);
        panel.add(content);
        menuBar.getElement().setId("menuBar");
        menuBar.setVisible(false);
        content.getElement().setId("activityManager");
        content.setHeight("100%");
        content.setAnimationEnabled(true);
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
        if (getCount() > 0) {
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

    private void showActivity(Activity activity) {
        if (activity != null) {
            content.showWidget(content.getWidgetIndex(activity));
            activity.onResume();
            setMenu(activity);
        }
    }

    private void removeActivity(Activity activity) {
        if (activity != null) {
            content.remove(activity);
            activity.onDestroy();
            setMenu(activity);
        }
    }

    public void home() {
        while(getCount() > 1) {
            back();
        }
    }

    public Intent getLastActivity() {
        if (intentStack.size() > 0)
            return intentStack.peek();
        return null;
    }

    @Override
    public HandlerRegistration addActivityChangeHandler(ActivityChangeHandler handler) {
        return addHandler(handler, ActivityChangeEvent.getType());
    }

    public boolean isHome() {
        return getCount() > 1;
    }
}

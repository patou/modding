package com.sfeir.modding.client.app.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.sfeir.modding.client.content.Intent;

/**
 * Fire when a new Activity is loaded
 * 
 *
 */
public class ActivityChangeEvent extends GwtEvent<ActivityChangeHandler> {

    private static final Type<ActivityChangeHandler> TYPE = new Type<ActivityChangeHandler>();
    private Intent intent;

    private ActivityChangeEvent(Intent intent) {
        this.intent = intent;
    }

    @Override
    protected void dispatch(ActivityChangeHandler handler) {
        handler.onActivityChange(this);
    }

    @Override
    public Type<ActivityChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public static Type<ActivityChangeHandler> getType() {
        return TYPE;
    }

    public Intent getIntent() {
        return intent;
    }
    
    public static void fireEvent(HasHandlers source, Intent intent) {
        ActivityChangeEvent event = new ActivityChangeEvent(intent);
        source.fireEvent(event);
    }
}

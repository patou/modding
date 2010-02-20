package com.sfeir.modding.client.app.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasActivityChangeHandlers extends HasHandlers {
    public HandlerRegistration addActivityChangeHandler(ActivityChangeHandler handler);
}

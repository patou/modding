package com.sfeir.modding.client.view.adapter.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasBaseAdapterChangeHandlers extends HasHandlers {
    public HandlerRegistration addBaseAdapterChangeHandler(BaseAdapterChangeHandler handler);
}

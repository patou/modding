package com.sfeir.modding.client.view.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasListItemClickHandlers extends HasHandlers {
    public HandlerRegistration addListItemClickHandler(ListItemClickHandler handler);
}

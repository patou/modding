package com.sfeir.modding.client.view.adapter.event;

import com.google.gwt.event.shared.GwtEvent;

public class BaseAdapterChangeEvent extends GwtEvent<BaseAdapterChangeHandler> {

    private static final Type<BaseAdapterChangeHandler> TYPE = new Type<BaseAdapterChangeHandler>();

    public BaseAdapterChangeEvent() {
    }

    @Override
    protected void dispatch(BaseAdapterChangeHandler handler) {
        handler.onChange(this);
    }

    @Override
    public Type<BaseAdapterChangeHandler> getAssociatedType() {
        return TYPE;
    }

    public static Type<BaseAdapterChangeHandler> getType() {
        return TYPE;
    }
}

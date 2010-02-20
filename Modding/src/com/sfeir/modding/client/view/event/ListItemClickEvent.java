package com.sfeir.modding.client.view.event;

import com.google.gwt.event.shared.GwtEvent;

public class ListItemClickEvent extends GwtEvent<ListItemClickHandler> {

    private static final Type<ListItemClickHandler> TYPE = new Type<ListItemClickHandler>();
    private int itemPosition;

    public ListItemClickEvent(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    @Override
    protected void dispatch(ListItemClickHandler handler) {
        handler.onListItemClick(this);
    }

    @Override
    public Type<ListItemClickHandler> getAssociatedType() {
        return TYPE;
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public static Type<ListItemClickHandler> getType() {
        return TYPE;
    }
}

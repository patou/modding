package com.sfeir.modding.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.view.event.HasListItemClickHandlers;
import com.sfeir.modding.client.view.event.ListItemClickEvent;
import com.sfeir.modding.client.view.event.ListItemClickHandler;

public abstract class ListItemView extends Composite implements HasListItemClickHandlers {
    @UiField
    public FocusPanel listItemView;

    private int itemPostion;

    public ListItemView() {
    }

    public void setItemPostion(int itemPostion) {
        this.itemPostion = itemPostion;
    }

    public int getItemPostion() {
        return itemPostion;
    }

    @UiHandler("listItemView")
    public void onClick(ClickEvent e) {
        ListItemClickEvent listItemClickEvent = new ListItemClickEvent(itemPostion);
        fireEvent(listItemClickEvent);
    }

    public void addStyle(String style) {
        listItemView.addStyleName(style);
    }

    public void setContentView(Widget widget) {
        initWidget(listItemView);
    }

    @Override
    public HandlerRegistration addListItemClickHandler(ListItemClickHandler handler) {
        return addHandler(handler, ListItemClickEvent.getType());
    }
}

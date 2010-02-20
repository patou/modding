package com.sfeir.modding.client.component.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class MenuBar extends Composite {

    private static MenuBarUiBinder uiBinder = GWT.create(MenuBarUiBinder.class);

    interface MenuBarUiBinder extends UiBinder<Widget, MenuBar> {
    }
    
    
    @UiField
    FlowPanel menuBar;
    private MenuBarTitleItem labelTitle = null;

    public MenuBar() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void addItem(MenuItem menuItem) {
        menuBar.add(menuItem);
    }

    public void clear() {
        menuBar.clear();
    }
    
    public void setTitle(String title) {
        if (labelTitle == null) {
            labelTitle = new MenuBarTitleItem();
        }
        labelTitle.setText(title);
        if (menuBar.getWidgetIndex(labelTitle) < 0) {
            menuBar.add(labelTitle);
        }
    }
}

/**
 * 
 */
package com.sfeir.modding.client.component.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

class MenuBarTitleItem extends Composite{
    private final MenuBarTitleUiBinder uiTitleBinder = GWT.create(MenuBarTitleUiBinder.class);
    @UiTemplate("MenuBarTitle.ui.xml")
    interface MenuBarTitleUiBinder extends UiBinder<Label, MenuBarTitleItem> {}
    private Label label;
    
    public MenuBarTitleItem() {
        label = uiTitleBinder.createAndBindUi(this);
        initWidget(label);
    }
    
    public void setText(String title) {
        label.setText(title);
    }
}
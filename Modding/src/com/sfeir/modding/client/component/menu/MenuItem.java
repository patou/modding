package com.sfeir.modding.client.component.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuItem extends Composite {

    private static MenuItemUiBinder uiBinder = GWT.create(MenuItemUiBinder.class);
    interface MenuItemUiBinder extends UiBinder<Widget, MenuItem> {}

    @UiField
    Button item;

    private Command command;

    public MenuItem() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    public MenuItem(String title) {
        this();
        item.setText(title);
    }
    
    public MenuItem(String title, Command command) {
        this(title);
        this.setCommand(command);
    }

    @UiHandler("item")
    void onClick(ClickEvent e) {
        if(getCommand() != null)
            getCommand().execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

}

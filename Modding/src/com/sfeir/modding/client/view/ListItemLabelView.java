package com.sfeir.modding.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ListItemLabelView extends ListItemView {

    private static ListItemLabelViewUiBinder uiBinder = GWT.create(ListItemLabelViewUiBinder.class);
    interface ListItemLabelViewUiBinder extends UiBinder<Widget, ListItemLabelView> {}

    @UiField
    Label label;

    public ListItemLabelView(String labelValue) {
        setContentView(uiBinder.createAndBindUi(this));
        label.setText(labelValue);
    }
}

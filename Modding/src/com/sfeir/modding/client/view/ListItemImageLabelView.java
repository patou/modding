package com.sfeir.modding.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ListItemImageLabelView extends ListItemView {

    private static ListItemImageLabelViewUiBinder uiBinder = GWT.create(ListItemImageLabelViewUiBinder.class);
    interface ListItemImageLabelViewUiBinder extends UiBinder<Widget, ListItemImageLabelView> {}

    @UiField
    Label label;
    
    @UiField
    Image image;

    public ListItemImageLabelView(String labelValue) {
        setContentView(uiBinder.createAndBindUi(this));
        label.setText(labelValue);
    }
}

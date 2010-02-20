package com.sfeir.modding.client.component.forms;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.sfeir.modding.client.view.ListItemView;

public class InputText extends ListItemView implements FocusHandler {

    private final static String DEFAULTVALUE = "Text";
    private final Label label = new Label(DEFAULTVALUE);
    private final TextBox value = new TextBox();

    public InputText() {
        super();
        setContentView(label);
    }

    @Override
    public void onFocus(FocusEvent event) {
        setContentView(value);
    }
    
    //    public CampaignItem(String title) {
//        super();
//        image = Static.ICONS.circleArrow3().createImage();
//        initData(title);
//    }
//
//    @Override
//    public abstract void onClick();
//
//    private void initData(String title) {
//        addElement(0, 0, new HTML(title));
//        getFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
//
//        addElement(0, 1, image);
//        getFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
//    }
}

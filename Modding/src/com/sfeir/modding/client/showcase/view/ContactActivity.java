package com.sfeir.modding.client.showcase.view;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.sfeir.modding.client.app.FormActivity;

public class ContactActivity extends FormActivity {
    private static ContactViewUiBinder uiBinder = GWT.create(ContactViewUiBinder.class);
    @UiTemplate("ContactActivity.ui.xml")
    public interface ContactViewUiBinder extends UiBinder<Widget,ContactActivity> {}
    
    public ContactActivity() {
        setContentView(uiBinder.createAndBindUi(this));
    }
    
    @UiField Button submit;
    
    @UiHandler({"submit"})
    void onSumitButtonClick(ClickEvent event) {
        submit();
    }
 
    @Override
    public void onSubmit(SubmitEvent event) {
        Map<String,Object> values = getValues();
        String name = (String) values.get("name");
        Window.alert("Thanks " + name + " for your message");
        finish();
    }
}

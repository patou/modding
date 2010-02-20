package com.sfeir.modding.client.showcase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.app.Activity;
import com.sfeir.modding.client.app.event.ActivityChangeEvent;
import com.sfeir.modding.client.content.Intent;

public class ShowCase extends Demo {
    private static final class GeneratorInfo {
    }
    
    private static ShowCaseBodyUiBinder uiBinder = GWT.create(ShowCaseBodyUiBinder.class);
    interface ShowCaseBodyUiBinder extends UiBinder<Widget, ShowCase> {}

    @UiField
    AbsolutePanel panel;
    @UiField
    FlowPanel showCaseBrowser;
    @UiField
    HTML sourceCode;
    @UiField
    ScrollPanel sourcePanel;
    
    private static String loadingImage;

    public ShowCase() {
    }

    @Override
    protected void addRootPanel(Widget widget) {
        showCaseBrowser.add(widget);
    }

    @Override
    public void onModuleLoad() {
        GWT.create(GeneratorInfo.class);
        RootPanel.get().add(uiBinder.createAndBindUi(this));
        panel.add(showCaseBrowser, 120, 159);
        panel.add(sourcePanel, 400, 20);
        sourceCode.setHeight((Window.getClientHeight() - 60) + "px");
        sourceCode.setWidth((Window.getClientWidth() - 420) + "px");
        panel.getElement().setId("showCaseBody");
        super.onModuleLoad();
    }
    
    @Override
    public void onActivityChange(ActivityChangeEvent event) {
        super.onActivityChange(event);
        Intent intent = event.getIntent();
        if (intent != null) {
            Activity activity = intent.getActivity();
            if (activity != null) {
                loadSource(activity.getClass());
            }
        }
    }
    
    private void loadSource(Class<? extends Activity> cls) {
        String className = cls.getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        requestSourceContents(ShowcaseConstants.DST_SOURCE_EXAMPLE + className + ".html", sourceCode, null);
    }
    
    protected void requestSourceContents(String url, final HTML target,
            final RequestCallback callback) {
          // Show the loading image
          if (loadingImage == null) {
            loadingImage = "<img src=\"" + GWT.getModuleBaseURL()
                + "ajax-loader.gif\">";
          }
          target.setDirection(HasDirection.Direction.LTR);
          DOM.setStyleAttribute(target.getElement(), "textAlign", "left");
          target.setHTML("&nbsp;&nbsp;" + loadingImage);

          // Request the contents of the file
          RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
              GWT.getModuleBaseURL() + url);
          RequestCallback realCallback = new RequestCallback() {
            public void onError(Request request, Throwable exception) {
              target.setHTML("Cannot find resource");
              if (callback != null) {
                callback.onError(request, exception);
              }
            }

            public void onResponseReceived(Request request, Response response) {
              target.setHTML(response.getText());
              if (callback != null) {
                callback.onResponseReceived(request, response);
              }
            }
          };
          builder.setCallback(realCallback);

          // Send the request
          try {
            builder.send();
          } catch (RequestException e) {
            realCallback.onError(null, e);
          }
        }
}

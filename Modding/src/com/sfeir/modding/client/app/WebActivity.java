/**
 * 
 */
package com.sfeir.modding.client.app;

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
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * This Activity load a web page and display it
 * 
 */
public class WebActivity extends Activity implements RequestCallback {
    
    private WebActivityUiBinder uiBinder = GWT.create(WebActivityUiBinder.class);
    interface WebActivityUiBinder extends UiBinder<Widget, WebActivity>{}
    @UiField
    public HTML content;

    @UiField
    public Widget loading;

    public WebActivity() {
        setContentView(uiBinder.createAndBindUi(this));
        content.setStylePrimaryName("web-activity");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sfeir.modding.client.app.Activity#displayData()
     */
    @Override
    public void displayData() {
        String url = (String) getIntent().getExtra("url");
        loadURL(url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sfeir.modding.client.app.Activity#getName()
     */
    @Override
    public String getName() {
        return "web-activity";
    }

    /**
     * Load the url
     * @param url
     */
    protected void loadURL(String url) {
        requestWebContents(url, content, this);
    }

    private void requestWebContents(String url, final HTML target, final RequestCallback callback) {
        target.setDirection(HasDirection.Direction.LTR);
        DOM.setStyleAttribute(target.getElement(), "textAlign", "left");
        target.setText("");
        loading.setVisible(true);

        // Request the contents of the file
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        RequestCallback realCallback = new RequestCallback() {
            public void onError(Request request, Throwable exception) {
                target.setHTML("Cannot find resource");
                if (callback != null) {
                    callback.onError(request, exception);
                }
            }

            public void onResponseReceived(Request request, Response response) {
                target.setHTML(response.getText());
                loading.setVisible(false);
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

    /**
     * If there are an error
     */
    @Override
    public void onError(Request request, Throwable exception) {
        
    }

    /**
     * When the page is loaded
     */
    @Override
    public void onResponseReceived(Request request, Response response) {
        
    }

}

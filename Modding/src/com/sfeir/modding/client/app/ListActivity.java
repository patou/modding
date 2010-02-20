package com.sfeir.modding.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.view.ListItemView;
import com.sfeir.modding.client.view.adapter.BaseAdapter;
import com.sfeir.modding.client.view.event.ListItemClickEvent;
import com.sfeir.modding.client.view.event.ListItemClickHandler;

/**
 * Display a list
 * 
 *
 */
public class ListActivity extends Activity implements ListItemClickHandler {

    private static ListViewUiBinder uiBinder = GWT.create(ListViewUiBinder.class);
    interface ListViewUiBinder extends UiBinder<Widget, ListActivity> {}

    @UiField
    public FlowPanel listView;

    protected BaseAdapter<?> baseAdapter = null;
    private int selectedItemPosition;

    public ListActivity() {
        setContentView(uiBinder.createAndBindUi(this));
        getElement().setId("listActivity");
    }

    protected void onListItemClick(ListItemView view) {
    }

    protected void setListAdapter(BaseAdapter<?> baseAdapter) {
        this.baseAdapter = baseAdapter;
    }

    protected void clear() {
        listView.clear();
    }

    @Override
    public void displayData() {
        if(baseAdapter == null)
               return;
        for(int i=0; i<baseAdapter.size(); i++) {
            final ListItemView view = baseAdapter.getView(i);
            add(view);
        }
    }

    protected void add(final ListItemView view) {
        listView.add(view);
        view.setItemPostion(listView.getWidgetIndex(view));
        view.addListItemClickHandler(this);

    }
    
    protected void remove(final ListItemView view) {
        listView.remove(view);
    }

    public ListItemView getItem(int position) {
        return (ListItemView) listView.getWidget(position);
    }


    @Override
    public void onListItemClick(ListItemClickEvent event) {
        selectedItemPosition = event.getItemPosition();
    }

    public int getSelectedItemPosition() {
        return selectedItemPosition;
    }
    @Override
    public String getName() {
        return "list-activity";
    }
}

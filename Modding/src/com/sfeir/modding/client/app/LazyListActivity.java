package com.sfeir.modding.client.app;

import com.sfeir.modding.client.view.ListItemLabelView;
import com.sfeir.modding.client.view.ListItemView;
import com.sfeir.modding.client.view.event.ListItemClickEvent;
import com.sfeir.modding.client.view.event.ListItemClickHandler;

/**
 * 
 * This list activity load dynamicly data page per page
 *
 */
public class LazyListActivity extends ListActivity {
    private Integer numberItemsDisplay = 10; 
    
    
    @Override
    public void displayData() {
        if(baseAdapter == null)
               return;
        displayData(0);
    }

    private void displayData(final Integer page) {
        int total = (page+1) * numberItemsDisplay;
        int size = baseAdapter.size();
        if (total >= size) {
            total = size;
        }
        int first = page * numberItemsDisplay;
        if (first < total) {
            for (int i = first; i < total; ++i){
                ListItemView view = baseAdapter.getView(i);
                add(view);
            }
            final ListItemView itemNext = new ListItemLabelView("Next " + numberItemsDisplay + " elements");
            itemNext.addListItemClickHandler(new ListItemClickHandler() {
                public void onListItemClick(ListItemClickEvent event) {
                    remove(itemNext);
                    displayData(page + 1);
                }
            });
            add(itemNext);
        }
    }

    public void setNumberItemsDisplay(Integer numberItemsDisplay) {
        this.numberItemsDisplay = numberItemsDisplay;
    }

    public Integer getNumberItemsDisplay() {
        return numberItemsDisplay;
    }
}

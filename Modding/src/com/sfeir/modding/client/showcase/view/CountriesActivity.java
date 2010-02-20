package com.sfeir.modding.client.showcase.view;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.sfeir.modding.client.app.ListActivity;
import com.sfeir.modding.client.component.menu.MenuBar;
import com.sfeir.modding.client.component.menu.MenuItem;
import com.sfeir.modding.client.content.Intent;
import com.sfeir.modding.client.content.ModdingAction;
import com.sfeir.modding.client.showcase.ShowcaseAnnotations.ShowcaseSource;
import com.sfeir.modding.client.showcase.data.Static;
import com.sfeir.modding.client.view.adapter.ListAdapter;
import com.sfeir.modding.client.view.event.ListItemClickEvent;

/**
 * Display
 * 
 *
 */
@ShowcaseSource
@ModdingAction("countries")
public class CountriesActivity extends ListActivity {

    public static int instance = 1;

    public CountriesActivity() {
        ListAdapter listAdapter = new ListAdapter(Static.getCountriesList());
        setListAdapter(listAdapter);
        instance++;
    }

    @Override
    public void onListItemClick(ListItemClickEvent event) {
        super.onListItemClick(event);
        Window.alert("ARF...."+event.getItemPosition()+"--"+getSelectedItemPosition());
    }

    @Override
    protected void onDestroy() {
        instance--;
    }

    @Override
    protected boolean onCreateOptionsMenu(MenuBar menu) {
        MenuItem menuItem;
        if(instance > 1) {
            menuItem = new MenuItem("Back", new Command() {
                @Override
                public void execute() {
                    finish();
                }
            });
        } else {
            menuItem = new MenuItem("Hello", new Command() {
                
                @Override
                public void execute() {
                    startActivity(new Intent(new HomeActivity()));
                }
            });
        }
        
        MenuItem menuItem2 = new MenuItem("Capitals"+instance, new Command() {
            
            @Override
            public void execute() {
                startActivity(new Intent(new CapitalsActivity()));
            }
        });
        menu.addItem(menuItem);
        menu.addItem(menuItem2);
        return true;
    }
}

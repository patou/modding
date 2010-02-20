package com.sfeir.modding.client.showcase.view;

import com.google.gwt.user.client.Command;
import com.sfeir.modding.client.app.LazyListActivity;
import com.sfeir.modding.client.component.menu.MenuBar;
import com.sfeir.modding.client.component.menu.MenuItem;
import com.sfeir.modding.client.content.Intent;
import com.sfeir.modding.client.showcase.ShowcaseAnnotations.ShowcaseSource;
import com.sfeir.modding.client.showcase.data.Static;
import com.sfeir.modding.client.view.adapter.ListAdapter;

/**
 * Display a Capital List
 * 
 *
 */
@ShowcaseSource
public class CapitalsActivity extends LazyListActivity {

    public CapitalsActivity() {
        ListAdapter listAdapter = new ListAdapter(Static.getCapitalsList());
        setListAdapter(listAdapter);
    }

    @Override
    protected boolean onCreateOptionsMenu(MenuBar menu) {
        MenuItem menuItem = new MenuItem("Back", new Command() {
            @Override
            public void execute() {
               finish();
            }
        });
        MenuItem menuItem2 = new MenuItem("Countries", new Command() {
            @Override
            public void execute() {
               startActivity(new Intent(new CountriesActivity()));
            }
        });

        menu.addItem(menuItem);
        menu.addItem(menuItem2);
        return true;
    }
    
    @Override
    public String getName() {
        return super.getName() + "-capitals";
    }
}

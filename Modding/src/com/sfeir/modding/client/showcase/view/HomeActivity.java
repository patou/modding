package com.sfeir.modding.client.showcase.view;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.sfeir.modding.client.app.ListActivity;
import com.sfeir.modding.client.app.WebActivity;
import com.sfeir.modding.client.component.menu.MenuBar;
import com.sfeir.modding.client.content.Intent;
import com.sfeir.modding.client.content.ModdingAction;
import com.sfeir.modding.client.view.adapter.ListStringAdapter;
import com.sfeir.modding.client.view.event.ListItemClickEvent;

@ModdingAction(value="home",defaultActivity=true)
public class HomeActivity extends ListActivity {

    private static HomeActivityUiBinder uiBinder = GWT.create(HomeActivityUiBinder.class);

    interface HomeActivityUiBinder extends UiBinder<Widget, HomeActivity> {
    }

    public HomeActivity() {
        setContentView(uiBinder.createAndBindUi(this));
        
        ArrayList<String> home = new ArrayList<String>();
        home.add("List countries");
        home.add("List capitals");
        home.add("Contacts");
        home.add("Website");

        ListStringAdapter listAdapter = new ListStringAdapter(home);
        setListAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListItemClickEvent event) {
        switch (event.getItemPosition()) {
        case 0:
            startActivity(new Intent(CountriesActivity.class));
            break;
        case 1:
            startActivity(new Intent(CapitalsActivity.class));
            break;
        case 2:
            startActivity(new Intent(ContactActivity.class));
            break;
        case 3:
            Intent intentURL = new Intent(WebActivity.class);
            intentURL.putExtra("url", "page.html");
            startActivity(intentURL);
            break;
        default:
            break;
        }
    }
    @Override
    protected boolean onCreateOptionsMenu(MenuBar menu) {
        menu.setTitle("Modding Showcase");
        return true;
    }
}

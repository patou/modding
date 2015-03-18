# Introduction #

Modding is a framework for create a web application for smartphone.


# Create Project #

Create a GWT project and add the jar Modding to the class path.

Create the EntryPoint that imperatively extend the ActivityEntryPoint :

```
public class Demo extends ActivityEntryPoint {

    @Override
    public Intent getHomeIntent() {
        return new Intent(HomeActivity.class);
    }

    @Override
    protected void init() {

    }
}
```

The getHomeIntent must by writted to give to modding the first Activity to start.

# First Activity #

An Activity is a screen, it's a sub class of Activity

```

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

        ListAdapter listAdapter = new ListAdapter(home);
        setListAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListItemClickEvent event) {
        switch (event.getItemPosition()) {
        case 0:
            startActivity(new Intent("countries"));
            break;
        case 1:
            startActivity(new Intent("CapitalsActivity"));
            break;
        case 2:
            startActivity(new Intent("com.sfeir.modding.client.app.ContactActivity"));
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

```

The function setContentView must be called in the constructor and you must give to it the View Widget. It's recomended to use UiBinder, a new functionnality of GWT 2.0 but it's not an obligation.

```
<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
 xmlns:g="urn:import:com.google.gwt.user.client.ui">
 <ui:style>
  .important {
  	font-weight: bold;
  }
 </ui:style>
 <g:HTMLPanel>
  Welcome to Modding
   <g:FlowPanel ui:field="listView">
 </g:FlowPanel>
 </g:HTMLPanel>
</ui:UiBinder>
```

The cycle of life of an application is :
  * `onCreate()` : The activity is created
  * `onResume()` : The activity comes to foreground
  * `displayData()` : Called when the activity is added to the dom and it's visible
  * `onStop()` : The activity is no longer visible
  * `onDestroy()` : The activity is shut down
  * `onCreateOptionsMenu(MenuBar menu)` : Initialize the contents of the Activity's standard options menu.
You can override these function to add your code

The Activity class has many used method :
  * `startActivity()` : Start a new Activity
  * `finished()` : Finished the current activity
  * `home()` : Go to the home activity
  * `getIntent()` : Get the intent used to load this activity

# Intent #

The Intent class allow to start a new activity and give to it a extra parameters. You can compare it to the URL in a traditionnal web application.

There many method to give the activity to the intent :startActivity(new Intent("countries")); // The CountriesActivity has the Annotation @ModdingAction("countries") with allow to define a custom action name
startActivity(new Intent("CapitalsActivity")); // The simple name of the classe
startActivity(new Intent("com.sfeir.modding.client.app.ContactActivity")); // The full name of the class with the package
Intent intentURL = new Intent(WebActivity.class); //The class object (use after the getName() methode)
}}```
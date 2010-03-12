package com.sfeir.modding.client.content;

import java.util.HashMap;

import com.sfeir.modding.client.app.Activity;

/**
 * This class allow to start an new activity
 * It's possible to give extra parameters
 *
 */
public class Intent {
    private String action = null;
    private Activity activity = null;
    private HashMap<String, Object> extra = new HashMap<String, Object>();
    
    /**
     * Create a new Intent
     */
    public Intent() {
        this.activity = null;
        this.action = null;
    }
    
    @Deprecated
    public Intent(Activity activity) {
        this.activity = activity;
        getHash();
    }

    /**
     * Create the intent with the activity name to load
     * @param action
     */
    public Intent(String action) {
        this.action = action;
        this.activity = null;
    }

    /**
     * Use the class type for get the class name
     * @param activityClass
     */
    @SuppressWarnings("unchecked")
	public Intent(Class activityClass) {
        this(activityClass.getName());
    }

    /**
     * Get the action
     * @return
     */
    public String getAction() {
        return this.action;
    }

    /**
     * Get the loaded Activity
     * If activity is null, use the Action to load the activity with the ActivityFavory
     * @return
     */
    public Activity getActivity() {
        return this.activity;
    }
    
    @Override
    public String toString() {
        String name = "";
        if (activity != null) {
            name += activity.getName();
        }
        if (action != null) {
            name += "-" + action;
        }
        if (extra.size() > 0) {
            name += "-" + extra.toString();
        }
        return name;
    }
    
    private static Integer globalHash = 0;
    private String hash = null;
    
    /**
     * Create an unique hash used by the history manager
     * @return
     */
    public String getHash() {
        if (hash == null) {
           hash = globalHash.toString();
           globalHash++;
        }
        return hash;
    }
    
    /**
     * Get the extra parameter by there name
     * @param name
     * @return
     */
    public Object getExtra(String name) {
        return extra.get(name);
    }
    
    /**
     * Set an extra parameter by a name
     * @param name
     * @param value
     */
    public void putExtra(String name, Object value) {
        extra.put(name, value);
    }

    /**
     * Unique hash code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hash == null) ? 0 : hash.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Intent other = (Intent) obj;
        getHash();
        if (hash == null) {
            if (other.hash != null)
                return false;
        } else if (!hash.equals(other.hash))
            return false;
        return true;
    }

    /**
     * Used by the ActivityManager ONLY to set the Activity created reference
     * @param activity
     */
    @Deprecated
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
  
}

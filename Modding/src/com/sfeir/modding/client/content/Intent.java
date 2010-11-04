package com.sfeir.modding.client.content;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gwt.http.client.URL;
import com.sfeir.modding.client.app.Activity;

/**
 * This class allow to start an new activity
 * It's possible to give extra parameters with putExtra and get parameters with getExtra and specific version getStringExtra, ...
 *
 */
public class Intent {
    private static final String HASH_KEY = "hash";
	private String action = null;
    private Activity activity = null;
    private HashMap<String, Object> extra = new HashMap<String, Object>();
    
    /**
     * Create a new Intent
     */
    public Intent() {
        this.activity = null;
        this.action = null;
        getHash();
    }
    
    @Deprecated
    public Intent(Activity activity) {
    	this();
        this.activity = activity;
        
    }

    /**
     * Create the intent with the activity name to load
     * @param action
     */
    public Intent(String action) {
    	this();
    	parseUrl(action);
    }


	/**
     * Use the class type for get the class name
     * @param activityClass
     */
    public Intent(@SuppressWarnings("rawtypes") Class activityClass) {
        this();
        this.action = activityClass.getName();
    }

    /**
     * Parse the url,
     * restore the action, and unserialise url format
     * @param url
     */
    void parseUrl(String url) {
    	if (url == null || url.length() == 0) {
            return;
        }
		
		int splitQuery = url.indexOf('?');
		
		if (splitQuery < 0) {
			action = url;
		} else {
			String query = url.substring(splitQuery + 1);
			action = url.substring(0, splitQuery);
			
			String[] queryPairs = query.split("&");
	        for (String pair : queryPairs) {
	            int split = pair.indexOf('=');
	            if (split <= 0) {
	                throw new RuntimeException("Invalid pair [" + pair
	                    + "] in query string [" + url + "]");
	            } else {
	                String key = pair.substring(0, split);
	                String value = pair.substring(split + 1);
	                key = URL.encodeComponent(key);
	                value = URL.decodeComponent(value);
                	extra.put(key, value);
	            }
	        }
		}
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
        return getUrl();
    }
    
    /**
     * Get the url of the Intent
     * the name of the page is the class name or the action name
     * extra parameters are serialized in url argument (?param1=value1&param2=value2)
     * @return The string url
     */
    public String getUrl() {
    	String name = "";
        if (action != null) {
            name += URL.encodeComponent(action);
        }
        else {
        	if (activity != null) {
                name += URL.encodeComponent(activity.getClass().getName());
            }
        }
        name += "?"+HASH_KEY+"=" + getHash();
        if (extra.size() > 0) {
            for (Entry<String, Object> entry : extra.entrySet()) {
            	if (entry.getValue() != null) {
	            	name += "&";
	            	name += URL.encodeComponent(entry.getKey()) + "=" + URL.encodeComponent(entry.getValue().toString());
            	}
            }
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
     * Get the extra parameter by there name
     * @param name
     * @return
     */
    public String getStringExtra(String name) {
        return extra.get(name).toString();
    }
    
	/**
	 * @param name - key of the extra param
	 * @return the value of the extra param in Double Format, null if not exist
	 */
	public Double getDoubleParam(String name) {
		Object param = extra.get(name);
		if (param == null) {
			return null;
		}
		if (param instanceof Double) {
			return (Double) param;
		}
		return new Double(param.toString());
	}
	
	/**
	 * @param name - key of the extra param
	 * @return the value of the extra param in Float Format, null if not exist
	 */
	public Float getFloatParam(String name) {
		Object param = extra.get(name);
		if (param == null) {
			return null;
		}
		if (param instanceof Float) {
			return (Float) param;
		}
		return new Float(param.toString());
	}
    
	/**
	 * @param name - key of the extra param
	 * @return the value of the extra param in Integer Format, null if not exist
	 */
	public Integer getIntegerParam(String name) {
		Object param = extra.get(name);
		if (param == null) {
			return null;
		}
		if (param instanceof Integer) {
			return (Integer) param;
		}
		return new Integer(param.toString());
	}
	
	/**
	 * @param name - key of the extra param
	 * @return the value of the extra param in Long Format, null if not exist
	 */
	public Long getLongParam(String name) {
		Object param = extra.get(name);
		if (param == null) {
			return null;
		}
		if (param instanceof Double) {
			return (Long) param;
		}
		return new Long(param.toString());
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

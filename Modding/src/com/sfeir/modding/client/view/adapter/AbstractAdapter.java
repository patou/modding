package com.sfeir.modding.client.view.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sfeir.modding.client.view.ListItemView;
import com.sfeir.modding.client.view.adapter.event.BaseAdapterChangeEvent;
import com.sfeir.modding.client.view.adapter.event.BaseAdapterChangeHandler;
import com.sfeir.modding.client.view.adapter.event.HasBaseAdapterChangeHandlers;

public abstract class AbstractAdapter<V> implements Iterable<V>, BaseAdapter<V> {


	private List<V> values;
    private HandlerManager handlerManager = new HandlerManager(this);

    protected AbstractAdapter() {
        this.values = new ArrayList<V>();
        update();
    }

    protected AbstractAdapter(List<V> values) {
        this.values = new ArrayList<V>(values);
        update();
    }

    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#getView(int)
	 */
    public ListItemView getView(int itemPosition) {
    	V item = getItem(itemPosition);
    	if (item != null) {
    		return getView(item);
    	}
    	return null;
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#getView(V)
	 */
    public abstract ListItemView getView(V item);

    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#setValues(java.util.List)
	 */
    public void setValues(List<V> values) {
        this.values.clear();
        if (values == null) {
        	this.values.addAll(values);
        }
        update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#addValue(V)
	 */
    public void addValue(V value) {
    	this.values.add(value);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#insertValue(int, V)
	 */
    public void insertValue(int index, V value) {
    	this.values.add(index, value);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#addValues(java.util.List)
	 */
    public void addValues(List<V> values) {
    	this.values.addAll(values);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#addValues(int, java.util.List)
	 */
    public void addValues(int index, List<V> values) {
    	this.values.addAll(index, values);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#removeValue(int)
	 */
    public void removeValue(int index) {
    	values.remove(index);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#removeValue(V)
	 */
    public void removeValue(V item) {
    	values.remove(item);
    	update();
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#clear()
	 */
    public void clear() {
    	values.clear();
    	update();
    }

    /**
     * Must be call when the data is changed
     */
	protected void update() {
		handlerManager.fireEvent(new BaseAdapterChangeEvent());
	}

    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#getValues()
	 */
    public List<V> getValues() {
        return values;
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#getItem(int)
	 */
    public V getItem(int index) {
    	if (index < 0 || index >= values.size())
    		return null;
        return values.get(index);
    }
    
    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#size()
	 */
    public int size() {
        return values.size();
    }
    
    
	/* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#addBaseAdapterChangeHandler(com.sfeir.modding.client.view.adapter.event.BaseAdapterChangeHandler)
	 */
	@Override
	public HandlerRegistration addBaseAdapterChangeHandler(
			BaseAdapterChangeHandler handler) {
		return handlerManager.addHandler(BaseAdapterChangeEvent.getType(), handler);
	}
	

    /* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#iterator()
	 */
    @Override
	public Iterator<V> iterator() {
		return values.iterator();
	}

	/* (non-Javadoc)
	 * @see com.sfeir.modding.client.view.adapter.BaseAdapter#fireEvent(com.google.gwt.event.shared.GwtEvent)
	 */
	@Override
	public void fireEvent(GwtEvent<?> event) {
		handlerManager.fireEvent(event);
	}
}

package com.sfeir.modding.client.view.adapter;

import java.util.ArrayList;

import com.sfeir.modding.client.view.ListItemView;

public abstract class BaseAdapter<V> {

    private ArrayList<V> values;

    protected BaseAdapter() {
        this.values = new ArrayList<V>();
    }

    protected BaseAdapter(ArrayList<V> values) {
        this.values = new ArrayList<V>(values);
    }

    public abstract ListItemView getView(int itemPosition);

    public void setValues(ArrayList<V> values) {
        this.values.clear();
        this.values.addAll(values);
    }

    public ArrayList<V> getValues() {
        return values;
    }
    
    public V getItem(int index) {
        return values.get(index);
    }
    
    public int size() {
        return values.size();
    }
}

package com.sfeir.modding.client.view.adapter;

import java.util.List;

import com.sfeir.modding.client.view.ListItemView;
import com.sfeir.modding.client.view.adapter.event.HasBaseAdapterChangeHandlers;

public interface BaseAdapter<V> extends HasBaseAdapterChangeHandlers, Iterable<V> {

	public abstract ListItemView getView(int itemPosition);

	public abstract ListItemView getView(V item);

	public abstract void setValues(List<V> values);

	public abstract void addValue(V value);

	public abstract void insertValue(int index, V value);

	public abstract void addValues(List<V> values);

	public abstract void addValues(int index, List<V> values);

	public abstract void removeValue(int index);

	public abstract void removeValue(V item);

	public abstract void clear();

	public abstract List<V> getValues();

	/**
	 * Return an specific item
	 * @param index
	 * @return The Item or Null
	 */
	public abstract V getItem(int index);

	/**
	 * 
	 * @return The size of the list
	 */
	public abstract int size();
}
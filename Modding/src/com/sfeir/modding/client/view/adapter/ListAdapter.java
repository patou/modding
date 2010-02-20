package com.sfeir.modding.client.view.adapter;

import java.util.ArrayList;

import com.sfeir.modding.client.view.ListItemLabelView;
import com.sfeir.modding.client.view.ListItemView;

public class ListAdapter extends BaseAdapter<String>{

    public ListAdapter() {
        super();
    }

    public ListAdapter(ArrayList<String> list) {
        super(list);
    }

    @Override
    public ListItemView getView(int position) {
        String value = getItem(position);
        return new ListItemLabelView(value);
    }
}
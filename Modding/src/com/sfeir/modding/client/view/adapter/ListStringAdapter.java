package com.sfeir.modding.client.view.adapter;

import java.util.List;

import com.sfeir.modding.client.view.ListItemLabelView;
import com.sfeir.modding.client.view.ListItemView;

public class ListStringAdapter extends AbstractAdapter<String>{

    public ListStringAdapter() {
        super();
    }

    public ListStringAdapter(List<String> list) {
        super(list);
    }

	@Override
	public ListItemView getView(String item) {
		return new ListItemLabelView(item);
	}
}
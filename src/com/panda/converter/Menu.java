package com.panda.converter;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	public String[] hi = {"LengthConverter","MassConverter","SpeedConverter","AreaConverter","FuelConverter","DigitalStorageConverter","TemperatureConverter"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,hi));
		final ListView listView = getListView();
	    listView.setBackgroundColor(Color.parseColor("#4597CD"));
	    listView.setDivider(new ColorDrawable(0x990505FC));
	    listView.setDividerHeight(1);
	   
	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ch = hi[position];
		try {
			Class our = Class.forName("com.panda.converter."+ch);
			Intent outintent = new Intent(this,our);
			startActivity(outintent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}

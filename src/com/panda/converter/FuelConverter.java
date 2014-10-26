package com.panda.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FuelConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,1.20095,0.425144,235.215},
			{0.832674,1,0.354006,282.481},
			{2.35215,2.82481,1,100},
			{235.215,282.481,100,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fuelconverter);
		
		spinner1 = (Spinner) findViewById(R.id.fuelspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.fuelconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.fuelspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.fuelbutton1);
		final TextView show = (TextView)findViewById(R.id.fueltextView1);
		final EditText entered = (EditText)findViewById(R.id.fueleditText1);
				
		convertBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try{
					Double valuee = Double.parseDouble(entered.getText().toString());
					show.setText(""+((valuee)*(values[firstselect][secondselect])));
				}catch(NumberFormatException e){
					Toast.makeText(getApplicationContext(), "Enter a number in first box", 2000).show();
				}
				
			}
		});
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,long arg3) {
		Spinner spinner = (Spinner) parent;
	     if(spinner.getId() == R.id.fuelspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.fuelspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

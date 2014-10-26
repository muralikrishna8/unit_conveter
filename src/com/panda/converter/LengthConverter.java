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

public class LengthConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,1000,1e+5,1e+6,0.621371,1093.61,3280.84,39370.1,0.539957},
			{0.001,1,100,1000,0.000621371,1.09361,3.28084,39.3701,0.000539957},
			{1e-5,0.01,1,10,6.2137e-6,0.0109361,0.0328084,0.393701,5.3996e-6},
			{1e-6,0.001,0.1,1,6.2137e-7,0.00109361,0.00328084,0.0393701,5.3996e-7},
			{1.60934,1609.34,160934,1.609e+6,1,1760,5280,63360,0.868976},
			{0.0009144,0.9144,91.44,914.4,0.000568182,1,3,36,0.000493737},
			{0.0003048,0.3048,30.48,304.8,0.000189394,0.333333,1,12,0.000164579},
			{2.54e-5,0.0254,2.54,25.4,1.5783e-5,0.0277778,0.0833333,1,1.3715e-5},
			{1.852,1852,185200,1.852e+6,1.15078,2025.37,6076.12,72913.4,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lengthconverter);
		
		spinner1 = (Spinner) findViewById(R.id.lengthspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.lengthconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.lengthspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.lengthbutton1);
		final TextView show = (TextView)findViewById(R.id.lengthtextView1);
		final EditText entered = (EditText)findViewById(R.id.lengtheditText1);
				
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
	     if(spinner.getId() == R.id.lengthspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.lengthspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

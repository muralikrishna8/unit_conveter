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

public class TemperatureConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,0.01,0.0328084,0.00001,10,0.393701,0.0109361,0.000006214},
			{100000,1000,3280.84,1,1000000,39370.1,1093.61,0.621371},
			{30.48,0.3048,1,0.0003048,304.8,12,0.333333,0.000189394},
			{100,1,0.001,3.28084,1000,39.3701,1.09361,0.000621371},
			{0.1,0.001,0.000001,0.00328084,1,0.0393701,0.00109361,0.000000621},
			{2.54,0.0254,0.0000254,0.0833333,25.4,1,0.0277778,0.000015783},
			{91.44,0.9144,0.0009144,3,914.4,36,1,0.000568182},
			{160934,1609.34,1.60934,5280,1609344,63360,1760,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temperatureconverter);
		
		spinner1 = (Spinner) findViewById(R.id.temperaturespinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.temperatureconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.temperaturespinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.temperaturebutton1);
		final TextView show = (TextView)findViewById(R.id.temperaturetextView1);
		final EditText entered = (EditText)findViewById(R.id.temperatureeditText1);
				
		convertBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				try{
					Double valuee = Double.parseDouble(entered.getText().toString());
					if(firstselect == secondselect){
						show.setText(""+valuee);
					}
					else if(firstselect == 0 && secondselect == 1){
						show.setText((valuee*(9.0/5.0)+32)+"");
					}
					else if(firstselect == 0 && secondselect == 2){
						show.setText((valuee+273.15)+"");
					}
					else if(firstselect == 1 && secondselect == 0){
						show.setText(((valuee-32)*(5.0/9.0))+"");
					}
					else if(firstselect == 1 && secondselect == 2){
						show.setText((valuee+459.67)*(5.0/9.0)+"");
					}
					else if(firstselect == 2 && secondselect == 0){
						show.setText((valuee-273.15)+"");
					}
					else if(firstselect == 2 && secondselect == 1){
						show.setText((valuee/(5.0/9.0) - 459.67)+"");
					}
					
//					show.setText(""+((valuee)*(values[firstselect][secondselect])));
				}catch(NumberFormatException e){
					Toast.makeText(getApplicationContext(), "Enter a number in first box", 2000).show();
				}
				
			}
		});
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,long arg3) {
		Spinner spinner = (Spinner) parent;
	     if(spinner.getId() == R.id.temperaturespinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.temperaturespinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

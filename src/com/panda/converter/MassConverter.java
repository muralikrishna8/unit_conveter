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

public class MassConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,1000,1e+6,1e+9,1e+12,0.984207,1.10231,157.473,2204.62,35274},
			{0.001,1,1000,1000000,1000000000,0.000984207,0.00110231,0.157473,2.20462,35.274},
			{0.000001,0.001,1,1000,1000000,0.00000098421,0.0000011023,0.000157473,0.00220462,0.035274},
			{1e-9,1e-6,0.001,1,1000,9.8421e-10,1.1023e-9,1.5747e-7,2.2046e-6,3.5274e-5},
			{1e-12,1e-9,1e-6,0.001,1,9.8421e-13,1.1023e-12,1.5747e-10,2.2046e-9,3.5274e-8},
			{1.01605,1016.05,1.016e+6,1.016e+9,1.016e+12,1,1.12,160,2240,35840},
			{0.907185,907.185,907185,9.072e+8,9.072e+11,0.892857,1,142.857,2000,32000},
			{0.00635029,6.35029,6350.29,6.35e+6,6.35e+9,0.00625,0.007,1,14,224},
			{0.000453592,0.453592,453.592,453592,4.536e+8,0.000446429,0.0005,0.0714286,1,16},
			{2.835e-5,0.0283495,28.3495,28349.5,2.835e+7,2.7902e-5,3.125e-5,0.00446429,0.0625,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.massconverter);
		
		spinner1 = (Spinner) findViewById(R.id.massspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.massconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.massspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.massbutton1);
		final TextView show = (TextView)findViewById(R.id.masstextView1);
		final EditText entered = (EditText)findViewById(R.id.masseditText1);
				
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
	     if(spinner.getId() == R.id.massspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.massspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

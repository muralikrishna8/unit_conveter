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

public class DigitalStorageConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,0.000976563,9.5367e-7,9.3132e-10,9.0949e-13,8.8818e-16},
			{1024,1,0.000976563,9.5367e-7,9.3132e-10,9.0949e-13},
			{1.049e+6,1024,1,0.000976563,9.5367e-7,9.3132e-10},
			{1.074e+9,1.049e+6,1024,1,0.000976563,9.5367e-7},
			{1.1e+12,1.074e+9,1.049e+6,1024,1,0.000976563},
			{1.126e+15,1.1e+12,1.074e+9,1.049e+6,1024,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.digitalstorageconverter);
		
		spinner1 = (Spinner) findViewById(R.id.digitalspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.digitalconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.digitalspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.digitalbutton1);
		final TextView show = (TextView)findViewById(R.id.digitaltextView1);
		final EditText entered = (EditText)findViewById(R.id.digitaleditText1);
				
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
	     if(spinner.getId() == R.id.digitalspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.digitalspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

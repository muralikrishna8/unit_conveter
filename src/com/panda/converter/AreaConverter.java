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

public class AreaConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,100,1e+6,0.386102,247.105,1.196e+6,1.076e+7,1.55e+9},
			{0.01,1,10000,0.00386102,2.47105,11959.9,107639,1.55e+7},
			{1e-6,1e-4,1,3.861e-7,0.000247105,1.19599,10.7639,1550},
			{2.58999,258.999,2.59e+6,1,640,3.098e+6,2.788e+7,4.014e+9},
			{0.00404686,0.404686,4046.86,0.0015625,1,4840,43560,6.273e+6},
			{8.3613e-7,8.3613e-5,0.836127,3.2283e-7,0.000206612,1,9,1296},
			{9.2903e-8,9.2903e-6,0.092903,3.587e-8,2.2957e-5,0.111111,1,144},
			{6.4516e-10,6.4516e-8,0.00064516,2.491e-10,1.5942e-7,0.000771605,0.00694444,1}
	};
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.areaconverter);
		
		spinner1 = (Spinner) findViewById(R.id.areaspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.areaconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.areaspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.areabutton1);
		final TextView show = (TextView)findViewById(R.id.areatextView1);
		final EditText entered = (EditText)findViewById(R.id.areaeditText1);
				
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
	     if(spinner.getId() == R.id.areaspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.areaspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

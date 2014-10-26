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

public class SpeedConverter extends Activity implements OnItemSelectedListener{

	public double[][] values = new double[][]{
			{1,1.46667,0.44704,1.60934,0.868976},
			{0.681818,1,0.3048,1.09728,0.592484},
			{2.23694,3.28084,1,3.6,1.94384},
			{0.621371,0.911344,0.277778,1,0.539957},
			{1.15078,1.68781,0.514444,1.852,1}
	};
	
	public int firstselect=0,secondselect=0;
	public Spinner spinner1,spinner2;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speedconverter);
		spinner1 = (Spinner) findViewById(R.id.speedspinner1);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.speedconverter, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);
		spinner2 = (Spinner) findViewById(R.id.speedspinner2);
		spinner2.setAdapter(adapter1);
		spinner2.setOnItemSelectedListener(this);
		
		Button convertBut = (Button)findViewById(R.id.speedbutton1);
		final TextView show = (TextView)findViewById(R.id.speedtextView1);
		final EditText entered = (EditText)findViewById(R.id.speededitText1);
				
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
	     if(spinner.getId() == R.id.speedspinner1)
	     {
	    	 firstselect = pos;
	     }
	     else if(spinner.getId() == R.id.speedspinner2)
	     {
	    	 secondselect = pos;
	    	 
	     }
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}

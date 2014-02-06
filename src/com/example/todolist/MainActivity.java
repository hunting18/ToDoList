package com.example.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final EditText myEditText  = (EditText)findViewById(R.id.myEditText);
		ListView myListView = (ListView)findViewById(R.id.myListView);
		
		final ArrayList<String> todoItems = new ArrayList<String>();
		
		//bind the toDoItems in a ListView
		final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
		
		myListView.setAdapter(aa);
		
		myEditText.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event){
			
			if(event.getAction() == KeyEvent.ACTION_DOWN){
			// if some one clicks the center button, get the information that they typed in
		       if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER )	{
		    	     todoItems.add(0, myEditText.getText().toString());
		    	     
		    	     aa.notifyDataSetChanged();
		    	     
		    	     //set the text to empty
		    	     myEditText.setText("");
		    	     
		    	     return true;
		    	   
		       }
		}	
		return false;
		}

			
			//public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				// TODO Auto-generated method stub
			//	return false;
			//}
			
		});
		
	}
	



}

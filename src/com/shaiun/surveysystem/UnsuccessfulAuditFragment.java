package com.shaiun.surveysystem;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class UnsuccessfulAuditFragment extends Fragment implements OnClickListener{
	LinearLayout unsuccessfulAuditLayout;
	UnsuccessfulAuditListener unsuccessfulAuditLis;
	
	public interface UnsuccessfulAuditListener {
		public void unsuccessfulAuditContinueClick(String text);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			unsuccessfulAuditLis = (UnsuccessfulAuditListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement UnsuccessfulAuditListener");
		}
	}
	 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	
    	View v = (LinearLayout) inflater.inflate(R.layout.unsuccessful_audit, container, false);
    	unsuccessfulAuditLayout = (LinearLayout) inflater.inflate(R.layout.unsuccessful_audit, container, false);
    	Button b = (Button)v.findViewById(R.id.btnContinue);
    	b.setOnClickListener(this);
    	
    	return v;
    }
    
    

    
    protected boolean isValidForm(){
    	
    	//CheckBox cb = (CheckBox)findViewById(R.id.checkBox1);
    	/*Log.i("Form validationnnnnnnnnnnn", "Into the isValidForm method");
    	for (int i = 0; i < unsuccessfulAuditLayout.getChildCount(); i++) {
            View v = unsuccessfulAuditLayout.getChildAt(i);
            Class c = v.getClass();
            
            Log.i("nameeeeeeeeeeeeeeee",c.getName());
            
            //Toast.makeText(this, v., duration)
            
            if (c == EditText.class) {
                //validate your EditText here
            } else if (c == CheckBox.class) {
            	CheckBox cb = (CheckBox)v;
            	if( cb.isChecked() ){
            		Log.i("Form validationnnnnnnnnnnn",(String) cb.getText());
            		unsuccessfulAuditLis.unsuccessfulAuditContinueClick(cb.getText().toString());
            		
            		//unsuccessfulAuditLis.unsuccessfulAuditContinueClick(cb.getId());
            	}
            }
            
            
        }*/
        return true;
    }

	@Override
	public void onClick(View v) {
		isValidForm();
		unsuccessfulAuditLis.unsuccessfulAuditContinueClick("This is from unsuccessful audit fragment");
	} 
}

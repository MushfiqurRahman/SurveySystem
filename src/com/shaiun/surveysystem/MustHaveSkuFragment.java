package com.shaiun.surveysystem;

import android.app.Fragment;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MustHaveSkuFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		ScrollView sv = new ScrollView(inflater.getContext());
		LinearLayout ll = new LinearLayout(inflater.getContext());
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);
		
		for(int i = 0; i < 20; i++) {
			    CheckBox cb = new CheckBox(inflater.getContext());
			    cb.setText("I'm dynamic!");
			    ll.addView(cb);
			    
		}
		return sv;	
		//return (LinearLayout) inflater.inflate(R.layout.must_have_sku, container, false);
	}
	
	public void create_must_have_sku_rows(){
		
	}
}
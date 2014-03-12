package com.shaiun.surveysystem;

import java.util.ArrayList;

import com.shaiun.surveysystem.UnsuccessfulAuditFragment.UnsuccessfulAuditListener;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MustHaveSkuFragment extends Fragment{
	
	//ArrayList<MustHaveSkuModel> mustHaveSkuData;
	LinearLayout mustHaveSkuLayout;
	EditText[] quantities;// = ArrayList<EditText>();
	
	MustHaveSkuModel mustSkuData = new MustHaveSkuModel("", "", 0);
	
	MustHaveSkuListener mustHaveSkulis; 
	
	public interface MustHaveSkuListener{
		//public ArrayList<MustHaveSkuModel> getMustHaveSkuData();
		public void sumittedMustHaveSku(String qty);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mustHaveSkulis = (MustHaveSkuListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement MustHaveSkuListener");
		}
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	
    	View v = (LinearLayout) inflater.inflate(R.layout.unsuccessful_audit, container, false);
    	mustHaveSkuLayout = (LinearLayout) inflater.inflate(R.layout.must_have_sku, container, false);
    	Button b = (Button)v.findViewById(R.id.btnContinue);
    	b.setOnClickListener(this);
    	
    	return v;
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.must_have_sku, container, false);

		TableLayout tl = (TableLayout)v.getRootView().findViewById(R.id.tbl_must_have_sku);
		
		SurveyActivity survActv = (SurveyActivity) getActivity();
		quantities = new EditText[survActv.mustHaveSkuModels.size()];

        for (int i = 0; i < survActv.mustHaveSkuModels.size(); i++) {
        	
        	mustSkuData = survActv.mustHaveSkuModels.get(i);
        	
            TableRow tr = new TableRow(getActivity());
            tr.setId(100 + i);
            //tr.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            TextView productTitle = new TextView(getActivity());
            productTitle.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
            productTitle.setId(200 + i);
            productTitle.setText(mustSkuData.skuTitle);
            tr.addView(productTitle);

            TextView skuCode = new TextView(getActivity());
            skuCode.setId(300 + i);
            skuCode.setText(mustSkuData.skuCode);
            tr.addView(skuCode);
            
            /*EditText quantity = new EditText(getActivity());
            quantity.setId(400 + i);
            
            tr.addView(quantity);*/
            
            quantities[i] = new EditText(getActivity());
            
            tr.addView(quantities[i]);

            tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
		return v;
	}
	
	public void onClick(View v) {
		
		for(int i=0; i<quantities.length; i++){
			mustHaveSkulis.sumittedMustHaveSku(quantities[i].getText().toString());
		}
		//R.id.
		//isValidForm();
		//unsuccessfulAuditLis.unsuccessfulAuditContinueClick("This is from unsuccessful audit fragment");
	}
	
}
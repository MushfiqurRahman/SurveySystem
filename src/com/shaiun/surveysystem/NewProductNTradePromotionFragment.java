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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class NewProductNTradePromotionFragment extends Fragment{
	
	//ArrayList<MustHaveSkuModel> mustHaveSkuData;
	
	NewProductModel newProductData = new NewProductModel("", "", 0);
	TradePromotionModel tradePromotionData = new TradePromotionModel("");
	
//	MustHaveSkuListener mustHaveSkulis; 
//	
//	public interface MustHaveSkuListener{
//		public ArrayList<MustHaveSkuModel> getMustHaveSkuData();
//	}
//	
//	@Override
//	public void onAttach(Activity activity) {
//		super.onAttach(activity);
//		try {
//			mustHaveSkulis = (MustHaveSkuListener) activity;
//		} catch (ClassCastException e) {
//			throw new ClassCastException(activity.toString()
//					+ " must implement UnsuccessfulAuditListener");
//		}
//	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.new_product_n_trade_promotion, container, false);

		TableLayout tl = (TableLayout)v.getRootView().findViewById(R.id.tbl_new_product);
		
		SurveyActivity survActv = (SurveyActivity) getActivity();

        for (int i = 0; i < survActv.newProductModels.size(); i++) {            // Make TR
		//for (int i = 0; i < 5; i++) {            // Make TR
        	
        	newProductData = survActv.newProductModels.get(i);
        	
            TableRow tr = new TableRow(getActivity());
            tr.setId(100 + i);
            //tr.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            // Make TV to hold the details
            TextView detailstv = new TextView(getActivity());
            detailstv.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
            detailstv.setId(200 + i);
            detailstv.setText(newProductData.skuTitle);
            tr.addView(detailstv);

            // Make TV to hold the detailvals

            TextView valstv = new TextView(getActivity());
            valstv.setId(300 + i);
            valstv.setText(newProductData.skuCode);
            tr.addView(valstv);
            
            EditText tb = new EditText(getActivity());
            tb.setId(400 + i);
            
            tr.addView(tb);

            tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
        
        
        
		return v;
	}
	
}
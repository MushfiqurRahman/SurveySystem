package com.shaiun.surveysystem;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.os.Bundle;
import android.renderscript.Sampler;
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

public class MustHaveSkuFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.must_have_sku, container, false);

		        TableLayout tl = (TableLayout)v.getRootView().findViewById(R.id.tbl_must_have_sku);

        for (int i = 0; i <10; i++)
        {
            // Make TR
            TableRow tr = new TableRow(getActivity());
            tr.setId(100 + i);
            //tr.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            // Make TV to hold the details
            TextView detailstv = new TextView(getActivity());
            detailstv.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
            detailstv.setId(200 + i);
            detailstv.setText("Hello first");
            tr.addView(detailstv);

            // Make TV to hold the detailvals

            TextView valstv = new TextView(getActivity());
            valstv.setId(300 + i);
            valstv.setText("hello second");
            tr.addView(valstv);
            
            EditText tb = new EditText(getActivity());
            tb.setId(400 + i);
            
            tr.addView(tb);

            tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
		//v.addChildrenForAccessibility(tblRows);
		return v;
		
		/*ScrollView sv = new ScrollView(inflater.getContext());
		LinearLayout ll = new LinearLayout(inflater.getContext());
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);
		
		for(int i = 0; i < 20; i++) {
			    CheckBox cb = new CheckBox(inflater.getContext());
			    cb.setText("I'm dynamic!");
			    ll.addView(cb);
			    
		}
		return sv;	*/
		//return (LinearLayout) inflater.inflate(R.layout.must_have_sku, container, false);
	}
	
	public void create_must_have_sku_rows(){
		
	}
}
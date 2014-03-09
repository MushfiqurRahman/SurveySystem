package com.shaiun.surveysystem;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MustHaveSkuFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return (LinearLayout) inflater.inflate(R.layout.must_have_sku, container, false);
	}
}
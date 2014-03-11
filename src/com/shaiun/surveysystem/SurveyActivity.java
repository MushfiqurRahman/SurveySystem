package com.shaiun.surveysystem;

import java.util.ArrayList;

import com.shaiun.surveysystem.UnsuccessfulAuditFragment.UnsuccessfulAuditListener;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * @author mushfique
 *
 */
public class SurveyActivity extends ActionBarActivity implements UnsuccessfulAuditFragment.UnsuccessfulAuditListener {
	
	public ArrayList<MustHaveSkuModel> mustHaveSkuModels = new ArrayList<MustHaveSkuModel>();
	public ArrayList<NewProductModel> newProductModels = new ArrayList<NewProductModel>();
	public ArrayList<TradePromotionModel> tradePromotionModels = new ArrayList<TradePromotionModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getMustHaveSkuData();
		
		ActionBar actionBar = getActionBar();
		//ActionBar.NavigationMode = ActionBarNavigationMode.Tabs;
		 
        String tabLabel;
        
        tabLabel = getResources().getString(R.string.unsuccessful_audit);
        Tab tab = actionBar.newTab();
        tab.setText(tabLabel);        
        TabListener<UnsuccessfulAuditFragment> tl_unsc_audit = new TabListener<UnsuccessfulAuditFragment>(this,
        		tabLabel, UnsuccessfulAuditFragment.class);
        tab.setTabListener(tl_unsc_audit);        
        actionBar.addTab(tab);
        
        tabLabel = getResources().getString(R.string.must_have_sku);
        tab = actionBar.newTab();
        tab.setText(tabLabel);        
        TabListener<MustHaveSkuFragment> tl_must_sku = new TabListener<MustHaveSkuFragment>(this,
        		tabLabel, MustHaveSkuFragment.class);
        tab.setTabListener(tl_must_sku);        
        actionBar.addTab(tab);
                
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.survey, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * Form validation should be fired from here
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch( item.getItemId() ){
			case R.id.action_back:
				Toast.makeText(this, "Back button clicked", Toast.LENGTH_LONG).show();
				return true;
				
			case R.id.action_forward:
				Toast.makeText(this, "Forward button clicke", Toast.LENGTH_LONG).show();
				return true;
				
			default:
				return true;
		}
	}
	
	public void nextFrag(){
		Toast.makeText(this, "Continue button has been clicked", Toast.LENGTH_LONG).show();
	}
	
	
	
    private class TabListener<T extends Fragment> implements ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
		/**
		 * Constructor used each time a new tab is created.
		 *
		 * @param activity
		 *            The host Activity, used to instantiate the fragment
		 * @param tag
		 *            The identifier tag for the fragment
		 * @param clz
		 *            The fragment's Class, used to instantiate the fragment
		 */
		public TabListener(Activity activity, String tag, Class<T> clz) {
		    mActivity = activity;
		    mTag = tag;
		    mClass = clz;
		}

		@SuppressLint("NewApi")
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
		    // Check if the fragment is already initialized
		    if (mFragment == null) {
		        // If not, instantiate and add it to the activity
		        mFragment = Fragment.instantiate(mActivity, mClass.getName());
		        
		        //mFragment.
				
		        ft.add(android.R.id.content, mFragment, mTag);
		    } else {
		        // If it exists, simply attach it in order to show it
		        ft.attach(mFragment);
		    }
		    
		    
		}
		
		

		@SuppressLint("NewApi")
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		    if (mFragment != null) {
		        // Detach the fragment, because another one is being attached
		        ft.detach(mFragment);
		    }
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		    // User selected the already selected tab. Usually do nothing.
		}
	}
    
    public void getMustHaveSkuData(){
    

    	//for(int i=0; i<5; i++){
    		mustHaveSkuModels.add(new MustHaveSkuModel("Wheel Laundry Soap 130g", "880", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Wheel washing powder 500g", "881", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Wheel washing powder 200g", "882", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Rin power white 450g", "883", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Rin power white 180g", "884", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Rin power white 25g", "885", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Surf excel 20g", "886", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Close Up 50g", "886", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Pepsodent ToothPowder 100g", "887", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Pepsodent ToothPowder 50g", "888", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Pepsodent 45g", "889", 0));
    		mustHaveSkuModels.add(new MustHaveSkuModel("Pepsodent 14g", "900", 0));
    	//}
    	//return getMustHaveSkuData();
    }
    
    public void getNewProductData(){
    	newProductModels.add(new NewProductModel("FAL Night Cream 25g", "404", 0));
    	newProductModels.add(new NewProductModel("Ponds White Beauty Cream 25g Local, code, count", "407",0));
    }
    
    public void getTradePromotionData(){
    	tradePromotionModels.add(new TradePromotionModel("Face Wash Borsho Boron Utshob 2014"));
    }
    
    public void unsuccessfulAuditContinueClick(String msg){
    	show_alert_dialog("From Fragment",msg);
    	getSupportActionBar().setSelectedNavigationItem(1);
    }
    
	/**
	 * 
	 * @param title
	 * @param msg
	 */
	public void show_alert_dialog(String title, String msg){
    	AlertDialog alertDialog = new AlertDialog.Builder(SurveyActivity.this).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        alertDialog.setCancelable(true);
        
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {							
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//nothing need to do
			}
		});
        alertDialog.show();
	}
}

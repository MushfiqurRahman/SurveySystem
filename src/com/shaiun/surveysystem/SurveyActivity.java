package com.shaiun.surveysystem;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author mushfique
 *
 */
public class SurveyActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		//ActionBar.NavigationMode = ActionBarNavigationMode.Tabs;
		 
        
        android.app.ActionBar.Tab tab = actionBar.newTab();
        tab.setText("First");        
        TabListener<FirstTabFragment> tl = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);        
        actionBar.addTab(tab);
        
        
        tab = actionBar.newTab();
        tab.setText("First");        
        TabListener<FirstTabFragment> tl1 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);        
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Second");        
        TabListener<FirstTabFragment> tl2 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Third");        
        TabListener<FirstTabFragment> tl3 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Fourth");        
        TabListener<FirstTabFragment> tl4 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Fifth");        
        TabListener<FirstTabFragment> tl5 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Sixth");
        TabListener<FirstTabFragment> tl6 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Sixth");
        TabListener<FirstTabFragment> tl7 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Sixth");
        TabListener<FirstTabFragment> tl8 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
        
        tab = actionBar.newTab();
        tab.setText("Sixth");
        TabListener<FirstTabFragment> tl9 = new TabListener<FirstTabFragment>(this,
                "First Tab", FirstTabFragment.class);
        tab.setTabListener(tl);
        actionBar.addTab(tab);
                
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        setContentView(R.layout.activity_main);
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
	
	
	
    private class TabListener<T extends Fragment> implements
	    ActionBar.TabListener {
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
		
		@Override
		public void onTabReselected(android.app.ActionBar.Tab arg0,
				FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onTabSelected(android.app.ActionBar.Tab arg0,
				FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onTabUnselected(android.app.ActionBar.Tab arg0,
				FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
	}
}

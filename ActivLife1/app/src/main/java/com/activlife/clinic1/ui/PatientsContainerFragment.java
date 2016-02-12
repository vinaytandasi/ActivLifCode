package com.activlife.clinic1.ui;


import com.activlife.clinic1.R;
import com.activlife.clinic1.bl.PatientManager;
import com.activlife.clinic1.db.PatientTable;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;



public class PatientsContainerFragment extends FragmentActivity {
    static final int NUM_ITEMS = 2;

    MyAdapter mAdapter;

    ViewPager mPager;
	private String mId = null;
	private PatientManager mPatientManager = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_fragment_pager);

		String value = null;
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		if(extras != null) {
			value = extras.getString(PatientTable.KEY_ID);
		}
		if(value != null && !value.isEmpty()) {
			mId = value; 
		}

        loadData();
		
        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        
        final ActionBar actionBar = getActionBar();
 
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {


			@Override
			public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
				mPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
        };

            actionBar.addTab(
                    actionBar.newTab()
                            .setText("Patient Details")
                            .setTabListener(tabListener));
            actionBar.addTab(
                    actionBar.newTab()
                            .setText("Sessions")
                            .setTabListener(tabListener));

        /* For tabs behaviour using the buttons example
        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.goto_first);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(0);
            }
        });
        button = (Button)findViewById(R.id.goto_last);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(NUM_ITEMS-1);
            }
        });
    */
    
    }

    private void loadData() {
    	
    	mPatientManager = new PatientManager();
		if(!TextUtils.isEmpty(mId)) {
			mPatientManager.readPatientById(this, mId);			
		}
		
	}

	public  class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        /*
         * (non-Javadoc)
         * Return the fragment to be used.
         * 0 - PatientAddEdit to edit 1 patient details.
         * 1 - PatientAppointmentsList to show list of appointments.
         * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
         */
        @Override
        public Fragment getItem(int position) {
        	if( position == 0 ) {
	            PatientAddEdit patientEdit = new PatientAddEdit();
	            patientEdit.setManager(mPatientManager);
	            return patientEdit;
        	}
        	else {
	        	PatientAppointmentsList patientAppointments = new PatientAppointmentsList();
	            patientAppointments.setManager(mPatientManager);
	            return patientAppointments;
        	}        	
        }
    }
}

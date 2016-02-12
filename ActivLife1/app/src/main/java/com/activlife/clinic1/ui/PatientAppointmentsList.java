package com.activlife.clinic1.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.activlife.clinic1.R;
import com.activlife.clinic1.bl.PatientManager;
import com.activlife.clinic1.bl.BlInterfaces.IClinicBaseManager;
import com.activlife.clinic1.model.PatientModel;
import com.activlife.clinic1.ui.UIInterfaces.IClinicBaseFragment;


/*
 * Class to handle the a patients appointments. It shows the list of appointments and allows to add new appointments.
 */
public class PatientAppointmentsList extends Fragment implements
		IClinicBaseFragment {
	
	private LinearLayout rootLayout;
	private PatientManager mPatientManager = null;
	private PatientAppointmentsListAdapter mPatientAppointmentsListAdapter = null;
	ExpandableListView mExpandableListPatientAppointmentsList;
	
	@Override
	public void setManager(IClinicBaseManager mgr) {
		mPatientManager = (PatientManager) mgr;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		rootLayout = (LinearLayout) inflater.inflate(R.layout.patient_appointmentslist, container, false);
		
		return rootLayout;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
	    super.onViewCreated(view, savedInstanceState);
	    
		addBindings(view);
		addHandlers(view);

		loadValuesFromManager(view);
	    
	}

	private void loadValuesFromManager(View view) {
		mPatientAppointmentsListAdapter = new PatientAppointmentsListAdapter(this.getActivity(), mPatientManager);
		
		mExpandableListPatientAppointmentsList = (ExpandableListView) view.findViewById(R.id.listViewAppointments);

		mExpandableListPatientAppointmentsList.setAdapter(mPatientAppointmentsListAdapter);
		
	}

	private void addHandlers(View view) {
		// TODO Auto-generated method stub
		
	}

	private void addBindings(View view) {
		PatientModel patient = mPatientManager.getPatient();
		
	}
}

package com.activlife.clinic1.ui.UIInterfaces;

import com.activlife.clinic1.bl.BlInterfaces.IClinicBaseManager;

public interface IClinicBaseFragment {

	IClinicBaseManager mClinicBaseManager = null;
	public void setManager(IClinicBaseManager mgr);
}

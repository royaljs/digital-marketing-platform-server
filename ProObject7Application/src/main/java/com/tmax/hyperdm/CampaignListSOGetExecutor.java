package com.tmax.hyperdm;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class CampaignListSOGetExecutor extends ServiceExecutor
{
	public CampaignListSOGetExecutor() {
		serviceObject = new CampaignListSOGet();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}


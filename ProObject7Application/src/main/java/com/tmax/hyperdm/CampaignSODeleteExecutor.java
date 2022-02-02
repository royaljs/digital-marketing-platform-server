package com.tmax.hyperdm;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class CampaignSODeleteExecutor extends ServiceExecutor
{
	public CampaignSODeleteExecutor() {
		serviceObject = new CampaignSODelete();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
}


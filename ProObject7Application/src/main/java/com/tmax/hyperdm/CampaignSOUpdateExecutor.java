package com.tmax.hyperdm;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class CampaignSOUpdateExecutor extends ServiceExecutor
{
	public CampaignSOUpdateExecutor() {
		serviceObject = new CampaignSOUpdate();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {	
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
}


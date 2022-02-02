package com.tmax.hyperdm;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;

public class CampaignSOGetExecutor extends ServiceExecutor
{
	public CampaignSOGetExecutor() {
		serviceObject = new CampaignSOGet();
	}
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		logger.info("serviceInput: " + serviceInput.toString());
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
}


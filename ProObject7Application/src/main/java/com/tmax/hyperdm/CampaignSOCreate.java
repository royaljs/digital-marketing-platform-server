package com.tmax.hyperdm;

import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;

@ServiceObject
public class CampaignSOCreate implements com.tmax.proobject.model.service.ServiceObject<com.tmax.hyperdm.dto.CampaignInputDTO, com.tmax.hyperdm.dto.CampaignOutputDTO>
{	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.hyperdm.dto.CampaignInputDTO input = new com.tmax.hyperdm.dto.CampaignInputDTO();
	public com.tmax.hyperdm.dto.CampaignOutputDTO output = new com.tmax.hyperdm.dto.CampaignOutputDTO();
	public com.tmax.hyperdm.CampaignBO CampaignBO = new com.tmax.hyperdm.CampaignBO();
	    	
	@Override
	public com.tmax.hyperdm.dto.CampaignOutputDTO service(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws java.lang.Throwable
	{
		logger.info("요청 header: " + ServiceManager.getCurrentRequestContext().getRequest().getHeader().toString());
		
		logger.info("CampaignSOCreate is called\n");
		logger.info("SO input DTO:\n" + arg0.toString());
			
		output = CampaignBO.createCampaign(arg0);
		return output;
	}
}
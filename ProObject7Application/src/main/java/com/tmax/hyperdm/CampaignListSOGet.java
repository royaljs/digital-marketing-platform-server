package com.tmax.hyperdm;

import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;

@ServiceObject
public class CampaignListSOGet implements com.tmax.proobject.model.service.ServiceObject<com.tmax.hyperdm.dto.CampaignInputDTO, com.tmax.hyperdm.dto.CampaignArrayDTO>
{	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.hyperdm.dto.CampaignInputDTO input = new com.tmax.hyperdm.dto.CampaignInputDTO();
	public com.tmax.hyperdm.dto.CampaignArrayDTO output = new com.tmax.hyperdm.dto.CampaignArrayDTO();
	public com.tmax.hyperdm.CampaignBO CampaignBO = new com.tmax.hyperdm.CampaignBO();
	    	
	@Override
	public com.tmax.hyperdm.dto.CampaignArrayDTO service(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws java.lang.Throwable
	{
	    output = CampaignBO.readCampaignList();
		 return output;
	}
}



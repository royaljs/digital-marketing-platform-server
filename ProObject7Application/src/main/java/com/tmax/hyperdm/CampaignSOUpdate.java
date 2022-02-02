package com.tmax.hyperdm;

import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.network.RequestContext;

@ServiceObject
public class CampaignSOUpdate implements com.tmax.proobject.model.service.ServiceObject<com.tmax.hyperdm.dto.CampaignInputDTO, com.tmax.hyperdm.dto.CampaignOutputDTO>
{	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.hyperdm.dto.CampaignInputDTO input = new com.tmax.hyperdm.dto.CampaignInputDTO();
	public com.tmax.hyperdm.dto.CampaignOutputDTO output = new com.tmax.hyperdm.dto.CampaignOutputDTO();
	public com.tmax.hyperdm.CampaignBO CampaignBO = new com.tmax.hyperdm.CampaignBO();
	    	
	@Override
	public com.tmax.hyperdm.dto.CampaignOutputDTO service(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws java.lang.Throwable
	{
		RequestContext requestContext = ServiceManager.getCurrentRequestContext();
		logger.info("요청 URI: " + requestContext.getRequest().getUri());
		String uri = requestContext.getRequest().getUri();
		String id = uri.substring(uri.lastIndexOf("/")+1);
		logger.info("요청 id: " + id);
		arg0.setId(id);
		
		logger.info("CampaignSOUpdate is called\n");
		logger.info("SO input DTO:\n" + arg0.toString());
		output = CampaignBO.updateCampaign(arg0);

		return output;
	}
}



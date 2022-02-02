package com.tmax.hyperdm;

import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.network.RequestContext;

@ServiceObject
public class CampaignSOGet implements com.tmax.proobject.model.service.ServiceObject<com.tmax.hyperdm.dto.CampaignInputDTO, com.tmax.hyperdm.dto.CampaignOutputDTO>
{	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.hyperdm.dto.CampaignInputDTO input = new com.tmax.hyperdm.dto.CampaignInputDTO();
	public com.tmax.hyperdm.dto.CampaignOutputDTO output = new com.tmax.hyperdm.dto.CampaignOutputDTO();
	public com.tmax.hyperdm.CampaignBO CampaignBO = new com.tmax.hyperdm.CampaignBO();
	    	
	@Override
	public com.tmax.hyperdm.dto.CampaignOutputDTO service(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws java.lang.Throwable
	{
		//RequestContext requestContext = ServiceManager.getServiceRequestContext("HyperDM.Campaign.CampaignSOGet");
		RequestContext requestContext = ServiceManager.getCurrentRequestContext();
		//requestContext.getRequest().getREST("id")를 이용하여 /Application/ServiceGroup/key/value/ServiceObject URI에서 key-value값을 추출할 수 있다.
		
		//requestContext.getRequest().getQueryString("id")[0])를 사용하면 /ServiceObject?id=60과 같은 URI에서 id값을 추출해준다. 문자열 배열로 나오므로 여기선 0번째 인덱스에 접근하도록 했다.
		
		logger.info("요청 URI: " + requestContext.getRequest().getUri());
		String uri = requestContext.getRequest().getUri();
		String id = uri.substring(uri.lastIndexOf("/")+1);
	
		logger.info("요청 id: " + id);
		
		arg0.setId(id);
		logger.info("CampaignSOGet is called\n");
		logger.info("SO input DTO:\n" + arg0.toString());
		output = CampaignBO.readCampaign(arg0);
		
		return output;
	}
}



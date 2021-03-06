package com.tmax.hyperdm;

import java.util.UUID;

import com.tmax.proobject.core.BizObject;
import com.tmax.proobject.core.DataSource;
import com.tmax.proobject.core.exception.ProObjectRuntimeException;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.business.BusinessObject;
import com.tmax.proobject.model.network.RequestContext;

@BizObject(logicalName = "CampaignBO")
public class CampaignBO implements BusinessObject
{
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.hyperdm.dto.CampaignOutputDTO output = new com.tmax.hyperdm.dto.CampaignOutputDTO();
	public com.tmax.hyperdm.dto.CampaignInputDTO input = new com.tmax.hyperdm.dto.CampaignInputDTO();
	public com.tmax.hyperdm.dto.CampaignArrayDTO campaignList = new com.tmax.hyperdm.dto.CampaignArrayDTO();
	    		  		
	public com.tmax.hyperdm.dto.CampaignArrayDTO readCampaignList() throws Throwable
	{
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    com.tmax.hyperdm.dto.CampaignInputDTO doCall1 = new com.tmax.hyperdm.dto.CampaignInputDTO();

	        CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.SELECTLISTSQL);
	        
	        int _i1 = 0;
	        for(com.tmax.hyperdm.dto.CampaignInputDTO var1 : CampaignDOF.getForwardList()) {
	        			doCall1 = var1;
	        			logger.info("doCall1: " + doCall1);
	        //===============================================================
	        // BEGIN ASSIGN ( LOOP MODE )
	        //===============================================================
	        {
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setId(doCall1.getId());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setUserId(doCall1.getUserId());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setName(doCall1.getName());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setType(doCall1.getType());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setKeyword(doCall1.getKeyword());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setLastModified(doCall1.getLastModified());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setDateBegin(doCall1.getDateBegin());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setDateEnd(doCall1.getDateEnd());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setProductId(doCall1.getProductId());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setContents(doCall1.getContents());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setGoal(doCall1.getGoal());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setPlatform(doCall1.getPlatform());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setMaterial(doCall1.getMaterial());
	            	campaignList.fillCampaignList(_i1).getCampaignList(_i1).setImageUuid(doCall1.getImageUuid());
	        }
	        //===============================================================
	        // END ASSIGN ( LOOP MODE )
	        //===============================================================
	        _i1++;
	        }
	        	 return campaignList;
	}    	
	
	public com.tmax.hyperdm.dto.CampaignOutputDTO readCampaign(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws Throwable
	{
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    com.tmax.hyperdm.dto.CampaignInputDTO doCall1 = new com.tmax.hyperdm.dto.CampaignInputDTO();
	        
	    CampaignDOF.setId(arg0.getId());
	    CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.SELECTSQL);
	    
	    try{
	    	doCall1 = CampaignDOF.get();
	    } catch(Exception e){
	    	RequestContext requestContext = ServiceManager.getCurrentRequestContext();
	    	requestContext.getRequest().setStatusCode(400);
	    	throw new ProObjectRuntimeException("400", "input format error", "check the input format.");
	    }
        if(doCall1 == null)
        	logger.info("doCall1??? null???");
	   
        logger.info("arg0.getId(): " + arg0.getId());
        logger.info("CampaignDOF.getId(): " + CampaignDOF.getId());
        logger.info("doCall1: " + doCall1.toString());
        
    	output.setId(doCall1.getId());
    	output.setUserId(doCall1.getUserId());
    	output.setName(doCall1.getName());
    	output.setType(doCall1.getType());
    	output.setKeyword(doCall1.getKeyword());
    	output.setLastModified(doCall1.getLastModified());
    	output.setDateBegin(doCall1.getDateBegin());
    	output.setDateEnd(doCall1.getDateEnd());
    	output.setProductId(doCall1.getProductId());
    	output.setContents(doCall1.getContents());
    	output.setGoal(doCall1.getGoal());
    	output.setPlatform(doCall1.getPlatform());
    	output.setMaterial(doCall1.getMaterial());
    	output.setImageUuid(doCall1.getImageUuid());
    	
    	return output;

	}
	    	
	public com.tmax.hyperdm.dto.CampaignOutputDTO createCampaign(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws Throwable
	{
		logger.info("BO.java input ??????:\n" + arg0.toString());
		
	    com.tmax.hyperdm.dto.CampaignInputDTO doCall1 = new com.tmax.hyperdm.dto.CampaignInputDTO();
	    int resultCnt1 = 0;
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    
	    /*upload??? ???????????? ????????? ???????????? ??????. ?????? ????????? ??????????????? ????????? ????????????.
		????????? user_id ?????? images ?????? ???????????? ????????? ??????????????? ?????? ?????? ?????????, 
		PO ????????? ?????? ????????? ???????????? ????????? ?????? ?????????????????? user_id??? ???????????? user_id ?????? ???????????? ??????????????? ????????? ????????????.
		????????? ????????? ???????????? ???????????? uuid??? ????????????, ?????? ?????? ???????????? ????????? ???????????? ?????? uuid??? ??????????????? ????????? ????????????.
		*/
		String imageUUID = UUID.randomUUID().toString().replace("-", "");
	    
	    doCall1.setUserId(arg0.getUserId());
    	doCall1.setName(arg0.getName());
    	doCall1.setType(arg0.getType());
    	doCall1.setKeyword(arg0.getKeyword());
    	doCall1.setLastModified(arg0.getLastModified());
    	doCall1.setDateBegin(arg0.getDateBegin());
    	doCall1.setDateEnd(arg0.getDateEnd());
    	doCall1.setProductId(arg0.getProductId());
    	doCall1.setContents(arg0.getContents());
    	doCall1.setGoal(arg0.getGoal());
    	doCall1.setPlatform(arg0.getPlatform());
    	doCall1.setMaterial(arg0.getMaterial());
    	doCall1.setImageUuid(imageUUID);
    	//TODO: Exception ????????? SO?????? ????????? ??????????????? ???????????? ????????? ?????? ??????????????????.
        
        CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.INSERTSQL);     

    	//Tibero DB??? INSERT ?????? ??????. "id"??? auto_increment ??????. ????????? id??? doCall1??? id??? ?????????
        resultCnt1 = CampaignDOF.add(doCall1, "id");
        
        output.setId(doCall1.getId());
       	output.setUserId(doCall1.getUserId());
    	output.setName(doCall1.getName());
    	output.setType(doCall1.getType());
    	output.setKeyword(doCall1.getKeyword());
    	output.setLastModified(doCall1.getLastModified());
    	output.setDateBegin(doCall1.getDateBegin());
    	output.setDateEnd(doCall1.getDateEnd());
    	output.setProductId(doCall1.getProductId());
    	output.setContents(doCall1.getContents());
    	output.setGoal(doCall1.getGoal());
    	output.setPlatform(doCall1.getPlatform());
    	output.setMaterial(doCall1.getMaterial());
    	output.setImageUuid(doCall1.getImageUuid());
    	
        return output;
	}
	
	public com.tmax.hyperdm.dto.CampaignOutputDTO updateCampaign(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws Throwable
	{
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    com.tmax.hyperdm.dto.CampaignInputDTO doCall1 = new com.tmax.hyperdm.dto.CampaignInputDTO();
	    int resultCnt1 = 0;
	    
	    //??????????????? ????????? id??? DOF??? ??????
	    CampaignDOF.setId(arg0.getId());
	    
	    //??????????????? Campaign ???????????? doCall1??? ??????
    	doCall1.setUserId(arg0.getUserId());
    	doCall1.setName(arg0.getName());
    	doCall1.setType(arg0.getType());
    	doCall1.setKeyword(arg0.getKeyword());
    	doCall1.setLastModified(arg0.getLastModified());
    	doCall1.setDateBegin(arg0.getDateBegin());
    	doCall1.setDateEnd(arg0.getDateEnd());
    	doCall1.setProductId(arg0.getProductId());
	    doCall1.setContents(arg0.getContents());
	    doCall1.setGoal(arg0.getGoal());
	    doCall1.setPlatform(arg0.getPlatform());
	    doCall1.setMaterial(arg0.getMaterial());
	    
	    CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.UPDATESQL);
	  	resultCnt1 = CampaignDOF.update(doCall1, true);
   
        //???????????? ?????? Campaign ???????????? ??????
        output.setId(CampaignDOF.getId());
       	output.setUserId(doCall1.getUserId());
    	output.setName(doCall1.getName());
    	output.setType(doCall1.getType());
    	output.setKeyword(doCall1.getKeyword());
    	output.setLastModified(doCall1.getLastModified());
    	output.setDateBegin(doCall1.getDateBegin());
    	output.setDateEnd(doCall1.getDateEnd());
    	output.setProductId(doCall1.getProductId());
    	output.setContents(doCall1.getContents());
    	output.setGoal(doCall1.getGoal());
    	output.setPlatform(doCall1.getPlatform());
    	output.setMaterial(doCall1.getMaterial());

    	//image uuid??? update ???????????? ???????????? ???????????? ????????? uuid??? ????????????.(readCampaign??? 1??? ????????????.)
    	output.setImageUuid(readCampaign(arg0).getImageUuid());
    	
	    return output;

	}
	
	public com.tmax.hyperdm.dto.CampaignOutputDTO deleteCampaign(com.tmax.hyperdm.dto.CampaignInputDTO arg0) throws Throwable
	{
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    
	    int resultCnt1 = 0;
	
    	CampaignDOF.setId(arg0.getId());
  	  
        CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.DELETESQL);
        resultCnt1 = CampaignDOF.remove(true);
        
        //TODO: Campaign delete??? image uuid??? ???????????? ????????? ????????????. 
        //DELETE ????????? ?????? ?????? ?????? ????????? id??? ??????
        output.setId(arg0.getId());
        return output;
	}
}


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
        	logger.info("doCall1이 null임");
	   
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
		logger.info("BO.java input 객체:\n" + arg0.toString());
		
	    com.tmax.hyperdm.dto.CampaignInputDTO doCall1 = new com.tmax.hyperdm.dto.CampaignInputDTO();
	    int resultCnt1 = 0;
	    @DataSource(name="tibero6_dev")
	    com.tmax.hyperdm.CampaignDOF CampaignDOF = new com.tmax.hyperdm.CampaignDOF("tibero6_dev");
	    
	    /*upload된 파일들을 저장할 디렉토리 설정. 해당 위치에 디렉토리가 없다면 생성한다.
		현재는 user_id 별로 images 등을 디렉토리 상에서 구분하도록 하지 않고 있으나, 
		PO 서버에 인증 기능이 도입되면 헤더에 담긴 토큰으로부터 user_id를 식별하여 user_id 별로 리소스를 저장하도록 수정할 계획이다.
		현재는 하나의 이미지에 대해서만 uuid를 발급하며, 추후 여러 이미지가 업로드 되었을때 각각 uuid를 발급하도록 수정할 계획이다.
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
    	//TODO: Exception 발생시 SO에서 생성한 디렉토리를 삭제하는 로직도 추후 추가해야한다.
        
        CampaignDOF.setFullQuery(com.tmax.hyperdm.CampaignDOF.FULLQUERY.INSERTSQL);     

    	//Tibero DB에 INSERT 쿼리 요청. "id"는 auto_increment 컬럼. 발급된 id는 doCall1의 id에 셋팅됨
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
	    
	    //업데이트할 항목의 id는 DOF에 셋팅
	    CampaignDOF.setId(arg0.getId());
	    
	    //업데이트할 Campaign 데이터는 doCall1에 셋팅
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
   
        //업데이트 후의 Campaign 데이터를 반환
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

    	//image uuid는 update 요청으로 수정하지 않으므로 기존의 uuid를 반환한다.(readCampaign을 1번 수행한다.)
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
        
        //TODO: Campaign delete시 image uuid에 해당하는 파일을 삭제한다. 
        //DELETE 쿼리가 정상 수행 되면 삭제된 id를 반환
        output.setId(arg0.getId());
        return output;
	}
}


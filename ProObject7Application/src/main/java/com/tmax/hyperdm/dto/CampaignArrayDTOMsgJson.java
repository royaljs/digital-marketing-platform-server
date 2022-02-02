package com.tmax.hyperdm.dto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.w3c.dom.Node;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tmax.promapper.engine.base.Message;
import com.tmax.promapper.engine.exception.MarshalException;
import com.tmax.promapper.engine.exception.UnmarshalException;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.dataobject.DataObject;

public class CampaignArrayDTOMsgJson extends Message {	
	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public byte[] marshal(DataObject obj) throws MarshalException {
		com.tmax.hyperdm.dto.CampaignArrayDTO _CampaignArrayDTO = (com.tmax.hyperdm.dto.CampaignArrayDTO)obj;
		
		if(_CampaignArrayDTO == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _CampaignArrayDTO, jw);
			
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} catch(Exception e) {
			throw new MarshalException(e);
		} finally{
            try {
                if( jw != null )
                    try {
                        jw.close();
                    } catch (IOException e) {
                        throw new MarshalException(e);
                    }
            } finally {
                if( bw != null )
                    try {
                        bw.close();
                    } catch (IOException e) {
                        throw new MarshalException(e);
                    }
            }
		}
	}
	
	
	public void marshal(com.tmax.hyperdm.dto.CampaignArrayDTO _CampaignArrayDTO, JsonWriter writer )throws IOException {
        logger.info("CampaignArrayDTOMsgJson.java의 marshal 호출됨");
		int arraySize0 = _CampaignArrayDTO.sizeCampaignList();
		writer.name("campaignList");
        if(_CampaignArrayDTO.getCampaignList() == null) {
            writer.nullValue();
        } else {					    					
            com.tmax.hyperdm.dto.CampaignOutputDTOMsgJson __campaignList = new com.tmax.hyperdm.dto.CampaignOutputDTOMsgJson();
            writer.beginArray();					
            for(int i = 0; i < arraySize0; i++) {
                if(_CampaignArrayDTO.getCampaignList(i) != null) {
	
                    writer.beginObject();
                    __campaignList.marshal((com.tmax.hyperdm.dto.CampaignOutputDTO)_CampaignArrayDTO.getCampaignList(i), writer);
                    writer.endObject();
	
                } else {
                    writer.nullValue();
                }
            }
            writer.endArray();
        }							  					
	}

	/**
     * do not use
     */
	public void marshal(DataObject dataobject, Node node) throws MarshalException { 
  	}

  	public String removeNullChar(String charString) {
    		if( charString == null )
    			return "";
    		
			StringBuffer sb = new StringBuffer();
			for (int i = 0 ; i<charString.length(); i++) {
				if(charString.charAt(i) == (char)0) {
					sb.append("");
				} else {
					sb.append(charString.charAt(i));
				}
			}
			return sb.toString();
  	}
	
	
	public DataObject unmarshal(byte[] bytes, int i) throws UnmarshalException {		
		com.tmax.hyperdm.dto.CampaignArrayDTO _CampaignArrayDTO = new com.tmax.hyperdm.dto.CampaignArrayDTO();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdm.dto.CampaignArrayDTO();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_CampaignArrayDTO = (com.tmax.hyperdm.dto.CampaignArrayDTO)unmarshal( jr,  _CampaignArrayDTO);
     
             
		jr.endObject();
		jr.close();
			
		} catch(Exception e) {
		    throw new UnmarshalException(e);
		} finally{
            try {
                if( jr != null )
                    try {
                        jr.close();
                    } catch (IOException e) {
                        throw new UnmarshalException(e);
                    }
            } finally {
                if( reader != null )
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new UnmarshalException(e);
                    }
            }
		}
		                       
        return _CampaignArrayDTO;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws UnmarshalException {		
		
		com.tmax.hyperdm.dto.CampaignArrayDTO _CampaignArrayDTO = (com.tmax.hyperdm.dto.CampaignArrayDTO) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdm.dto.CampaignArrayDTO();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));
			jr = new JsonReader( reader );
			jr.beginObject();


					_CampaignArrayDTO = (com.tmax.hyperdm.dto.CampaignArrayDTO)unmarshal( jr,  _CampaignArrayDTO);
         
		         
			jr.endObject();
			jr.close();
				
		} catch(Exception e) {
            throw new UnmarshalException(e);
        } finally{
            try {
                if( jr != null )
                    try {
                        jr.close();
                    } catch (IOException e) {
                        throw new UnmarshalException(e);
                    }
            } finally {
                if( reader != null )
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new UnmarshalException(e);
                    }
            }
        }
		                       
	    return _CampaignArrayDTO;
	}
		
		
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdm.dto.CampaignArrayDTO dto) throws IOException {		 

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdm.dto.CampaignArrayDTO dto, JsonReader reader, String name) throws IOException {
		
		switch(name) {		
		case "campaignList" :
		{
			if(reader.peek() != JsonToken.NULL) {
				reader.beginArray();
				com.tmax.hyperdm.dto.CampaignOutputDTOMsgJson __campaignList = new com.tmax.hyperdm.dto.CampaignOutputDTOMsgJson();
				while( reader.hasNext() ){	
					if(reader.peek() != JsonToken.NULL) {			
						com.tmax.hyperdm.dto.CampaignOutputDTO ___CampaignOutputDTO = new com.tmax.hyperdm.dto.CampaignOutputDTO();	
                        reader.beginObject();
						dto.addCampaignList((com.tmax.hyperdm.dto.CampaignOutputDTO)__campaignList.unmarshal( reader, ___CampaignOutputDTO ));
						reader.endObject();
					} else {
						reader.nextNull();
					}
				}
				reader.endArray();
			} else {
				reader.nextNull();
			}
			break;
		}		
		default :
			reader.skipValue();
			break;
		}
	}
		 
    /**
     * do not use
     */
	public int unmarshal(byte[] bytes, int i, DataObject dataobject){		
		return -1;
	}
	
	/**
     * do not use
     */
	public DataObject unmarshal(Node node) throws UnmarshalException {	
		return null;
	}
    
 	
}

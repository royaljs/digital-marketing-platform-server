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
import com.tmax.proobject.model.dataobject.DataObject;

public class CampaignInputDTOMsgJson extends Message {	
	public byte[] marshal(DataObject obj) throws MarshalException {
		com.tmax.hyperdm.dto.CampaignInputDTO _CampaignInputDTO = (com.tmax.hyperdm.dto.CampaignInputDTO)obj;
		
		if(_CampaignInputDTO == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _CampaignInputDTO, jw);
			
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
	
	
	public void marshal(com.tmax.hyperdm.dto.CampaignInputDTO _CampaignInputDTO, JsonWriter writer )throws IOException {	
	
		writer.name("id"); 
		if (_CampaignInputDTO.getId() != null) {
			writer.value(_CampaignInputDTO.getId());
			 
		} else {
			writer.nullValue();
		}

		writer.name("user_id"); 
		if (_CampaignInputDTO.getUserId() != null) {
			writer.value(_CampaignInputDTO.getUserId());
 
		} else {
			writer.nullValue();
		}

		writer.name("name"); 
		if (_CampaignInputDTO.getName() != null) {
			writer.value(_CampaignInputDTO.getName());
		} else {
			writer.nullValue();
		}
	
		writer.name("type"); 
		if (_CampaignInputDTO.getType() != null) {
			writer.value(_CampaignInputDTO.getType());
		} else {
			writer.nullValue();
		}
		
		writer.name("keyword"); 
		if (_CampaignInputDTO.getKeyword() != null) {
			writer.value(_CampaignInputDTO.getKeyword());
		} else {
			writer.nullValue();
		}
		
		writer.name("last_modified"); 
		if (_CampaignInputDTO.getLastModified() != null) {
			writer.value(_CampaignInputDTO.getLastModified());
		} else {
			writer.nullValue();
		}
		
		writer.name("date_begin"); 
		if (_CampaignInputDTO.getDateBegin() != null) {
			writer.value(_CampaignInputDTO.getDateBegin());
		} else {
			writer.nullValue();
		}
		
		writer.name("date_end"); 
		if (_CampaignInputDTO.getDateEnd() != null) {
			writer.value(_CampaignInputDTO.getDateEnd());
		} else {
			writer.nullValue();
		}
		
		writer.name("product_id"); 
		if (_CampaignInputDTO.getProductId() != null) {
			writer.value(_CampaignInputDTO.getProductId());
		} else {
			writer.nullValue();
		}				  	
		
		writer.name("contents"); 
		if (_CampaignInputDTO.getContents() != null) {
			writer.value(_CampaignInputDTO.getContents());
		} else {
			writer.nullValue();
		}		
		
		writer.name("goal"); 
		if (_CampaignInputDTO.getGoal() != null) {
			writer.value(_CampaignInputDTO.getGoal());
		} else {
			writer.nullValue();
		}	
		
		writer.name("platform"); 
		if (_CampaignInputDTO.getPlatform() != null) {
			writer.value(_CampaignInputDTO.getPlatform());
		} else {
			writer.nullValue();
		}	
		
		writer.name("material"); 
		if (_CampaignInputDTO.getMaterial() != null) {
			writer.value(_CampaignInputDTO.getMaterial());
		} else {
			writer.nullValue();
		}	
		
		writer.name("image_uuid"); 
		if (_CampaignInputDTO.getImageUuid() != null) {
			writer.value(_CampaignInputDTO.getImageUuid());
		} else {
			writer.nullValue();
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
		com.tmax.hyperdm.dto.CampaignInputDTO _CampaignInputDTO = new com.tmax.hyperdm.dto.CampaignInputDTO();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdm.dto.CampaignInputDTO();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
				_CampaignInputDTO = (com.tmax.hyperdm.dto.CampaignInputDTO)unmarshal( jr,  _CampaignInputDTO);
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
		                       
        return _CampaignInputDTO;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws UnmarshalException {		
		
		com.tmax.hyperdm.dto.CampaignInputDTO _CampaignInputDTO = (com.tmax.hyperdm.dto.CampaignInputDTO) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdm.dto.CampaignInputDTO();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));
			jr = new JsonReader( reader );
			jr.beginObject();
					_CampaignInputDTO = (com.tmax.hyperdm.dto.CampaignInputDTO)unmarshal( jr,  _CampaignInputDTO);
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
		                       
	    return _CampaignInputDTO;
	}
		
		
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdm.dto.CampaignInputDTO dto) throws IOException {		 

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdm.dto.CampaignInputDTO dto, JsonReader reader, String name) throws IOException {
		
		switch(name) {		
	
		case "id" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setId( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
	
		case "user_id" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setUserId( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
	
		case "name" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setName( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
	
		case "type" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setType( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "keyword" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setKeyword( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}
		
		case "last_modified" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setLastModified( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}
		
		case "date_begin" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setDateBegin( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "date_end" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setDateEnd( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}
		
		case "product_id" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setProductId( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "contents" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setContents( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "goal" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setGoal( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "platform" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setPlatform( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "material" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setMaterial( reader.nextString());
			} else {
				reader.nextNull();
            }
			break;
		}	
		
		case "image_uuid" :
		{	
			if(reader.peek() != JsonToken.NULL) {
				dto.setImageUuid( reader.nextString());
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

package com.tmax.hyperdm.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.exception.FieldNotFoundException;

@com.tmax.proobject.core.DataObject
public class CampaignArrayDTO extends DataObject {
	private static final String DTO_LOGICAL_NAME = "CampaignArrayDTO";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public CampaignArrayDTO() {
			super();
			
	}
	
	private transient boolean isModified = false;

	/**
	 * LogicalName : campaignList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdm.dto.CampaignOutputDTO> campaignList = null;
	
	public List<com.tmax.hyperdm.dto.CampaignOutputDTO> getCampaignListList() {
        if(campaignList == null)
            return null;
		return this.campaignList;
	}		
	private transient boolean campaignList_nullable = true;
	
	public boolean isNullableCampaignList() {
		return this.campaignList_nullable;
	}
	
	private transient boolean campaignList_invalidation = false;
	
	public void setInvalidationCampaignList(boolean invalidation) { 
		this.campaignList_invalidation = invalidation;
	}
	
	public boolean isInvalidationCampaignList() {
		return this.campaignList_invalidation;
	}
	
	private transient boolean campaignList_modified = false;
	
	public boolean isModifiedCampaignList() {
		if(this.campaignList_modified) return true;
		for(int index=0; index < this.sizeCampaignList(); index++) {
			if(this.getCampaignList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedCampaignList() {
		this.campaignList_modified = false;
	}
	
	public void clearCampaignList() {
		if(campaignList != null)
			campaignList.clear();
		this.campaignList_modified = false;
	}
	
	public void ensureCapacityCampaignList(int minCapacity) {
		if(campaignList == null)
			campaignList = new ArrayList<com.tmax.hyperdm.dto.CampaignOutputDTO>(minCapacity);
		else
			((ArrayList<com.tmax.hyperdm.dto.CampaignOutputDTO>)campaignList).ensureCapacity( minCapacity );	
	}	
	public void createCampaignList(int _size) {
        if(campaignList == null) {
            ensureCapacityCampaignList(_size);
        } else {
            ((ArrayList<com.tmax.hyperdm.dto.CampaignOutputDTO>)campaignList).ensureCapacity(_size);
        }
		for(int i = campaignList.size(); i < _size; i++) {
			campaignList.add( new com.tmax.hyperdm.dto.CampaignOutputDTO());
			this.campaignList_modified = true;
		}
	}
	public CampaignArrayDTO fillCampaignList(int _index) {
		ensureCapacityCampaignList(_index+1);
		for (int i = sizeCampaignList(); i <  _index + 1; i++) {
			this.campaignList.add(i, new com.tmax.hyperdm.dto.CampaignOutputDTO());
			this.campaignList_modified = true;
		}
		return this;
	}
	
	public int sizeCampaignList() {
		if(campaignList == null)
			return 0;
		
		return campaignList.size();
	}
	
	public com.tmax.hyperdm.dto.CampaignOutputDTO[] getCampaignList() {
		if(this.campaignList == null)
			return null;
		
		return (com.tmax.hyperdm.dto.CampaignOutputDTO[])campaignList.toArray(new com.tmax.hyperdm.dto.CampaignOutputDTO[campaignList.size()]);
	}
	public com.tmax.hyperdm.dto.CampaignOutputDTO getCampaignList(int _index) {
		return (com.tmax.hyperdm.dto.CampaignOutputDTO)campaignList.get(_index);
	}
	 
	public void setCampaignList(List<com.tmax.hyperdm.dto.CampaignOutputDTO> campaignList) {
		
		if(campaignList == null) {
			this.campaignList = null;
		} else {
			ensureCapacityCampaignList(campaignList.size());
            this.campaignList.clear();
			for(int i = 0, n=campaignList.size(); i < n; i++) {
				if( campaignList.get(i) == null ) {
					this.campaignList.add(null);
				}
				else {
					this.campaignList.add(campaignList.get(i));
				}
			}
		}
		this.campaignList_modified = true;
		this.isModified = true;
	}
	
	public void setCampaignList(com.tmax.hyperdm.dto.CampaignOutputDTO[] campaignList) {
		
		if(campaignList == null) {
			this.campaignList = null;
		} else {
			ensureCapacityCampaignList(campaignList.length);
            this.campaignList.clear();
			for(int i = 0, n=campaignList.length; i < n; i++) {
				if( campaignList[i] == null ) {
					this.campaignList.add(null);
				}
				else {
					this.campaignList.add(campaignList[i]);
				}
			}
		}
		this.campaignList_modified = true;
		this.isModified = true;
	}
	
	public void setCampaignList(int _index, com.tmax.hyperdm.dto.CampaignOutputDTO campaignList) {
		if(campaignList == null) {
			this.campaignList.set(_index, null);
		} else {
			this.campaignList.set(_index, campaignList);
		}
		this.campaignList_modified = true;
		this.isModified = true;
	}				
		
	
	public void addCampaignList(int _index, com.tmax.hyperdm.dto.CampaignOutputDTO campaignList) {
		if(this.campaignList == null)
			this.campaignList = new ArrayList<com.tmax.hyperdm.dto.CampaignOutputDTO>(9);
		if(campaignList == null) {
			this.campaignList.add(_index, null);
		} else {
			this.campaignList.add(_index, campaignList);
		}
		this.campaignList_modified = true;
		this.isModified = true;
	}
		
	public void addCampaignList(com.tmax.hyperdm.dto.CampaignOutputDTO campaignList) {
		if(this.campaignList == null)
			this.campaignList = new ArrayList<com.tmax.hyperdm.dto.CampaignOutputDTO>(10);
		if(campaignList == null) {
			this.campaignList.add(null);
		} else {
			this.campaignList.add(campaignList);
		}
		this.campaignList_modified = true;
		this.isModified = true;
	}
		
	
	public com.tmax.hyperdm.dto.CampaignOutputDTO removeCampaignList(int _index) {
		this.campaignList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdm.dto.CampaignOutputDTO)this.campaignList.remove(_index);
	}


	@Override
	public void clearAllIsModified() {
		this.campaignList_modified = false;
		for(int index=0; index < this.sizeCampaignList(); index++) {
			if(this.getCampaignList(index) != null)
				this.getCampaignList(index).clearAllIsModified();
		}
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.campaignList_modified == true)
			modifiedFields.add("campaignList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	}
	 
	public Object clone() {
		CampaignArrayDTO copyObj = new CampaignArrayDTO();	
		copyObj.clone(this);
		return copyObj;
	}
	
	public void clone(DataObject _CampaignArrayDTO) {
		if(this == _CampaignArrayDTO) return;
		CampaignArrayDTO __CampaignArrayDTO = (CampaignArrayDTO) _CampaignArrayDTO;
		
		this.clearCampaignList();
        if(this.getCampaignList() == null && __CampaignArrayDTO.getCampaignList() != null)
            this.ensureCapacityCampaignList(__CampaignArrayDTO.sizeCampaignList());
        
		for (int index = 0; index < __CampaignArrayDTO.sizeCampaignList(); index++) {
            com.tmax.hyperdm.dto.CampaignOutputDTO _value0 = __CampaignArrayDTO.getCampaignList(index);
            if(_value0 == null) {
                this.addCampaignList(index, null);
            } else {
                this.addCampaignList(index, (com.tmax.hyperdm.dto.CampaignOutputDTO)_value0.clone());		
            }
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("campaignList [");
		for (int index = 0; index < sizeCampaignList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getCampaignList(index)).append(" ");
		}

		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("campaignList", FieldProperty.builder()
              .setPhysicalName("campaignList")
              .setLogicalName("campaignList")
              .setType(FieldProperty.TYPE_ABSTRACT_INCLUDE)
              .setDecimal(-1)
              .setArray("10")
              .setReference("com.tmax.hyperdm.dto.CampaignOutputDTO")
              .build());
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return Collections.unmodifiableMap(fieldPropertyMap);
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return Collections.unmodifiableMap(fieldPropertyMap);
	}	

	@SuppressWarnings("unchecked")
	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "campaignList" : return getCampaignListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}

	@SuppressWarnings("unchecked")
	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "campaignList" : setCampaignList((List<com.tmax.hyperdm.dto.CampaignOutputDTO>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		CampaignArrayDTO _CampaignArrayDTO = (CampaignArrayDTO) obj;
		if(this.campaignList == null) {
			if(_CampaignArrayDTO.getCampaignListList() != null)
				return false;
		}

		if(sizeCampaignList() != _CampaignArrayDTO.sizeCampaignList()) return false;
		else {
			for(int i = 0, n = sizeCampaignList(); i < n; i++ ){ 
                if(this.getCampaignList(i) == null && _CampaignArrayDTO.getCampaignList(i) != null) return false;
                if(this.getCampaignList(i) == null && _CampaignArrayDTO.getCampaignList(i) == null) continue;
                    
				if(!this.getCampaignList(i).equals(_CampaignArrayDTO.getCampaignList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime  = 31;
		int result = 1;
		result     = prime * result + ((this.campaignList == null) ? 0 : this.campaignList.hashCode());
		return result;
	}
	
	@Override
	public void clear() {
		campaignList = null;	
		clearAllIsModified();
	}

	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}

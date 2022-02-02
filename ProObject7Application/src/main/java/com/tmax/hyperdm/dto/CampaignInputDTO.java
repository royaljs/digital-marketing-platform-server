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
public class CampaignInputDTO extends DataObject {
	private static final String DTO_LOGICAL_NAME = "CampaignInputDTO";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public CampaignInputDTO() {
			super();
	}
	
	private transient boolean isModified = false;

	/**
	 * LogicalName : id
	 * Comments    : 캠페인의 id
	 */		

	private String id = null;
	
	private transient boolean id_nullable = false;
	
	public boolean isNullableId() {
		return this.id_nullable;
	}
	
	private transient boolean id_invalidation = false;
	
	public void setInvalidationId(boolean invalidation) { 
		this.id_invalidation = invalidation;
	}
	
	public boolean isInvalidationId() {
		return this.id_invalidation;
	}
	
	private transient boolean id_modified = false;
	

	public boolean isModifiedId() {
		return this.id_modified;
	}
	
	public void unModifiedId() {
		this.id_modified = false;
	}

	public FieldProperty getIdFieldProperty() {
		return fieldPropertyMap.get("id");
	}

	public String getId() {
		return id;
	}
	public String getNvlId() {
		if(getId() == null) {
			return EMPTY_STRING;
		} else {
			return getId();
		}
	}
	
	public void setId(String id) {
		if(id == null) {
			this.id = null;
		} else {
			this.id = id;
		}
		this.id_modified = true;
		this.isModified = true;
	}		


	/**
	 * LogicalName : user_id
	 * Comments    : 캠페인을 작성/소유한 유저의 id
	 */		

	private String user_id = null;
	
	private transient boolean user_id_nullable = false;
	
	public boolean isNullableUserId() {
		return this.user_id_nullable;
	}
	
	private transient boolean user_id_invalidation = false;
	
	public void setInvalidationUserId(boolean invalidation) { 
		this.user_id_invalidation = invalidation;
	}
	
	public boolean isInvalidationUserId() {
		return this.user_id_invalidation;
	}
	
	private transient boolean user_id_modified = false;
	

	public boolean isModifiedUserId() {
		return this.user_id_modified;
	}
	
	public void unModifiedUserId() {
		this.user_id_modified = false;
	}

	public FieldProperty getUserIdFieldProperty() {
		return fieldPropertyMap.get("user_id");
	}

	public String getUserId() {
		return user_id;
	}
	public String getNvlUserId() {
		if(getUserId() == null) {
			return EMPTY_STRING;
		} else {
			return getUserId();
		}
	}
	
	public void setUserId(String user_id) {
		if(user_id == null) {
			this.user_id = null;
		} else {
			this.user_id = user_id;
		}
		this.user_id_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : name
	 * Comments    : 캠페인의 이름
	 */		

	private String name = null;
	
	private transient boolean name_nullable = false;
	
	public boolean isNullableName() {
		return this.name_nullable;
	}
	
	private transient boolean name_invalidation = false;
	
	public void setInvalidationName(boolean invalidation) { 
		this.name_invalidation = invalidation;
	}
	
	public boolean isInvalidationName() {
		return this.name_invalidation;
	}
	
	private transient boolean name_modified = false;
	

	public boolean isModifiedName() {
		return this.name_modified;
	}
	
	public void unModifiedName() {
		this.name_modified = false;
	}

	public FieldProperty getNameFieldProperty() {
		return fieldPropertyMap.get("name");
	}

	public String getName() {
		return name;
	}
	public String getNvlName() {
		if(getName() == null) {
			return EMPTY_STRING;
		} else {
			return getName();
		}
	}
	
	public void setName(String name) {
		if(name == null) {
			this.name = null;
		} else {
			this.name = name;
		}
		this.name_modified = true;
		this.isModified = true;
	}		

	
	
	/**
	 * LogicalName : type
	 * Comments    : 캠페인의 종류(이벤트, 광고, 카탈로그 등)
	 */		

	private String type = null;
	
	private transient boolean type_nullable = true;
	
	public boolean isNullableType() {
		return this.type_nullable;
	}
	
	private transient boolean type_invalidation = false;
	
	public void setInvalidationType(boolean invalidation) { 
		this.type_invalidation = invalidation;
	}
	
	public boolean isInvalidationType() {
		return this.type_invalidation;
	}
	
	private transient boolean type_modified = false;
	

	public boolean isModifiedType() {
		return this.type_modified;
	}
	
	public void unModifiedType() {
		this.type_modified = false;
	}

	public FieldProperty getTypeFieldProperty() {
		return fieldPropertyMap.get("type");
	}

	public String getType() {
		return type;
	}
	public String getNvlType() {
		if(getType() == null) {
			return EMPTY_STRING;
		} else {
			return getType();
		}
	}
	
	public void setType(String type) {
		if(type == null) {
			this.type = null;
		} else {
			this.type = type;
		}
		this.type_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : keyword
	 * Comments    : 캠페인의 키워드
	 */		

	private String keyword = null;
	
	private transient boolean keyword_nullable = true;
	
	public boolean isNullableKeyword() {
		return this.keyword_nullable;
	}
	
	private transient boolean keyword_invalidation = false;
	
	public void setInvalidationKeyword(boolean invalidation) { 
		this.keyword_invalidation = invalidation;
	}
	
	public boolean isInvalidationKeyword() {
		return this.keyword_invalidation;
	}
	
	private transient boolean keyword_modified = false;
	

	public boolean isModifiedKeyword() {
		return this.keyword_modified;
	}
	
	public void unModifiedKeyword() {
		this.keyword_modified = false;
	}

	public FieldProperty getKeywordFieldProperty() {
		return fieldPropertyMap.get("keyword");
	}

	public String getKeyword() {
		return keyword;
	}
	public String getNvlKeyword() {
		if(getKeyword() == null) {
			return EMPTY_STRING;
		} else {
			return getKeyword();
		}
	}
	
	public void setKeyword(String keyword) {
		if(keyword == null) {
			this.keyword = null;
		} else {
			this.keyword = keyword;
		}
		this.keyword_modified = true;
		this.isModified = true;
	}		
	
	
	/**
	 * LogicalName : last_modified
	 * Comments    : 캠페인 최종 수정 시각
	 */		

	private String last_modified = null;
	
	private transient boolean last_modified_nullable = true;
	
	public boolean isNullableLastModified() {
		return this.last_modified_nullable;
	}
	
	private transient boolean last_modified_invalidation = false;
	
	public void setInvalidationLastModified(boolean invalidation) { 
		this.last_modified_invalidation = invalidation;
	}
	
	public boolean isInvalidationLastModified() {
		return this.last_modified_invalidation;
	}
	
	private transient boolean last_modified_modified = false;
	

	public boolean isModifiedLastModified() {
		return this.last_modified_modified;
	}
	
	public void unModifiedLastModified() {
		this.last_modified_modified = false;
	}

	public FieldProperty getLastModifiedFieldProperty() {
		return fieldPropertyMap.get("last_modified");
	}

	public String getLastModified() {
		return last_modified;
	}
	public String getNvlLastModified() {
		if(getLastModified() == null) {
			return EMPTY_STRING;
		} else {
			return getLastModified();
		}
	}
	
	public void setLastModified(String last_modified) {
		if(last_modified == null) {
			this.last_modified = null;
		} else {
			this.last_modified = last_modified;
		}
		this.last_modified_modified = true;
		this.isModified = true;
	}	
	
	
	/**
	 * LogicalName : date_begin
	 * Comments    : 캠페인 시작 시각
	 */		

	private String date_begin = null;
	
	private transient boolean date_begin_nullable = true;
	
	public boolean isNullableDateBegin() {
		return this.date_begin_nullable;
	}
	
	private transient boolean date_begin_invalidation = false;
	
	public void setInvalidationDateBegin(boolean invalidation) { 
		this.date_begin_invalidation = invalidation;
	}
	
	public boolean isInvalidationDateBegin() {
		return this.date_begin_invalidation;
	}
	
	private transient boolean date_begin_modified = false;
	

	public boolean isModifiedDateBegin() {
		return this.date_begin_modified;
	}
	
	public void unModifiedDateBegin() {
		this.date_begin_modified = false;
	}

	public FieldProperty getDateBeginFieldProperty() {
		return fieldPropertyMap.get("date_begin");
	}

	public String getDateBegin() {
		return date_begin;
	}
	public String getNvlDateBegin() {
		if(getDateBegin() == null) {
			return EMPTY_STRING;
		} else {
			return getDateBegin();
		}
	}
	
	public void setDateBegin(String date_begin) {
		if(date_begin == null) {
			this.date_begin = null;
		} else {
			this.date_begin = date_begin;
		}
		this.date_begin_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : date_end
	 * Comments    : 캠페인 종료 시각
	 */		

	private String date_end = null;
	
	private transient boolean date_end_nullable = true;
	
	public boolean isNullableDateEnd() {
		return this.date_end_nullable;
	}
	
	private transient boolean date_end_invalidation = false;
	
	public void setInvalidationDateEnd(boolean invalidation) { 
		this.date_end_invalidation = invalidation;
	}
	
	public boolean isInvalidationDateEnd() {
		return this.date_end_invalidation;
	}
	
	private transient boolean date_end_modified = false;
	

	public boolean isModifiedDateEnd() {
		return this.date_end_modified;
	}
	
	public void unModifiedDateEnd() {
		this.date_end_modified = false;
	}

	public FieldProperty getDateEndFieldProperty() {
		return fieldPropertyMap.get("date_end");
	}

	public String getDateEnd() {
		return date_end;
	}
	public String getNvlDateEnd() {
		if(getDateEnd() == null) {
			return EMPTY_STRING;
		} else {
			return getDateEnd();
		}
	}
	
	public void setDateEnd(String date_end) {
		if(date_end == null) {
			this.date_end = null;
		} else {
			this.date_end = date_end;
		}
		this.date_end_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : product_id
	 * Comments    : 캠페인 관련 상품 id
	 */		

	private String product_id = null;
	
	private transient boolean product_id_nullable = true;
	
	public boolean isNullableProductId() {
		return this.product_id_nullable;
	}
	
	private transient boolean product_id_invalidation = false;
	
	public void setInvalidationProductId(boolean invalidation) { 
		this.product_id_invalidation = invalidation;
	}
	
	public boolean isInvalidationProductId() {
		return this.product_id_invalidation;
	}
	
	private transient boolean product_id_modified = false;
	

	public boolean isModifiedProductId() {
		return this.product_id_modified;
	}
	
	public void unModifiedProductId() {
		this.product_id_modified = false;
	}

	public FieldProperty getProductIdFieldProperty() {
		return fieldPropertyMap.get("product_id");
	}

	public String getProductId() {
		return product_id;
	}
	public String getNvlProductId() {
		if(getProductId() == null) {
			return EMPTY_STRING;
		} else {
			return getProductId();
		}
	}
	
	public void setProductId(String product_id) {
		if(product_id == null) {
			this.product_id = null;
		} else {
			this.product_id = product_id;
		}
		this.product_id_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : contents
	 * Comments    : 컨텐츠 style props
	 */		

	private String contents = null;
	
	private transient boolean contents_nullable = true;
	
	public boolean isNullableContents() {
		return this.contents_nullable;
	}
	
	private transient boolean contents_invalidation = false;
	
	public void setInvalidationContents(boolean invalidation) { 
		this.contents_invalidation = invalidation;
	}
	
	public boolean isInvalidationContents() {
		return this.contents_invalidation;
	}
	
	private transient boolean contents_modified = false;
	

	public boolean isModifiedContents() {
		return this.contents_modified;
	}
	
	public void unModifiedContents() {
		this.contents_modified = false;
	}

	public FieldProperty getContentsFieldProperty() {
		return fieldPropertyMap.get("contents");
	}

	public String getContents() {
		return contents;
	}
	public String getNvlContents() {
		if(getContents() == null) {
			return EMPTY_STRING;
		} else {
			return getContents();
		}
	}
	
	public void setContents(String contents) {
		if(contents == null) {
			this.contents = null;
		} else {
			this.contents = contents;
		}
		this.contents_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : image_uuid
	 * Comments    : 캠페인 이미지
	 */		

	private String image_uuid = null;
	
	private transient boolean image_uuid_nullable = true;
	
	public boolean isNullableImageUuid() {
		return this.image_uuid_nullable;
	}
	
	private transient boolean image_uuid_invalidation = false;
	
	public void setInvalidationImageUuid(boolean invalidation) { 
		this.image_uuid_invalidation = invalidation;
	}
	
	public boolean isInvalidationImageUuid() {
		return this.image_uuid_invalidation;
	}
	
	private transient boolean image_uuid_modified = false;
	

	public boolean isModifiedImageUuid() {
		return this.image_uuid_modified;
	}
	
	public void unModifiedImageUuid() {
		this.image_uuid_modified = false;
	}

	public FieldProperty getImageUuidFieldProperty() {
		return fieldPropertyMap.get("image_uuid");
	}

	public String getImageUuid() {
		return image_uuid;
	}
	public String getNvlImageUuid() {
		if(getImageUuid() == null) {
			return EMPTY_STRING;
		} else {
			return getImageUuid();
		}
	}
	
	public void setImageUuid(String image_uuid) {
		if(image_uuid == null) {
			this.image_uuid = null;
		} else {
			this.image_uuid = image_uuid;
		}
		this.image_uuid_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : goal
	 * Comments    : 캠페인 목표(ex. 방문, 전환)
	 */		

	private String goal = null;
	
	private transient boolean goal_nullable = true;
	
	public boolean isNullableGoal() {
		return this.goal_nullable;
	}
	
	private transient boolean goal_invalidation = false;
	
	public void setInvalidationGoal(boolean invalidation) { 
		this.goal_invalidation = invalidation;
	}
	
	public boolean isInvalidationGoal() {
		return this.goal_invalidation;
	}
	
	private transient boolean goal_modified = false;
	

	public boolean isModifiedGoal() {
		return this.goal_modified;
	}
	
	public void unModifiedGoal() {
		this.goal_modified = false;
	}

	public FieldProperty getGoalFieldProperty() {
		return fieldPropertyMap.get("goal");
	}

	public String getGoal() {
		return goal;
	}
	public String getNvlGoal() {
		if(getGoal() == null) {
			return EMPTY_STRING;
		} else {
			return getGoal();
		}
	}
	
	public void setGoal(String goal) {
		if(goal == null) {
			this.goal = null;
		} else {
			this.goal = goal;
		}
		this.goal_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : platform
	 * Comments    : 캠페인 플랫폼(ex. 와플, 카카오)
	 */		

	private String platform = null;
	
	private transient boolean platform_nullable = true;
	
	public boolean isNullablePlatform() {
		return this.platform_nullable;
	}
	
	private transient boolean platform_invalidation = false;
	
	public void setInvalidationPlatform(boolean invalidation) { 
		this.platform_invalidation = invalidation;
	}
	
	public boolean isInvalidationPlatform() {
		return this.platform_invalidation;
	}
	
	private transient boolean platform_modified = false;
	

	public boolean isModifiedPlatform() {
		return this.platform_modified;
	}
	
	public void unModifiedPlatform() {
		this.platform_modified = false;
	}

	public FieldProperty getPlatformFieldProperty() {
		return fieldPropertyMap.get("platform");
	}

	public String getPlatform() {
		return platform;
	}
	public String getNvlPlatform() {
		if(getPlatform() == null) {
			return EMPTY_STRING;
		} else {
			return getPlatform();
		}
	}
	
	public void setPlatform(String platform) {
		if(platform == null) {
			this.platform = null;
		} else {
			this.platform = platform;
		}
		this.platform_modified = true;
		this.isModified = true;
	}
	
	/**
	 * LogicalName : material
	 * Comments    : 캠페인 소재(ex. 이미지, 비디오)
	 */		

	private String material = null;
	
	private transient boolean material_nullable = true;
	
	public boolean isNullableMaterial() {
		return this.material_nullable;
	}
	
	private transient boolean material_invalidation = false;
	
	public void setInvalidationMaterial(boolean invalidation) { 
		this.material_invalidation = invalidation;
	}
	
	public boolean isInvalidationMaterial() {
		return this.material_invalidation;
	}
	
	private transient boolean material_modified = false;
	

	public boolean isModifiedMaterial() {
		return this.material_modified;
	}
	
	public void unModifiedMaterial() {
		this.material_modified = false;
	}

	public FieldProperty getMaterialFieldProperty() {
		return fieldPropertyMap.get("material");
	}

	public String getMaterial() {
		return material;
	}
	public String getNvlMaterial() {
		if(getMaterial() == null) {
			return EMPTY_STRING;
		} else {
			return getMaterial();
		}
	}
	
	public void setMaterial(String material) {
		if(material == null) {
			this.material = null;
		} else {
			this.material = material;
		}
		this.material_modified = true;
		this.isModified = true;
	}
	
	/**  **/
	

	@Override
	public void clearAllIsModified() {
		this.id_modified = false;
		this.user_id_modified = false;
		this.name_modified = false;
		this.type_modified = false;
		this.keyword_modified = false;
		this.last_modified_modified = false;
		this.date_begin_modified = false;
		this.date_end_modified = false;
		this.product_id_modified = false;
		this.contents_modified = false;
		this.image_uuid_modified = false;
		this.goal_modified = false;
		this.platform_modified = false;
		this.material_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.id_modified == true)
			modifiedFields.add("id");
		if(this.user_id_modified == true)
			modifiedFields.add("user_id");
		if(this.name_modified == true)
			modifiedFields.add("name");
		if(this.type_modified == true)
			modifiedFields.add("type");
		if(this.keyword_modified == true)
			modifiedFields.add("keyword");
		if(this.last_modified_modified == true)
			modifiedFields.add("last_modified");
		if(this.date_begin_modified == true)
			modifiedFields.add("date_begin");
		if(this.date_end_modified == true)
			modifiedFields.add("date_end");
		if(this.product_id_modified == true)
			modifiedFields.add("product_id");
		if(this.contents_modified == true)
			modifiedFields.add("contents");
		if(this.goal_modified == true)
			modifiedFields.add("goal");
		if(this.platform_modified == true)
			modifiedFields.add("platform");
		if(this.material_modified == true)
			modifiedFields.add("material");
		if(this.image_uuid_modified == true)
			modifiedFields.add("image_uuid");
		
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	}
	 
	public Object clone() {
		CampaignInputDTO copyObj = new CampaignInputDTO();	
		copyObj.clone(this);
		return copyObj;
	}
	
	public void clone(DataObject _CampaignInputDTO) {
		if(this == _CampaignInputDTO) return;
		CampaignInputDTO __CampaignInputDTO = (CampaignInputDTO) _CampaignInputDTO;
		this.setId(__CampaignInputDTO.getId());
		this.setUserId(__CampaignInputDTO.getUserId());
		this.setName(__CampaignInputDTO.getName());
		this.setType(__CampaignInputDTO.getType());
		this.setKeyword(__CampaignInputDTO.getKeyword());
		this.setLastModified(__CampaignInputDTO.getLastModified());
		this.setDateBegin(__CampaignInputDTO.getDateBegin());
		this.setDateEnd(__CampaignInputDTO.getDateEnd());
		this.setProductId(__CampaignInputDTO.getProductId());	
		this.setContents(__CampaignInputDTO.getContents());	
		this.setGoal(__CampaignInputDTO.getGoal());
		this.setPlatform(__CampaignInputDTO.getPlatform());
		this.setMaterial(__CampaignInputDTO.getMaterial());
		this.setImageUuid(__CampaignInputDTO.getImageUuid());
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("id : ").append(id).append("\n");				
		buffer.append("user_id : ").append(user_id).append("\n");		
		buffer.append("name : ").append(name).append("\n");	
		buffer.append("type : ").append(type).append("\n");	
		buffer.append("keyword : ").append(keyword).append("\n");	
		buffer.append("last_modified : ").append(last_modified).append("\n");	
		buffer.append("date_begin : ").append(date_begin).append("\n");	
		buffer.append("date_end : ").append(date_end).append("\n");	
		buffer.append("product_id : ").append(product_id).append("\n");
		buffer.append("contents : ").append(contents).append("\n");
		buffer.append("goal : ").append(goal).append("\n");
		buffer.append("platform : ").append(platform).append("\n");
		buffer.append("material : ").append(material).append("\n");
		buffer.append("image_uuid : ").append(image_uuid).append("\n");
		
		return buffer.toString();
	}
	
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(14);
		fieldPropertyMap.put("id", FieldProperty.builder()
              .setPhysicalName("id")
              .setLogicalName("id")
              .setType(FieldProperty.TYPE_OBJECT_STRING)
              .setLength(20)
              .setDecimal(-1)
              .build());
		fieldPropertyMap.put("user_id", FieldProperty.builder()
              .setPhysicalName("user_id")
              .setLogicalName("user_id")
              .setType(FieldProperty.TYPE_OBJECT_STRING)
              .setLength(20)
              .setDecimal(-1)
              .build());
		fieldPropertyMap.put("name", FieldProperty.builder()
	              .setPhysicalName("name")
	              .setLogicalName("name")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("type", FieldProperty.builder()
              .setPhysicalName("type")
              .setLogicalName("type")
              .setType(FieldProperty.TYPE_OBJECT_STRING)
              .setLength(100)
              .setDecimal(-1)
              .build());
		fieldPropertyMap.put("keyword", FieldProperty.builder()
	              .setPhysicalName("keyword")
	              .setLogicalName("keyword")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("last_modified", FieldProperty.builder()
	              .setPhysicalName("last_modified")
	              .setLogicalName("last_modified")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(20)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("date_begin", FieldProperty.builder()
	              .setPhysicalName("date_begin")
	              .setLogicalName("date_begin")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(20)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("date_end", FieldProperty.builder()
	              .setPhysicalName("date_end")
	              .setLogicalName("date_end")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(20)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("product_id", FieldProperty.builder()
	              .setPhysicalName("product_id")
	              .setLogicalName("product_id")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(20)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("contents", FieldProperty.builder()
	              .setPhysicalName("contents")
	              .setLogicalName("contents")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(65532)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("goal", FieldProperty.builder()
	              .setPhysicalName("goal")
	              .setLogicalName("goal")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("platform", FieldProperty.builder()
	              .setPhysicalName("platform")
	              .setLogicalName("platform")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("material", FieldProperty.builder()
	              .setPhysicalName("material")
	              .setLogicalName("material")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
	              .build());
		fieldPropertyMap.put("image_uuid", FieldProperty.builder()
	              .setPhysicalName("image_uuid")
	              .setLogicalName("image_uuid")
	              .setType(FieldProperty.TYPE_OBJECT_STRING)
	              .setLength(100)
	              .setDecimal(-1)
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
			case "id" : return getId();
			case "user_id" : return getUserId();
			case "name" : return getName();
			case "type" : return getType();
			case "keyword" : return getKeyword();
			case "last_modified" : return getLastModified();
			case "date_begin" : return getDateBegin();
			case "date_end" : return getDateEnd();
			case "product_id" : return getProductId();
			case "contents" : return getContents();
			case "goal" : return getGoal();
			case "platform" : return getPlatform();
			case "material" : return getMaterial();
			case "image_uuid" : return getImageUuid();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}

	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : setId(arg.toString());break;
			case "user_id" : setUserId(arg.toString());break;
			case "name" : setName(arg.toString());break;
			case "type" : setType(arg.toString());break;
			case "keyword" : setKeyword(arg.toString());break;
			case "last_modified" : setLastModified(arg.toString());break;
			case "date_begin" : setDateBegin(arg.toString());break;
			case "date_end" : setDateEnd(arg.toString());break;
			case "product_id" : setProductId(arg.toString());break;
			case "contents" : setContents(arg.toString());break;
			case "goal" : setGoal(arg.toString());break;
			case "platform" : setPlatform(arg.toString());break;
			case "material" : setMaterial(arg.toString());break;
			case "image_uuid" : setImageUuid(arg.toString());break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		CampaignInputDTO _CampaignInputDTO = (CampaignInputDTO) obj;

		if(this.id == null) {
			if(_CampaignInputDTO.getId() != null)
				return false;
		} else if(!this.id.equals(_CampaignInputDTO.getId()))
			return false;
		if(this.user_id == null) {
			if(_CampaignInputDTO.getUserId() != null)
				return false;
		} else if(!this.user_id.equals(_CampaignInputDTO.getUserId()))
			return false;
		if(this.name == null) {
			if(_CampaignInputDTO.getName() != null)
				return false;
		} else if(!this.name.equals(_CampaignInputDTO.getName()))
			return false;
		if(this.type == null) {
			if(_CampaignInputDTO.getType() != null)
				return false;
		} else if(!this.type.equals(_CampaignInputDTO.getType()))
			return false;
		if(this.keyword == null) {
			if(_CampaignInputDTO.getKeyword() != null)
				return false;
		} else if(!this.keyword.equals(_CampaignInputDTO.getKeyword()))
			return false;
		if(this.last_modified == null) {
			if(_CampaignInputDTO.getLastModified() != null)
				return false;
		} else if(!this.last_modified.equals(_CampaignInputDTO.getLastModified()))
			return false;
		if(this.date_begin == null) {
			if(_CampaignInputDTO.getDateBegin() != null)
				return false;
		} else if(!this.date_begin.equals(_CampaignInputDTO.getDateBegin()))
			return false;
		if(this.date_end == null) {
			if(_CampaignInputDTO.getDateEnd() != null)
				return false;
		} else if(!this.date_end.equals(_CampaignInputDTO.getDateEnd()))
			return false;
		if(this.product_id == null) {
			if(_CampaignInputDTO.getProductId() != null)
				return false;
		} else if(!this.product_id.equals(_CampaignInputDTO.getProductId()))
			return false;
		if(this.contents == null) {
			if(_CampaignInputDTO.getContents() != null)
				return false;
		} else if(!this.contents.equals(_CampaignInputDTO.getContents()))
			return false;
		if(this.goal == null) {
			if(_CampaignInputDTO.getGoal() != null)
				return false;
		} else if(!this.goal.equals(_CampaignInputDTO.getGoal()))
			return false;
		if(this.platform == null) {
			if(_CampaignInputDTO.getPlatform() != null)
				return false;
		} else if(!this.platform.equals(_CampaignInputDTO.getPlatform()))
			return false;
		if(this.material == null) {
			if(_CampaignInputDTO.getMaterial() != null)
				return false;
		} else if(!this.material.equals(_CampaignInputDTO.getMaterial()))
			return false;
		if(this.image_uuid == null) {
			if(_CampaignInputDTO.getImageUuid() != null)
				return false;
		} else if(!this.image_uuid.equals(_CampaignInputDTO.getImageUuid()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime  = 31;
		int result = 1;		
		result     = prime * result + ((this.id == null) ? 0 : this.id.hashCode());					
		result     = prime * result + ((this.user_id == null) ? 0 : this.user_id.hashCode());	
		result     = prime * result + ((this.name == null) ? 0 : this.name.hashCode());	
		result     = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		result     = prime * result + ((this.keyword == null) ? 0 : this.keyword.hashCode());
		result     = prime * result + ((this.last_modified == null) ? 0 : this.last_modified.hashCode());
		result     = prime * result + ((this.date_begin == null) ? 0 : this.date_begin.hashCode());
		result     = prime * result + ((this.date_end == null) ? 0 : this.date_end.hashCode());
		result     = prime * result + ((this.product_id == null) ? 0 : this.product_id.hashCode());
		result     = prime * result + ((this.contents == null) ? 0 : this.contents.hashCode());
		result     = prime * result + ((this.goal == null) ? 0 : this.goal.hashCode());
		result     = prime * result + ((this.platform == null) ? 0 : this.platform.hashCode());
		result     = prime * result + ((this.material == null) ? 0 : this.material.hashCode());
		result     = prime * result + ((this.image_uuid == null) ? 0 : this.image_uuid.hashCode());
		
		return result;
	}
	
	@Override
	public void clear() {
		id = null;
		user_id = null;
		name = null;
		type = null;
		keyword = null;
		last_modified = null;
		date_begin = null;
		date_end = null;
		product_id = null;
		contents = null;
		goal = null;
		platform = null;
		material = null;
		image_uuid = null;
		
		clearAllIsModified();
	}

	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
}

package com.tmax.hyperdm;
        
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tmax.hyperdm.dto.CampaignInputDTO;
import com.tmax.proobject.dataobject.factory.DBDataObjectFactory;
import com.tmax.proobject.dataobject.factory.Query;
import com.tmax.proobject.dataobject.model.MetaField;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.dataobject.Session;
import com.tmax.proobject.model.exception.FieldNotFoundException;

public class CampaignDOF extends DBDataObjectFactory<CampaignInputDTO>
{
	public CampaignDOF(){
		super();
	}
	
	public CampaignDOF(Session session){
		super(session);
	}
	
	public CampaignDOF(String datasource){
		super(datasource);
	}
	
	public CampaignDOF(String datasource, boolean autocommit){
			super(datasource, autocommit);
	}
	
	private String _id;
	
	
	public static enum FULLQUERY  implements Query {
		SELECTLISTSQL("SELECT * from CAMPAIGN ORDER BY ID"),
		SELECTSQL("SELECT * FROM CAMPAIGN WHERE ID = ?"),
		INSERTSQL("INSERT INTO CAMPAIGN (ID, USER_ID, NAME, TYPE, KEYWORD, LAST_MODIFIED, DATE_BEGIN, DATE_END, PRODUCT_ID, CONTENTS, GOAL, PLATFORM, MATERIAL, IMAGE_UUID) VALUES (CAMPAIGN_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
		UPDATESQL("UPDATE CAMPAIGN SET USER_ID = ?, NAME = ?, TYPE = ?, KEYWORD = ?, LAST_MODIFIED = ?, DATE_BEGIN = ?, DATE_END = ?, PRODUCT_ID = ?, CONTENTS = ?, GOAL = ?, PLATFORM = ?, MATERIAL = ? WHERE ID = ?"),
		DELETESQL("DELETE FROM CAMPAIGN WHERE ID = ?")
	;
		private final String value;
	
		FULLQUERY(String v) {
			value = v;
		}
	
		public String value() {
			return value;
		}
	
		public static FULLQUERY fromValue(String v) {
			return valueOf(v);
		}
		
		public static Query getDefaultQuery(DBType type) {
			switch(type) {
				case SELECT :
					return FULLQUERY.SELECTSQL;
				case INSERT :
					return FULLQUERY.INSERTSQL;
				case UPDATE :
					return FULLQUERY.UPDATESQL;
				case DELETE :
					return FULLQUERY.DELETESQL;
				default :
					return null;
			}
		}
	}
	
	private static String[] _QUERY_TABLES = {"CAMPAIGN"};
	private static List<MetaField> _FACTORY_FIELDS = new ArrayList<MetaField>();
	
	@Override
	public void init() {
		_id = null;
		super.init();
	}
	
	@Override
	public String[] getQueryTables() {
	    return _QUERY_TABLES.clone();
	}      
	
	@Override
	public Query getDefaultQuery(DBType type) {
		return FULLQUERY.getDefaultQuery(type);
	}
	
	@Override
	public CampaignInputDTO getDataObject() {
		return new CampaignInputDTO();
	}
	
	public void setFullQuery(CampaignDOF.FULLQUERY query) {
		useFullQuery = true;
		logger.info("쿼리문: "+ query.value);
		this.query = query;
	}
	
	public void setFullQuery(String name) {
		CampaignDOF.FULLQUERY query = CampaignDOF.FULLQUERY.valueOf(name);
		setFullQuery(query);
	}
	
	@Override
	public List<MetaField> getFactoryFields() {
		return _FACTORY_FIELDS;
	}
	
	public String getId() {
	    return _id;
	}
	
	public void setId(String _id) {
	    this._id = _id;
	}
	
	@Override
	public Object getField(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
		case "id" : return _id;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}    
	
	@Override
	public void setField(String fieldName, Object value) throws FieldNotFoundException {
		switch(fieldName) {
		case "id" : this._id = ((String)value); break;
		default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	@Override
	public Class<?> getFieldClassType(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" :
				return String.class;
			default : throw new FieldNotFoundException("unknown fieldName : "+fieldName+"("+fieldName.hashCode()+")");
		}
	}
	
	@Override
	public void onPrepareFullQuery(PreparedStatement ps, DataObject dataObject) {
		if(useFullQuery && query == CampaignDOF.FULLQUERY.SELECTSQL) {
			onPrepareFullQuerySelectsql(ps, (CampaignInputDTO)dataObject);
		} else if(useFullQuery && query == CampaignDOF.FULLQUERY.INSERTSQL) {
			onPrepareFullQueryInsertsql(ps, (CampaignInputDTO)dataObject);
		} else if(useFullQuery && query == CampaignDOF.FULLQUERY.UPDATESQL) {
			onPrepareFullQueryUpdatesql(ps, (CampaignInputDTO)dataObject);
		} else if(useFullQuery && query == CampaignDOF.FULLQUERY.DELETESQL) {
			onPrepareFullQueryDeletesql(ps, (CampaignInputDTO)dataObject);
		}
	}
	
	public void onPrepareFullQueryInsertsql (PreparedStatement ps, CampaignInputDTO dataObject) {
		if(dataObject.getUserId() != null)
			set(index++, String.class, dataObject.getUserId(), "user_id", ps);
		if(dataObject.getName() != null)
			set(index++, String.class, dataObject.getName(), "name", ps);
		if(dataObject.getType() != null)
			set(index++, String.class, dataObject.getType(), "type", ps);
		if(dataObject.getKeyword() != null)
			set(index++, String.class, dataObject.getKeyword(), "keyword", ps);
		if(dataObject.getLastModified() != null)
			set(index++, String.class, dataObject.getLastModified(), "last_modified", ps);
		if(dataObject.getDateBegin() != null)
			set(index++, String.class, dataObject.getDateBegin(), "date_begin", ps);
		if(dataObject.getDateEnd() != null)
			set(index++, String.class, dataObject.getDateEnd(), "date_end", ps);
		if(dataObject.getProductId() != null)
			set(index++, String.class, dataObject.getProductId(), "product_id", ps);
		if(dataObject.getContents() != null)
			set(index++, String.class, dataObject.getContents(), "contents", ps);
		if(dataObject.getGoal() != null)
			set(index++, String.class, dataObject.getGoal(), "goal", ps);
		if(dataObject.getPlatform() != null)
			set(index++, String.class, dataObject.getPlatform(), "platform", ps);
		if(dataObject.getMaterial() != null)
			set(index++, String.class, dataObject.getMaterial(), "material", ps);
		if(dataObject.getImageUuid() != null)
			set(index++, String.class, dataObject.getImageUuid(), "image_uuid", ps);
	}
	
	public void onPrepareFullQuerySelectsql (PreparedStatement ps, CampaignInputDTO dataObject) {
		set(index++, String.class, this._id, ps);
	}
	
	public void onPrepareFullQueryUpdatesql (PreparedStatement ps, CampaignInputDTO dataObject) {
		logger.info("DOF의 update dataObject: " + dataObject.toString());
		
		/*아래 set 순서는 쿼리문과 순서가 일치해야하는것같다. 
		 * set(index++, String.class, this._id, ps)가 맨 앞에 있을땐 update 동작이 실패하고
		 * 맨 뒤에 있을땐 update가 정상동작 한다.
		 * 쿼리문에 들어갈 인자들을 bind하기 위해 parameterValues라는 1차원 배열에 저장을 하기 때문에 
		 * 쿼리문의 인자 순서와 동일하게 맞춰야 하는듯 보인다.
		*/
		if(dataObject.getUserId() != null)
			set(index++, String.class, dataObject.getUserId(), "user_id", ps);
		if(dataObject.getName() != null)
			set(index++, String.class, dataObject.getName(), "name", ps);
		if(dataObject.getType() != null)
			set(index++, String.class, dataObject.getType(), "type", ps);
		if(dataObject.getKeyword() != null)
			set(index++, String.class, dataObject.getKeyword(), "keyword", ps);
		if(dataObject.getLastModified() != null)
			set(index++, String.class, dataObject.getLastModified(), "last_modified", ps);
		if(dataObject.getDateBegin() != null)
			set(index++, String.class, dataObject.getDateBegin(), "date_begin", ps);
		if(dataObject.getDateEnd() != null)
			set(index++, String.class, dataObject.getDateEnd(), "date_end", ps);
		if(dataObject.getProductId() != null)
			set(index++, String.class, dataObject.getProductId(), "product_id", ps);
		if(dataObject.getContents() != null)
			set(index++, String.class, dataObject.getContents(), "contents", ps);
		if(dataObject.getGoal() != null)
			set(index++, String.class, dataObject.getGoal(), "goal", ps);
		if(dataObject.getPlatform() != null)
			set(index++, String.class, dataObject.getPlatform(), "platform", ps);
		if(dataObject.getMaterial() != null)
			set(index++, String.class, dataObject.getMaterial(), "material", ps);
		set(index++, String.class, this._id, ps);
	}
	
	public void onPrepareFullQueryDeletesql (PreparedStatement ps, CampaignInputDTO dataObject) {
		set(index++, String.class, this._id, ps);
	}
	
	static {
		_FACTORY_FIELDS.add(new MetaField("id",String.class,"","","",false,false));
	
		_FACTORY_FIELDS = Collections.unmodifiableList(_FACTORY_FIELDS);
	}
	
	@Override
	public int add(DataObject insert, boolean immediate) {
		logger.info("DOF의 add 호출됨. DTO 정보:");
		logger.info(insert.toString());
		return super.add(insert, immediate);
	}
	
	@Override
	public int add(CampaignInputDTO insert, String... autoIncreasedFields) {
		return super.add(insert, autoIncreasedFields);
	}
	
	@Override
	public int update(DataObject update, boolean immediate) {
		logger.info("DOF의 update immediate 호출됨. DTO 정보:");
		logger.info(update.toString());
		return super.update(update, immediate);
	}
	
	@Override
	public int update(DataObject update, String... autoIncreasedColumns) {
		logger.info("DOF의 update autoIncreasedColumns 호출됨. DTO 정보:");
		logger.info(update.toString());
		return super.update(update, autoIncreasedColumns);
	}
	
	@Override
	public String toString() {
	    return "CampaignDOF [" + super.toString()
	        + ", id=" + _id
	        + "]";
	}
}


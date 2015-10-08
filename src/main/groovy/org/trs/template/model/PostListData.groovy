package org.trs.template.model

import java.util.Map;

import org.trs.cms.pg.util.PresentationFormatter;
import org.trs.ifs.itf.StateExpressionWrapper;

class PostListData extends BaseModel {

	String message=""
	String fetched_record
	def binding = [				PostListActor:this	]
	boolean noData
	
	
	
	

	@Override
	public BaseModel setState(StateExpressionWrapper event) {
		return this;
	}
	
	@Override
	public Map getViewData() {
		return binding;
	}

}

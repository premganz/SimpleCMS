package org.trs.data.domain.model.datamodel

import java.util.Map;

import org.trs.data.domain.model.ifs.BaseModel;
import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;

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

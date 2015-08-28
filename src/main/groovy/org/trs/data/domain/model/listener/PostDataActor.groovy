package org.trs.data.domain.model.listener

import org.trs.data.domain.model.ifs.BaseModel
import org.trs.data.domain.model.labels.Posts
import org.trs.itf.model.StateExpressionWrapper

class PostDataActor extends BaseModel {

	boolean noData
	static Posts data = new Posts()
	
	def binding = [				PostDataActor:this	]

	public BaseModel setState(StateExpressionWrapper event) {
		lastEvent=event.getName()
		if(event=~'setField'){
			data[event.value('fldName')]=event.value('fldValue').replaceAll('-', '/')
		}
		
		else{
		}

		return this;
	}

	@Override
	public Map getViewData() {
		return binding;
	}

	@Override
	public String toString() {
		return "PostDataActor records:"
	}

}

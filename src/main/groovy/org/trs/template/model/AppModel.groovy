package org.trs.template.model

import org.trs.ifs.itf.StateExpressionWrapper;

class AppModel extends BaseModel{

	
	Posts posts
	
	String baseLookupDir;
	BaseModel modelToReturn
	
	
	//Actors
	
	 
	@Override
	public BaseModel setState(StateExpressionWrapper event) {
		// TODO Auto-generated method stub
		return null;
	}

	public AppModel(String exp){
		
			lastEvent=exp
			StateExpressionWrapper defWrap = new StateExpressionWrapper(exp)
		
			posts= new Posts().setState(defWrap);
		
	}
	@Override
	public Map getViewData() {
		//	Properties members = this.getMetaClass().getProperties()
		//	while (this.MetaClass getMetaClass().getPro)
		//	}
		return posts.getViewData()
	}
	
	@Override
	public String toString() {
	
		return "AppModel "+ lastEvent+" binding "+'\n'
	}
}

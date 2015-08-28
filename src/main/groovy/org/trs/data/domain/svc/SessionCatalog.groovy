package org.trs.data.domain.svc


import org.trs.data.domain.model.ifs.AppModel
import org.trs.data.domain.model.labels.Posts

class SessionCatalog  {
	
	static AppModel app = new AppModel("Nightly&");
	
	public static setScenario(String name){
		app= new AppModel();				
		app.posts=new Posts().setState(null);		
		
		
	}
	
	
	
}

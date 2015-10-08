package org.trs.template.svc


import org.trs.template.model.AppModel;
import org.trs.template.model.Posts;

class SessionCatalog  {
	
	static AppModel app = new AppModel("Nightly&");
	
	public static setScenario(String name){
		app= new AppModel();				
		app.posts=new Posts().setState(null);		
		
		
	}
	
	
	
}

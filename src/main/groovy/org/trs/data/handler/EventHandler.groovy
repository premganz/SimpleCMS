package org.trs.data.handler

import groovy.text.SimpleTemplateEngine

import org.trs.data.domain.svc.SessionCatalog
import org.trs.itf.model.StateExpressionWrapper
import org.trs.itf.svc.PageService




class EventHandler {
	
	def propogateEvent(String eventName, String metaExpression){
		String expression =eventName;
		String moduleName = ""
		//timebeing metaExpression is ignored		
		def actorName
		def eventExpression=expression
		//.substring(0,expression.indexOf("?"))
		PageService reader = new PageService();
		if(expression.contains("/")){//TODO should split only based on first index, because event expressions may contian slashes?? anyway to review here.
			String[] arr_pageName=expression.split("/");
			int len = arr_pageName.length;
			eventExpression=arr_pageName[len-1];
			actorName=arr_pageName[len-2];
		}
		else if(expression.contains("\\")){
			String[] arr_pageName=expression.split("\\");
			int len = arr_pageName.length;
			eventExpression=arr_pageName[len-1];
			actorName=arr_pageName[len-2];
		}
		def actor
		char lowerCaseFirt=actorName.charAt(0).toLowerCase()		
		actorName=""+lowerCaseFirt+actorName.substring(1)
		
		actor=SessionCatalog.app[actorName]
		//actor=SessionCatalog.app.getEventListActor()
		//actor = SessionCatalog.app.getModelToReturn()
		actor.setState(new StateExpressionWrapper(eventExpression+""));
	
	}

	
	
}

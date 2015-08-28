package org.trs.data.handler

import groovy.text.SimpleTemplateEngine

import org.trs.data.domain.svc.SessionCatalog
import org.trs.itf.svc.PageReader




class ContentHandler {
	
	def resolvePage(String pageName){
		String expression =pageName;
		String moduleName = ""
		//def pageName
		//def moduleName
		PageReader reader = new PageReader();
		if(expression.contains("/")){
			String[] arr_pageName=expression.split("/");
			int len = arr_pageName.length;
			pageName=arr_pageName[len-1];
			moduleName=arr_pageName[len-2];
		}
		else if(pageName.contains("\\")){
			String[] arr_pageName=pageName.split("\\");
			int len = arr_pageName.length;
			pageName=arr_pageName[len-1];
			moduleName=arr_pageName[len-2];
		}
		String pageText = reader.readUpPage(moduleName, pageName)
		def engine = new SimpleTemplateEngine()
		
		def binding =SessionCatalog.app.getViewData()
		println('currentViewData PageHandler says'+binding.toString()) 
	
		
		def template = engine.createTemplate(pageText).make(binding)
		//def template1 = engine.createTemplate(template).make(binding1)
		if(pageName=='debug'){
			return binding.toString()
		}
		return template
	}

	
	
}

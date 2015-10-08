package org.trs.cms.pg.handler

import groovy.json.JsonBuilder
import groovy.text.SimpleTemplateEngine

import org.trs.cms.pg.fn.M_Home_1
import org.trs.cms.pg.svc.PageService;
import org.trs.template.svc.SessionCatalog;




class ContentHandler {

	def resolvePage(String pageName){
		String expression =pageName;
		String moduleName = ""
		//def pageName
		//def moduleName
		PageService reader = new PageService();
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

	def resolvePage_json(String expression){

		String[] arr_pageName=expression.split("/");
		int len = arr_pageName.length;

		String pageName=arr_pageName[len-3];
		String function=arr_pageName[len-2];
		String param=arr_pageName[len-1];
		def param1
		if(param=='null')
			param1=null
		//pageName=""

		//TODO
		Class clazz = Class.forName("org.trs.cms.pg.fn."+pageName)
		Object page = clazz.newInstance().invokeMethod(function,param1)
		//Object page = new M_Home_1().f01()
		JsonBuilder builder = new JsonBuilder(page)

		return builder.toPrettyString()
	}

	def writePage(String content,String meta){
		PageService reader = new PageService();
		String pageText = reader.writePage(content,meta)
	}

	def fetchPage(String meta){
		PageService reader = new PageService();
		String pageText = reader.readUpPage(null,meta)

	}
}

package org.trs.itf.gen

import groovy.json.JsonBuilder

import org.trs.cms.pg.itf.Tpl_Ovv_1

public class GeneratorJson{

	public static void main(String[] args) {
		Object page =new Tpl_Ovv_1()  
		page=page.function01()
		JsonBuilder builder = new JsonBuilder(page)
		print builder.toPrettyString()
	}

}
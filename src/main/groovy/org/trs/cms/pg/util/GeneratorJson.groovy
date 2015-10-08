package org.trs.cms.pg.util

import groovy.json.JsonBuilder

import org.trs.cms.pg.itf.Tpl_Cont_1

public class GeneratorJson{

	public static void main(String[] args) {
		Object page =new Tpl_Cont_1()
		JsonBuilder builder = new JsonBuilder(page)
		print builder.toPrettyString()
	}

}
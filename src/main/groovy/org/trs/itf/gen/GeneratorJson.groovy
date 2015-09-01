package org.trs.itf.gen

import groovy.json.JsonBuilder;

import org.trs.cms.pg.itf.PG01O;
public class GeneratorJson{

	public static void main(String[] args) {
		Object page =new PG01O()  
		page=page.function01()
		JsonBuilder builder = new JsonBuilder(page)
		print builder.toPrettyString()
	}

}
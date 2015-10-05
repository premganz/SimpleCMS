package org.trs.cms.pg.fn

import org.trs.cms.pg.itf.SECTION_LINK
import org.trs.cms.pg.itf.Tpl_Cont_1
import org.trs.cms.pg.itf.Tpl_Ovv_1
import org.trs.itf.svc.PageService;

class M_Content_1 {

	
	Tpl_Cont_1 f01(String contentId){
		def a = new Tpl_Cont_1()
		
		if(contentId=='C01'){
			a.meta=''
			a.title=''
			PageService reader = new PageService()
			a.content=reader.readUpPage("posts",contentId)
			
		}
		
		
		return a

	}


}



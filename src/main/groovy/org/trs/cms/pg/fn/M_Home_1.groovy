package org.trs.cms.pg.fn

import org.trs.Constants
import org.trs.cms.pg.itf.SECTION_LINK
import org.trs.cms.pg.itf.Tpl_Ovv_1
import org.trs.cms.pg.svc.PageService

class M_Home_1 {

	
	Tpl_Ovv_1 f01(){
		def a = new Tpl_Ovv_1()
		a.page_title='Mergers and Amalgamations'
		a.page_sub_title='Resource bank for the legal angle to the Amalgamations and Mergers in India'
		
		a.MAIN_SECTION =[
			section_id:'Resources',
			section_title:'',
			section_links_att:'',
			link_qtt:3,
			SECTION_LINKS_ZN :[
			SECTION_LINK.newInstance(
				[
					link_title:'Comprehensive Guide to the Amalgamation Procedures in India',
					link_sub_title:'Lists provisions under the Companies Act',
					link_id:'/post?fileName=Test',
					link_date:'September 1, 2015'
				]),
			SECTION_LINK.newInstance(
				[
					link_title:'Amalgamations - the Tax Angle',
					link_sub_title:'Income Tax and Stamp Laws',
					link_id:'home/C02',
					link_date:'September 1, 2015'
				]),
			SECTION_LINK.newInstance(
				[
					link_title:'Why it makes sense to push for your scheme in 2015',
					link_sub_title:'A primer of projected Tax scenario',
					link_id:'home/C03',
					link_date:'September 1, 2015'
				])



			],
			more_pages_link_ic:'1'
		]
		return a

	}

	
	def f02(){
		PageService reader = new PageService();		
		String pageText = reader.readUpPage('templates',"M_Home_01")	
		return pageText	
	}

}



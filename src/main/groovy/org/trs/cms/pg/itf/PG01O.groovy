package org.trs.cms.pg.itf

import java.util.Map;

import org.trs.data.domain.model.ifs.BaseModel;
import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;

class PG01O {

	//Function 00
	String page_title
	String page_sub_title


	//Function 01
	class SECTION_LINK{
		def link_title
		def link_sub_title
		def link_id
		def link_date
		def link_by='Admin'
	}

	def MAIN_SECTION =[
		section_id:'Resources',
		section_title:'',
		section_links_att:'',
		link_qtt:3,
		SECTION_LINKS_ZN :[],
		more_pages_link_ic:'1'
	]

	PG01O function01(){
		def a = new PG01O()
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
					link_id:'C01',
					link_date:'September 1, 2015'
				]),
			SECTION_LINK.newInstance(
				[
					link_title:'Amalgamations from the Tax Angle',
					link_sub_title:'Income Tax and Stamp Laws',
					link_id:'C02',
					link_date:'September 1, 2015'
				]),
			SECTION_LINK.newInstance(
				[
					link_title:'Why it makes sense to push for your scheme in 2015',
					link_sub_title:'A primer of projected Tax scenario',
					link_id:'C03',
					link_date:'September 1, 2015'
				])



			],
			more_pages_link_ic:'1'
		]
		return a

	}


}



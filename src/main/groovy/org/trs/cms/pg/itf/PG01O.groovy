package org.trs.cms.pg.itf

import java.util.Map;

import org.trs.data.domain.model.ifs.BaseModel;
import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;

class PG01O {

	//Function 00
	String PAGE_TITLE='Mergers and Amalgamations'
	String PAGE_SUBTITLE='Resource bank for the legal angle to the Amalgamations and Mergers in India'


	//Function 01

	def main_section =[
		section_id:'Resources',
		section_title:'',
		section_links_att:'',
		link_qtt:3,
		section_links:[
			{
				link_title:'Comprehensive Guide to the Amalgamation Procedures in India'
				link_sub_title:'Lists provisions under the Companies Act'
				link_id:'C01'
			},
			{	link_title:'Amalgamations from the Tax Angle'
				link_sub_title:'Income Tax and Stamp Laws'
				link_id:'C02'
			},
			{	link_title:'Why it makes sense to push for your scheme in 2015'
				link_sub_title:'A primer of projected Tax scenario'
				link_id:'C03'
			}
		],
		more_pages_link_ic:'1'
	]


}



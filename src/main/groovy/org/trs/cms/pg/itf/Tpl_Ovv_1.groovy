package org.trs.cms.pg.itf

import java.util.Map;

import org.trs.data.domain.model.ifs.BaseModel;
import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;
//Function 01

class SECTION_LINK{
	def link_title
	def link_sub_title
	def link_id
	def link_date
	def link_by='Admin'
}

class Tpl_Ovv_1 {
	//Function 00
	String page_title
	String page_sub_title

	def MAIN_SECTION =[
		section_id:'Resources',
		section_title:'',
		section_links_att:'',
		link_qtt:3,
		SECTION_LINKS_ZN :[],
		more_pages_link_ic:'1'
	]

	}



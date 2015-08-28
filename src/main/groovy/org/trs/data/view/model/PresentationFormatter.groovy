package org.trs.data.view.model

class PresentationFormatter {
static def formatList = {java.util.List list -> 
	return PresentationFormatter.formatList_1(list)
}
	
static def dotFormatter1 = {java.util.List list -> 	
	StringBuffer buf = new StringBuffer()
	for (val in list){
		buf.append(val+": ")
	}
	return buf.toString()
	}
	
static def plainStringFormatter = {String input ->
	return input.replaceAll(",","")
	}

static def simpleAppendFormatter = {java.util.List list ->
	StringBuffer buf = new StringBuffer()
	for (val in list){
		buf.append(val)
	}
	return buf.toString()
	}

static def dateFormatter = {int date, int month, int year->
	StringBuffer buf = new StringBuffer()	
	return String.format("%02d", month)+'/'+String.format("%02d",date)+'/'+year	
	}

static String formatList_1(list){
	return list.join('')
	//return list.toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll(",", "")
}




}

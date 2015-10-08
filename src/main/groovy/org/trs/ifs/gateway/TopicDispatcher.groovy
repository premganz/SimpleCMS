package org.trs.ifs.gateway



import org.trs.cms.pg.handler.ContentHandler;
import org.trs.template.handler.EventHandler;
import org.trs.template.svc.SessionCatalog;





class TopicDispatcher {
	static ContentHandler pageHandler = new ContentHandler()
	static EventHandler eventHandler = new EventHandler()
	public static  String handle(String topic, String content, String metaExpression){
		if (topic.equals("scenarioChange")){
			SessionCatalog.setScenario("")
			return ""
		}else if (topic.equals("pages")){
			return pageHandler.resolvePage_json(content)
		}else if (topic.equals("write")){
			return pageHandler.writePage(metaExpression,content)
		}else if (topic.equals("fetch")){
			return pageHandler.fetchPage(metaExpression)
		}else if (topic.equals("event")){
			return eventHandler.propogateEvent(content, metaExpression)
		}else{
		return "";
		}
	}

}




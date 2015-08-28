package org.trs.itf.handler



import org.trs.data.domain.svc.SessionCatalog
import org.trs.data.handler.EventHandler
import org.trs.data.handler.ContentHandler





class TopicDispatcher {
	static ContentHandler pageHandler = new ContentHandler()
	static EventHandler eventHandler = new EventHandler()
	public static  String handle(String topic, String msg, String metaExpression){
		if (topic.equals("scenarioChange")){
			SessionCatalog.setScenario("")
			return ""
		}else if (topic.equals("pages")){
			return pageHandler.resolvePage(msg)
		}else if (topic.equals("event")){
			return eventHandler.propogateEvent(msg, metaExpression)
		}else{
		return "";
		}
	}

}




package org.trs.template.model

import java.util.Map;
import java.util.Observable;

import org.trs.cms.pg.util.PresentationFormatter;
import org.trs.ifs.itf.StateExpressionWrapper;

abstract class BaseModel implements Observer{
String lastEvent
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	public abstract BaseModel setState(StateExpressionWrapper event);
	
		
	public abstract Map getViewData();
	
}

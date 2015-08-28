package org.trs.data.domain.model.ifs

import java.util.Map;
import java.util.Observable;

import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;

abstract class BaseModel implements Observer{
String lastEvent
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	public abstract BaseModel setState(StateExpressionWrapper event);
	
		
	public abstract Map getViewData();
	
}

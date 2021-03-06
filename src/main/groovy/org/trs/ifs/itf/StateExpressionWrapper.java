package org.trs.ifs.itf;


import java.util.ArrayList;
import java.util.List;


public class StateExpressionWrapper {
	public static final String EXP_SEP="&";
	public static final String EXP_EQ="=";
	public static final String EXP_NAME="&";
	String stateExpression;
	String stateExpressionValueOnly;
	public StateExpressionWrapper(String stateExpression) {
		//	String regex = "$([a-z0-9A-Z-:]=[a-z0-9A-Z-:]{0-1}[&]{0-1}){0-10}^";
		String regex = 
				"^([A-Za-z0-9_\\-]{0,40}[\\&]){0,1}" +
						"((([a-zA-Z0-9\\s\\-_#]){1,30}=([\\w\\W\\s~]){1,500}){0,1}&{0,1}(([a-zA-Z0-9\\-_#/s]){1,30}=([\\w\\W\\s~]){0,500})){0,5}";

		if(!stateExpression.matches(regex)){
			throw new IllegalArgumentException();
		}
		this.stateExpression = stateExpression;
		if(stateExpression.contains(":")){
			stateExpressionValueOnly = stateExpression.substring(stateExpression.indexOf(":")+1);
		}else{
			stateExpressionValueOnly = stateExpression;	
		}


	}
	public  boolean  contains( String key){


		String[] expressions = stateExpressionValueOnly.split(EXP_SEP);
		for(String expressionString : expressions){
			if(expressionString.equals(key)){
				return true; 
			}
		}
		return false;
	}

	public  String value(String key){
		String[] expressions = stateExpressionValueOnly.split(EXP_SEP);
		for(String expressionString : expressions){
			if(expressionString.startsWith(key+EXP_EQ)){
				String[] exp_arr = expressionString.split(EXP_EQ);
				if(exp_arr.length<2){
					return "";
				}
				return exp_arr[1].replaceAll("~", "=").replaceAll("%20","").replace("%2F", "/");
			}
		}
		return "";
	}
	public  List<String> values(String key){
		List<String> valLst = new ArrayList<String>();

		String[] expressions = stateExpressionValueOnly.split(EXP_SEP);
		for(String expressionString : expressions){
			if(expressionString.contains(key)){
				String[] exp_arr = expressionString.split(EXP_EQ);
				if(exp_arr.length<2){
					valLst.add("");
					return valLst;
				}else{
					valLst.add(exp_arr[1].replaceAll("~", "=").replaceAll("%20","").replace("%2F", "/"));
				}
			}
		}		
		return valLst;
	}
	public String getName(){
		if(stateExpression.contains(EXP_NAME)){
			return stateExpression.split(EXP_NAME)[0];
		}
		return "";
	}

	@Override
	public String toString() {
		return stateExpression;
	}

}

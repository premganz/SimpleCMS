package org.trs.template.model

import org.trs.cms.pg.util.PresentationFormatter;
import org.trs.ifs.itf.StateExpressionWrapper;

class Posts extends BaseModel {
	def listDots = {

	}
	
	//datastore of various properties
	 def posts=		['post 1','post 2','post 3','post 4','post 5','post 6']
	 def posts_2=	['post 1','post 2','post 3','post 4','post 5','post 6']
	 def posts_AT=	['post 1','post 2','post 3','post 4','post 5','post 6']
	
	//actual exposed data
	 def currentPosts=posts
	 def formatClosure = PresentationFormatter.dotFormatter1
	
	
	//configuration
	def activeposts;
	
	public Posts setState(StateExpressionWrapper event){
		if(event.getName().equals("AT")){
			activeposts=posts_AT
		}else{
			activeposts=posts_2
		}
		return this;
	}
	
		
	public Map getViewData(){
		 def postsBinding= [postNames : posts_2,format: formatClosure	]
	
		return postsBinding;
	}
	
	
	
}

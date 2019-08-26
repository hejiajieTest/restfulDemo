package cn.ffcs.tsp.util;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartJetty {

	private static StartJetty st = new StartJetty();
	
	private static boolean status = false;
	
	private StartJetty(){}
	
	static{
	}
	
	public static StartJetty getInstance(){
		return st ;
	}
	
	public static boolean getStatus(){
		return status ;
	}
	
	public void startJetty(){
		    Server server = new Server(Integer.parseInt(PropertyUtil.getProp().getProperty("server.port")));
	        WebAppContext webapp = new WebAppContext();
	        webapp.setContextPath(PropertyUtil.getProp().getProperty("server.name"));
	        webapp.setResourceBase("D:/sts_data/restfulDemo/src/main/resources/");
	        webapp.setDescriptor(PropertyUtil.getProp().getProperty("server.resource")+"WEB-INF/"+PropertyUtil.getProp().getProperty("server.descriptor"));
	        webapp.setParentLoaderPriority(true);
	        webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
	        server.setHandler(webapp);
	        try {
	            System.out.println("===========================================================");
	            System.out.println("jetty方式启动访问地址：localhost:"+PropertyUtil.getProp().getProperty("server.port")+webapp.getContextPath());
	            System.out.println(webapp.getDescriptor());
	            System.out.println(webapp.getResourceBase());
	            server.start();
	            System.out.println("===========================================================");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}

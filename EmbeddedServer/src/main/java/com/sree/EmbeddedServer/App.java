package com.sree.EmbeddedServer;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException, InterruptedException
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        Context context = tomcat.addContext("/EmbeddedServer", null);
        tomcat.addServlet(context,"HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/helloe", "HelloServlet");
        
        tomcat.start();
        System.out.println("host=="+tomcat.getHost()+", server=="+ tomcat.getServer());
        tomcat.getServer().await();
        //tomcat.getServer().stop();
        
        
    }
}

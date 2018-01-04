package com.accolite.mini_au;
import java.sql.SQLException;



class Singleton {
	String name;
	private static Singleton singleInstance;
	private Singleton()
	{
		name="Singleton class";
	}
	public static Singleton getInstance() 
	  {
	    if(singleInstance == null)
	    {
	    	synchronized(Singleton.class)
	    	{
	    		if(singleInstance == null)
	    		singleInstance=new Singleton();
	    	}
	    }
	    return singleInstance;
	  }
}

public class UsesSingleton extends Thread
{
	String nameAssign;
	static int counter=1;
	static void printObject()
	{
		Singleton s=Singleton.getInstance();
		System.out.println(s.name);
	}
	public static void main(String args[])
	{
		UsesSingleton u=new UsesSingleton();
		u.printObject();

		for(int i=0;i<10;i++)
		{
			Thread t=new Thread(u);
			t.start();
		}
	}
	public void run()
	{
		Singleton s=Singleton.getInstance();
		System.out.println(s.name);
		counter++;
		s.name+=counter;
		
	}
}

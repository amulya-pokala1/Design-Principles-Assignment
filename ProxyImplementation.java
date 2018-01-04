package com.accolite.mini_au;

interface Access
{
	void getAccess();
}
class AccessImplement implements Access
{
	public void getAccess()
	{
		System.out.println("access granted");
	}
}
class AccessImplementProxy
{
	boolean isAdmin;
	private AccessImplement accessObj;
	AccessImplementProxy(boolean value)
	{
		accessObj=new AccessImplement();
		isAdmin=value;
	}
	void run()
	{
		if(isAdmin)
		{
			accessObj.getAccess();
		}
		else
		{
			System.out.println("access denied");
		}
	}
}
public class ProxyImplementation {
	public static void main(String args[])
	{
		AccessImplementProxy obj=new AccessImplementProxy(true);
		obj.run();
		AccessImplementProxy obj1=new AccessImplementProxy(false);
		obj1.run();
	}
}

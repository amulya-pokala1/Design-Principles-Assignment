package com.accolite.mini_au;

import java.util.Scanner;

class Coffee {
	String type;
	Coffee()
	{
		type="";
	}
	Coffee(String type)
	{
		this.type=type;
	}
	void display()
	{
		System.out.println("cofee type: "+type);
	}

}
class MochaCoffee extends Coffee
{
	MochaCoffee()
	{
		super("mocha");
	}
}
class LateCoffee extends Coffee
{
	LateCoffee()
	{
		super("late");
	}
}
class ExpressoCoffee extends Coffee
{
	ExpressoCoffee()
	{
		super("expresso");
	}
}

public class CoffeeFactory
{
	static Coffee createCoffee(String type)
	{
		if(type.equals("mocha"))
			return new MochaCoffee();
		else if(type.equals("expresso"))
			return new ExpressoCoffee();
		else if(type.equals("Late"))
			return new LateCoffee();
		return new Coffee();
	}
	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		String type=s.next();
		Coffee coffee=createCoffee(type);
		coffee.display();
	}
}

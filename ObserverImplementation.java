package com.accolite.mini_au;

import java.util.ArrayList;

interface Subscribe
{
	void update();
}
class Model
{
	String movie;
	int score;
	ArrayList<GetSubscription> subscribers=new ArrayList<GetSubscription>();
	void addSubscriber(GetSubscription subscriber)
	{
		subscribers.add(subscriber);
	}
}
class ScoreModel extends Model implements Subscribe
{
	
	int score;
	void setScore(int score)
	{
		this.score=score;
		update();
	}
	public void update()
	{
		for(GetSubscription subscriber: subscribers)
		{
			subscriber.getUpdate(score);
		}
		
	}
	void display()
	{
		for(GetSubscription subscriber: subscribers)
			System.out.println(subscriber.score);
	}
}
class MovieModel extends Model implements Subscribe
{
	
	void setMovie(String movie)
	{
		this.movie=movie;
		update();
	}
	public void update()
	{
		for(GetSubscription subscriber: subscribers)
		{
			subscriber.getUpdate(movie);
		}
		
	}
	void display()
	{
		for(GetSubscription subscriber: subscribers)
			System.out.println(subscriber.movie);
	}
}

class GetSubscription extends Model
{
	void getUpdate(int score)
	{
		this.score=score;
	}
	void getUpdate(String movie)
	{
		this.movie=movie;
	}
	void subscribe(Model m)
	{
		m.addSubscriber(this);
	}
}

public class ObserverImplementation {
	public static void main(String args[])
	{
		ScoreModel score=new ScoreModel();
		GetSubscription gs1=new GetSubscription();
		GetSubscription gs2=new GetSubscription();
		GetSubscription gs3=new GetSubscription();
		gs1.subscribe(score);
		gs2.subscribe(score);
		gs3.subscribe(score);
		score.setScore(100);
		MovieModel movie=new MovieModel();
		gs1.subscribe(movie);
		gs2.subscribe(movie);
		movie.setMovie("Padmavathi");
		score.display();
		movie.display();
	}
	
}


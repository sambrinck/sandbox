package org.home.brinck;

import java.lang.Thread.State;

import org.home.brinck.Menu.Meal.Builder;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		
		System.out.println("   ***   Foo   ***   ");

		Foo foo = new Foo(State.BLOCKED);
		System.out.println(foo.getState());
		System.out.println(foo.getName());
		
		Bar bar = new Bar(State.BLOCKED);
		System.out.println(bar.getState());
		System.out.println(bar.getName());
		
		Builder mealBuilder = Menu.Meal.newBuilder();
		mealBuilder.setName("This is a name");
	}

}

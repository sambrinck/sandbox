package org.home.brinck;

import java.lang.Thread.State;
import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

import org.home.brinck.Foo;
import org.home.brinck.Menu.Meal;
import org.home.brinck.Menu.Meal.Builder;
import org.home.brinck.Bar;

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
		new GregorianCalendar();
		
		long brithdate = 
				ChronoUnit.YEARS.between(LocalDate.of(1985, 7, 27), 
						                 LocalDate.now());
		
	}

}

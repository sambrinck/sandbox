import org.home.brinck.Foo
import org.home.brinck.Bar
import org.home.brinck.Menu
import org.home.brinck.Menu.Meal

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


fun main(args: Array<String>) {
	println("Hello, World!")

	println("  ***   Foo   ***   ")

	val foo = Foo(Thread.State.BLOCKED)
	println(foo.state)
	println("state set: " + foo.isSet)
	foo.setState();
	println("state set: " + foo.isSet)
	println(foo.state)
	foo.state = Thread.State.TERMINATED
	println(foo.state)

	println("  ***   Bar   ***   ")

	val bar = Bar(Thread.State.BLOCKED)
	println(bar.state)
	println("state set: " + bar.isSet)
	bar.setState();
	println("state set: " + bar.isSet)
	println(bar.state)
	bar.state = Thread.State.TERMINATED
	println(bar.state)


	val meal = Meal.newBuilder()
	meal.name = "This is a name"
	meal.numIngredients = 10
	println(meal.build())
	println(meal.build())
	
	var sam = Person(name="Sam Brinck",
					 shoeSize=14)
	
	val birthdate = LocalDate.of(1985, 7, 27)
	sam.age = ChronoUnit.YEARS.between(birthdate,
						               LocalDate.now())
	val days = ChronoUnit.DAYS.between(birthdate,
						               LocalDate.now())
	val months = ChronoUnit.MONTHS.between(birthdate,
						               LocalDate.now())
	
	println("${sam.name} is ${sam.age} years, ${days} days, $months old")
	
}

class Person (val name : String = "Person Name",
			  var age : Long = 18,
			  var shoeSize : Int = 7)
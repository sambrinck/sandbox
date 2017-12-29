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
	
	
	var list = mutableListOf(	
		Person(name="Sam Brinck",
	           birthdate=LocalDate.of(1985,7,27),
	           shoeSize=14),
		Person(name="Selina Brinck",
	           birthdate=LocalDate.of(1985,1,24),
	           shoeSize=14)
			)
	
	for (person in list) {
		
	println("${person.name} is " +
			"${person.age} years, " +
			"${person.ageMonths} months old " +
			"${person.ageDays} days, " +
			"")
	}
	
}

class Person (val name : String = "Person Name",
			  var birthdate : LocalDate,
			  var shoeSize : Int = 7) {
	val age       get() = ChronoUnit.YEARS.between(birthdate, LocalDate.now())
	val ageMonths get() = ChronoUnit.MONTHS.between(birthdate, LocalDate.now()) % 12
	val ageDays   get() = ChronoUnit.DAYS.between(birthdate, LocalDate.now()) % 365
}
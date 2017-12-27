import org.home.brinck.Foo
import org.home.brinck.Bar
import org.home.brinck.Menu
import org.home.brinck.Menu.Meal

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
	println(meal)
}

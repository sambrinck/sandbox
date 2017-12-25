import org.home.brinck.Foo
import org.home.brinck.Bar

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
}

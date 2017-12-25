import org.home.brinck.Foo
import org.home.brinck.Bar

fun main(args: Array<String>) {
    println("Hello, World!")
	
	println("  ***   Foo   ***   ")

		val foo = Foo(Thread.State.BLOCKED)
	println(foo.state)
	foo.setState();
	println(foo.state)
	foo.state = Thread.State.TERMINATED
	println(foo.state)

	println("  ***   Bar   ***   ")

	val bar = Bar(Thread.State.BLOCKED)
	println(bar.state)
	bar.setState();
	println(bar.state)
	bar.state = Thread.State.TERMINATED
	println(bar.state)
}

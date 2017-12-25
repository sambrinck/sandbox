package org.home.brinck

class Foo (state : Thread.State){
	var state = state
	/**
	 *	Getter
	 */
		get () {
			println("Getting: " + field)
			return field
		}
		set(value) {
			println("Setting " + field + " to " + value)
			field = value
		}
	
	val isSet
		get() = state == Thread.State.RUNNABLE

	val name : String = "Foo"
	
	
	/**
	 *  Example of a function
	 **/
	fun setState() {
		this.state = Thread.State.RUNNABLE
	}
}
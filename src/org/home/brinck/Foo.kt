package org.home.brinck

class Foo (state : Thread.State){
	var state = state
		set(value) {
			println("Setting " + field + " to " + value)
			field = value
		}
		get () {
			println("Getting: " + field)
			return field
		}

	/**
	 *  Example of a function
	 **/
	fun setState() {
		this.state = Thread.State.RUNNABLE
	}
}
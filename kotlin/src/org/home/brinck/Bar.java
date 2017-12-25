package org.home.brinck;

import java.lang.Thread.State;

public class Bar {
	private Thread.State state = Thread.State.BLOCKED;
	private String name = new String ("Bar");
	
	public Bar (Thread.State state) {
		this.setState(state);
	}

	public Thread.State getState() {
		System.out.println("Getting: " + state);
		return state;
	}

	public void setState(Thread.State state) {
		System.out.println("Setting " + this.state + " to " + state);
		this.state = state;
	}
	
	public void setState() {
		setState(Thread.State.RUNNABLE);
	}
	
	public boolean isSet() {
		return state == State.RUNNABLE;
	}

	public String getName() {
		return name;
	}
}

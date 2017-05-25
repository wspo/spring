package com.wspo.springJDBC.common;

public class Person {
	private Ability ability;

	public Person(Ability ability) {
		super();
		this.ability = ability;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}
}

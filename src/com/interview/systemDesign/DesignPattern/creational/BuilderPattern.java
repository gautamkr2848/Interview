package com.interview.systemDesign.DesignPattern.creational;

// The Builder Pattern is a creational design pattern that lets you construct complex objects step by step, especially
// when an object has many optional parameters or when you want to avoid constructor overloading.

// First of all you need to create a static nested class and then copy all the arguments from the outer class to the
// Builder class. We should follow the naming convention and if the class name is Computer then builder class should be
// named as ComputerBuilder.

// Java Builder class should have a public constructor with all the required attributes as parameters.

// Java Builder class should have methods to set the optional parameters and it should return the same Builder object
// after setting the optional attribute.

// The final step is to provide a build() method in the builder class that will return the Object needed by client
// program. For this we need to have a private constructor in the Class with Builder class as argument.

class User {
	private final String name;
	private final int age;

	// Private constructor: only Builder can access it
    User(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}

	// Static nested Builder class
	public static class Builder {
		private String name;
		private int age;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	// Just for display
	@Override
	public String toString() {
		return "User{name='" + name + "', age=" + age + "'}";
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		User user = new User.Builder()
				.setName("Alice")
				.setAge(30)
				.build();

		System.out.println(user);
	}
}

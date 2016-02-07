package imperative.to.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.List;

/**
 * Non Intrusive comparisons
 * - Comparable vs Comparator
 * - Composition of Comparators
 *
 */
public class Example5 {

	public static void main(String[] args) {
		/*
		 * imperative style
		 */
		List<Person> people = Arrays.asList(
				new Person("Sara", 12),
				new Person("Mark", 43),
				new Person("Bob", 12),
				new Person("Jill", 64)
				);
		//sort mutates the input parameter people, evil
		//sort requires Person to implement Comparable, its intrusive
		Collections.sort(people); 
		System.out.println(people);
		
		/*
		 * functional style
		 */
		// ***********************************************************************
		// its no more intrusive, does nor requires Person to implement Comparable
		// it does not modify the collection people
		// ***********************************************************************

		// ***********************************************************************
		// *** version - 1 ***//
		// ***********************************************************************
//		Comparator<Person> comparator = new Comparator<Person>() {
//			@Override
//			public int compare(Person p1, Person p2) {
//				return p1.getName().compareTo(p2.getName());
//			}
//		};
		
		// ***********************************************************************
		//*** version - 2 ***//
		// ***********************************************************************
		// Comparator is functional interface
//		Comparator<Person> comparator = 
//				(p1, p2) -> p1.getName().compareTo(p2.getName());
		
		// ***********************************************************************
		//*** version - 3 ***//
		// ***********************************************************************
		//comparing is a static factory method in Comparator interface which returns Comparator
		//thenComparing is a default method in Comparator interface
		printSorted(people, comparing(Person::getName)); // compare by name
		printSorted(people, comparing(Person::getAge)); // compare by age
		printSorted(people, comparing(Person::getAge).thenComparing(Person::getName));
	}

	public static void printSorted(List<Person> people, Comparator<Person> comparator) {
		people.stream()
		.sorted(comparator)
		.forEach(System.out::println);
	}
	
	static class Person implements Comparable<Person> { //
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		String name;
		int age;
		
		@Override
		public int compareTo(Person other) {
			return ((Integer)(age)).compareTo(other.age);
		}
		
		public String toString() {
			return String.format("[%s, %d]", name, age);
		}
	}
}

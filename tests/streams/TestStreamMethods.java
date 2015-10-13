package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import junit.framework.TestCase;

import org.junit.Assert;

public class TestStreamMethods extends TestCase {

	/*
	 * filters from collection and then and then collects
	 */
	public void testFilterCollect() {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);

		List<Integer> l2 = l.stream()
				.filter(x -> x.intValue() == 1 || x.intValue() == 6)
				.collect(Collectors.toList());

		Assert.assertEquals(2, l2.size());
		Assert.assertEquals(true, l2.contains(1));
		Assert.assertEquals(true, l2.contains(6));
	}

	/*
	 * applies to each element in collection, mutates collection
	 */
	public void testForEach() {
		List<Integer> l = new CopyOnWriteArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);

		l.forEach(x -> {
			l.add(x * 10);
			l.remove(x);
		});

		Assert.assertEquals(6, l.size());
		Assert.assertEquals(true, l.contains(10));
		Assert.assertEquals(true, l.contains(20));
		Assert.assertEquals(true, l.contains(30));
		Assert.assertEquals(true, l.contains(40));
		Assert.assertEquals(true, l.contains(50));
		Assert.assertEquals(true, l.contains(60));
	}

	/*
	 * filters and then reduces using a aggregate function
	 */
	public void testFilterMapReduceUsingAggregateFunction() {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);

		int sum = l.stream()
		.filter(x -> x.intValue() == 1 || x.intValue() == 6)
		.mapToInt(x -> x.intValue())
		.sum(); //reduce using one of the aggregate function
		
		Assert.assertEquals(7, sum);
	}

	/*
	 * filters and then reduces without using aggregate function, uses reduce with lambda instead
	 */
	public void testFilterMapReduceWithoutUsingAggregateFunction() {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);

		int sum = l.stream()
		.filter(x -> x.intValue() == 1 || x.intValue() == 6)
		.reduce(0, (a, b) -> a + b); //reduce without using aggregate function
		
		Assert.assertEquals(7, sum);
	}

	/******************************************************************************
	 * Collector examples below
	 ******************************************************************************/
	/*
	 * uses collect and a Collectors helper function to collect all males
	 */
	public void testCollectsListOfAllMales() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		List<Person> listOfMales= l.stream()
		.filter(p -> p.getGender().equals(Person.MALE)) //filter by MALE
		.collect(Collectors.toList()); //then collect as list
		
		Assert.assertEquals(5, listOfMales.size());
	}

	/*
	 * uses Collectors helper function to group by gender
	 */
	public void testCollectorsToGroupByGender() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		//collects Person objects by gender
		Map<String, List<Person>> personsByGender = 
				l.stream()
				.collect(
						Collectors.groupingBy(Person::getGender)); //groupingBy helper
		
		Assert.assertEquals(5, personsByGender.get(Person.MALE).size());
		Assert.assertEquals(4, personsByGender.get(Person.FEMALE).size());
	}

	/*
	 * uses Collectors helper function to group by gender but only names
	 */
	public void testCollectorsToGroupByGenderOnlyNames() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		//collects names by gender
		Map<String, List<Object>> namesByGender = 
				l.stream()
				.collect(
						Collectors.groupingBy(
								Person::getGender,
								Collectors.mapping(
										Person::getName, 
										Collectors.toList())));
		
		Assert.assertEquals(5, namesByGender.get(Person.MALE).size());
		Assert.assertEquals(4, namesByGender.get(Person.FEMALE).size());
	}

	/*
	 * uses Collectors helper function to group by  and then uses 
	 * helper function reduce to find sum
	 */
	public void testCollectorsToGroupByGenderAndSum() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		Map<String, Integer> sumByGender = 
				l.stream()
				.collect(
						Collectors.groupingBy(
								Person::getGender,
								Collectors.reducing(
										0, 
										Person::getAge,
										Integer::sum)));
		
		Assert.assertEquals(76, sumByGender.get(Person.MALE).intValue());
		Assert.assertEquals(51, sumByGender.get(Person.FEMALE).intValue());
	}

	/*
	 * uses Collectors helper function to group by and then uses 
	 * helper function averaging to find average
	 */
	public void testCollectorsToGroupByGenderAndAverage() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		Map<String, Double> averageAgeByGender = 
				l.stream()
				.collect(
						Collectors.groupingBy(
								Person::getGender,
								Collectors.averagingDouble(Person::getAge)));
		
		Assert.assertEquals(15.2, averageAgeByGender.get(Person.MALE).doubleValue(), 0.0);
		Assert.assertEquals(12.75, averageAgeByGender.get(Person.FEMALE).doubleValue(), 0.0);
	}

	/*
	 * filters only males from list
	 * and then gets average age of males using collect
	 */
	public void testCollectToFindAvegareAgeOfMales() {
		List<Person> l = new ArrayList<>();
		l.add(new Person("m1", Person.MALE, 12));
		l.add(new Person("f1", Person.FEMALE, 14));
		l.add(new Person("m2", Person.MALE, 18));
		l.add(new Person("f2", Person.FEMALE, 9));
		l.add(new Person("m3", Person.MALE, 14));
		l.add(new Person("f3", Person.FEMALE, 18));
		l.add(new Person("m4", Person.MALE, 10));
		l.add(new Person("f4", Person.FEMALE, 10));
		l.add(new Person("m5", Person.MALE, 22));

		Averager averager = l.stream()
		.filter(p -> p.getGender().equals(Person.MALE))
		.map(Person::getAge)
		.collect(Averager::new, Averager::accept, Averager::combine);
		
		Assert.assertEquals(15.2, averager.average(), 0.00);
	}


	public static class Person {
		public Person(String name, String gender, int age) {
			super();
			this.gender = gender;
			this.age = age;
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public int getAge() {
			return age;
		}
		public String getName() {
			return name;
		}
		public static String MALE = "male";
		public static String FEMALE = "female";
		
		private final String gender;
		private final int age;
		private final String name;
	}

	public static class Averager implements IntConsumer
	{
	    private int total = 0;
	    private int count = 0;
	        
	    public double average() {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public void accept(int i) { total += i; count++; }
	    public void combine(Averager other) {
	        total += other.total;
	        count += other.count;
	    }
	}
}

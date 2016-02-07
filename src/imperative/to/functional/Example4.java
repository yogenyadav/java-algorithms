package imperative.to.functional;

import java.io.File;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * You gotta be kidding
 * - simple tasks that haunt us
 * - higher level abstractions
 * 
 */
public class Example4 {

	public static void main(String[] args) {
		/*
		 * imperative style
		 */
		File dir = new File(".");
		File[] c = dir.listFiles();
		if(c != null) {
			//print names of each file in upper case and comma separated
			for(File child : c) {
				//prints annoying comma in the end
				//removing comma in the end requires complex unwanted code
				//you gotta be kidding
				//we can do better using fuctional style
				System.out.print(child.getName().toUpperCase() + ", "); 
			}
		}
		System.out.println("");
		/*
		 * functional style
		 */
		if(c != null) {
			String str = 
			Stream.of(c)
			.map(File::getName)
			.map(String::toUpperCase)
			.collect(joining(", ")); //collect joining with comma
			System.out.println(str); //no annoying comma in the end
		}
	}

}

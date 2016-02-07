package imperative.to.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Tell, don't ask principal
 * - keep focus on whole instead of the part
 * - code is transparent
 * - avoid the smell of null
 * - Optional 
 */
public class Example3 {

	public static void main(String[] args) {
		/*
		 * imperative style
		 */
		List<TimeSlot> timeSlots = Arrays.asList(new TimeSlot(),
				new TimeSlot(), new TimeSlot(), new TimeSlot(), new TimeSlot(),
				new TimeSlot());
		TimeSlot firstAvailableTimeSlot = null;
		for (TimeSlot t : timeSlots) {
			if (t.isAvailable()) {
				t.schedule();
				firstAvailableTimeSlot = t;
				break;
			}
		}
		// if no time slots are available then firstAvailableTimeSlot will be null
		// and we could encounter null pointer exception, this will be know only at
		// runtime, it will be nice if this can be a compile time error
		System.out.println("time slot is: " + firstAvailableTimeSlot);
		
		/*
		 * functional style
		 */
		Optional<TimeSlot> firstAvailableTimeSlot2 = 
		timeSlots.stream()
		.filter(TimeSlot::isAvailable)
		.findFirst(); //return an Optional, so no null at runtime
		
		if(firstAvailableTimeSlot2.isPresent()) {
			System.out.println("time slot is: " + firstAvailableTimeSlot2.get());
		}

		TimeSlot firstAvailableTimeSlot3 = 
		timeSlots.stream()
		.filter(TimeSlot::isAvailable)
		.findFirst()
		.orElse(new TimeSlot());
		
		System.out.println("time slot is: " + firstAvailableTimeSlot3);
	}

	static class TimeSlot {
		static Random r = new Random();
		
		public void schedule() {
			
		}
		public boolean isAvailable() {
			return r.nextBoolean();
		}
	}
}

package algo.arraybased;

/**
 * Given a list of meeting times, checks if any of them overlaps. The follow-up question is to return
 * the minimum number of rooms required to accommodate all the meetings.
 *
 * Meeting intervals: (1, 4), (5, 6), (8, 9), (2, 6)
 *
 * 1. Sort start times and make a start array
 * 2. Sort end times and make a end array
 * 3. Loop over the arrays
 * If curr end time <= next start time
 *    then one room is needed.
 * If curr end time < next start time
 *    then two room is needed.
 * Keep a counter and increment it each time overlap is found.
 *
 */
public class MeetingRoomSchedulingProblem {
}

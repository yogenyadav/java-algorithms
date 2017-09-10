package algo.nocategory;

/**
 * Question:
 * Design a notification system. System provides APIs to register with events at a time in future, system should
 * notify when time of event arrives.
 *
 * Design:
 * Just a in memory, single java process, simple system is required.
 * APIs:
 * eventId subscribe(eventDesc, time, Callback, clientId)
 *   register an event, it will be notified at 'time' via Callback provided by client.
 *   make sure API is idempotent, if it already exists then just return same eventId, using clientId (this can be client's timestamp).
 * void cancel(eventId)
 *   ability to cancel an event.
 *
 * This was asked at homeaway interview, I made some important mistakes, although identified and corrected when pointed
 * out. In such questions pay attention to the following:
 * 1. This requires multi threaded implementation and may use 2 data structures, Map and PriorityQueue,
 * 1.1 Make sure updates to data structures is synchronized.
 * 1.2 Address dead locking is avoided (lock in same order).
 * 1.3 Make sure concurrent modification exception is avoided.
 *
 * 2. The notification thread
 * 2.1 Make sure it waits for optimal amount of time so that there is no slack in notifications.
 * 2.2 Make sure if an event is when thread went to sleep and it expires while its waiting, thread is interrupted.
 * 2.3 This thread notifies client via Callback whose implementation is provided by client, so take care of following:
 * 2.3.1 Callback using a separate thread pool, to avoid client code crashing this thread
 * 2.3.2 Provide a timeout for Callback threads to gracefully terminate client thread if it takes too long.
 * 2.3.3 Handle exception in Callback thread gracefully.
 *
 */
public class NotificationSystem {
}

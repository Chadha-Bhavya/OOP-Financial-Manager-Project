package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Represents a log of Financial Management events.
public class EventLog implements Iterable<Event> {

    // the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    // EFFECTS: Prevent external construction.
    private EventLog() {
        events = new ArrayList<Event>();
    }

    /// EFFECTS: Gets instance of EventLog - creates it
    // if it doesn't already exist.
    // (Singleton Design Pattern)
    // @return  instance of EventLog
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // EFFECTS: Adds an event to the event log.
    // @param e the event to be added

    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: Clears the event log and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}

package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> _timeEntryMap = new HashMap<>();
    private long idx = 1;


    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry newTimeEntry = new TimeEntry(idx++, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        _timeEntryMap.put(newTimeEntry.getId(), newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(Long id) {
        return _timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(_timeEntryMap.values());

    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        _timeEntryMap.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public void delete(Long id) {
        _timeEntryMap.remove(id);

    }
}

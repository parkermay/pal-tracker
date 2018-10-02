package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TimeEntryController {

    private TimeEntryRepository _timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        _timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntry) {
        TimeEntry newTimeEntry = _timeEntryRepository.create(timeEntry);
        ResponseEntity<TimeEntry> responseEntity = new ResponseEntity<TimeEntry>(newTimeEntry, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        TimeEntry newTimeEntry =  _timeEntryRepository.find(id);
        ResponseEntity<TimeEntry> responseEntity = null;
        if (newTimeEntry != null) {
            responseEntity = new ResponseEntity<TimeEntry>(newTimeEntry, HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

//    @PostMapping("")
    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry newTimeEntry = _timeEntryRepository.update(id, timeEntry);
        ResponseEntity<TimeEntry> responseEntity = null;
        if (newTimeEntry != null) {
            responseEntity = new ResponseEntity<>(newTimeEntry, HttpStatus.OK);
        }
        else{
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> newList= _timeEntryRepository.list();
        ResponseEntity<List<TimeEntry>> responseEntity = new ResponseEntity<List<TimeEntry>>(newList, HttpStatus.OK);
        return responseEntity;
    }

  @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        _timeEntryRepository.delete(id);

       return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);

    }
}

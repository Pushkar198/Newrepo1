package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{
    private Map<Long , JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll()
    {
      return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryById(@PathVariable Long myID)
    {
        return journalEntries.get(myID);
    }
    @DeleteMapping("id/{myID}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myID)
    {
        return journalEntries.remove(myID);
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry)
    {
        return journalEntries.put(id, myEntry);
    }


}

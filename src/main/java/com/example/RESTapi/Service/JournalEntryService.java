package com.example.RESTapi.Service;

import com.example.RESTapi.Entity.JournalEntry;
import com.example.RESTapi.Entity.User;
import com.example.RESTapi.Repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;



    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userService.findByuserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        }catch (Exception e) {
            throw  new RuntimeException("Something happend during the saving processs of the entry!",e);
        }
        }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getall(){
        return journalEntryRepo.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            User user = userService.findByuserName(userName);
             removed =  user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if (removed){
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        }
        catch (Exception e){
            throw new RuntimeException("An error occur :" + e);
        }
        return removed;

    }
}

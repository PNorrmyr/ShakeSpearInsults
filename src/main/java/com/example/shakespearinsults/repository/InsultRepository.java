package com.example.shakespearinsults.repository;

import com.example.shakespearinsults.model.Insult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InsultRepository {

    private List<Insult> insults = new ArrayList<>();

    public List<Insult> getAll() {
        return insults;
    }

    public void create(Insult insult){
        insults.add(insult);
    }

    public Insult getInsultById(int id) {
        return insults.get(id);
    }

    public void delete(int id) {
        insults.remove(id);
    }

    public Insult update(int id, Insult insult){
        return insults.set(id, insult);
    }


}

package com.example.shakespearinsults.service;

import com.example.shakespearinsults.model.Insult;
import com.example.shakespearinsults.repository.InsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsultService {

    @Autowired
    private InsultRepository insultRepository;

    public void create(Insult insult) {
        insultRepository.create(insult);
    }

    public List<Insult> getAll(){
        return insultRepository.getAll();
    }

    public Insult getInsultById(int id) {
        return insultRepository.getInsultById(id);
    }

    public void delete(int id){
        insultRepository.delete(id);
    }

    public Insult update(int id, Insult insult) {
        return insultRepository.update(id, insult);
    }
}

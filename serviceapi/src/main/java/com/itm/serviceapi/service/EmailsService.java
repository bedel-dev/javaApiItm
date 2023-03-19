package com.itm.serviceapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.serviceapi.model.Emails;
import com.itm.serviceapi.repository.EmailsRepository;
import com.itm.serviceapi.repository.UsersRepository;

import lombok.Data;

@Data
@Service
public class EmailsService {
    @Autowired
private EmailsRepository repository;

    public Optional<Emails> getOneData(final Long id) {
        return repository.findById(id);
    }

    public Iterable<Emails> getallData() {
        return repository.findAll();
    }

    public void deleteData(final Long id) {
    	repository.deleteById(id);
    }

    public Emails saveData(Emails data) {
    	Emails savedData = repository.save(data);
        return savedData;
    }
    public Emails updateData(Emails data) {
    	Emails updatedData = repository.save(data);
        return updatedData;
    }
}

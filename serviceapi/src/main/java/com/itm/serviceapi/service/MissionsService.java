package com.itm.serviceapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.serviceapi.model.Missions;
import com.itm.serviceapi.model.Users;
import com.itm.serviceapi.repository.MissionsRepository;
import com.itm.serviceapi.repository.UsersRepository;

import lombok.Data;

@Data
@Service
public class MissionsService {

    @Autowired
    private MissionsRepository repository;

    public Optional<Missions> getOneData(final Long id) {
        return repository.findById(id);
    }

    public Iterable<Missions> getallData() {
        return repository.findAll();
    }

    public void deleteData(final Long id) {
    	repository.deleteById(id);
    }

    public Missions saveData(Missions data) {
    	Missions savedData = repository.save(data);
        return savedData;
    }
}

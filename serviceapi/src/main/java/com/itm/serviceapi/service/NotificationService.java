package com.itm.serviceapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.serviceapi.model.Notifications;
import com.itm.serviceapi.repository.NotificationsRepository;
import com.itm.serviceapi.repository.UsersRepository;

import lombok.Data;

@Data
@Service
public class NotificationService {
    @Autowired
    private NotificationsRepository repository;

    public Optional<Notifications> getOneData(final Long id) {
        return repository.findById(id);
    }

    public Iterable<Notifications> getallData() {
        return repository.findAll();
    }

    public void deleteData(final Long id) {
    	repository.deleteById(id);
    }

    public Notifications saveData(Notifications data) {
    	Notifications savedData = repository.save(data);
        return savedData;
    }
    public Notifications updateData(Notifications data) {
    	Notifications updatedData = repository.save(data);
        return updatedData;
    }
}

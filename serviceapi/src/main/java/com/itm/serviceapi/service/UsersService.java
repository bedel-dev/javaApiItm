package com.itm.serviceapi.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.serviceapi.model.Users;
import com.itm.serviceapi.repository.UsersRepository;

import lombok.Data;

@Data
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> getOneData(final Long id) {
        return usersRepository.findById(id);
    }

    public Iterable<Users> getallData() {
        return usersRepository.findAll();
    }

    public void deleteData(final Long id) {
    	usersRepository.deleteById(id);
    }

    public Users saveData(Users data) {
    	Users savedData = usersRepository.save(data);
        return savedData;
    }
    
    public  Boolean liginuser(Users data) {
    	Boolean rep;
    	if(usersRepository.existsByUsername(data.getUsername())&& usersRepository.existsByPass(data.getPass())){
    		rep = true;
    	}else {
    		rep = false;
    	}
    	return rep;
    }
}

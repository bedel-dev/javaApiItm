package com.itm.serviceapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itm.serviceapi.model.Notifications;
import com.itm.serviceapi.service.NotificationService;

@RestController
public class NotificationsController {
    @Autowired
    private NotificationService service;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("notification/getAll")
    public   ResponseEntity<Object>  getAlldata() {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Iterable<Notifications> data = service.getallData();
        	map.clear();
            map.put("request date", new Date());
            map.put("code_status", 200);
            map.put("data", data);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        } catch (Exception e) {
            map.clear();
            map.put("request date", new Date());
            map.put("code_status", 400);
            map.put("data", null);
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("notification/add")
    public ResponseEntity<Object>add(@RequestBody Notifications datas) {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Notifications data = service.saveData(datas);
        	if(data!= null) {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 200);
                map.put("mission", "is created");	
        	}else {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 400);
                map.put("mission", "is not created");
        	}

            return new ResponseEntity<Object>(map,HttpStatus.OK);
        } catch (Exception e) {
            map.clear();
        	if(e.getClass().getName().contains("DataIntegrityViolationException")) {
                map.put("exeption", "user allready existe");
        	}else {
        		map.put("exeption", e.getClass().getName());
        	}
            map.put("request date", new Date());
            map.put("code_status", 400);
            map.put("user", null);
            
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("notification/update/{id}")
    public ResponseEntity<Object>updateData(@RequestBody Notifications datas,@PathVariable Long id) {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Optional<Notifications> dataid = service.getOneData(id);
        	
        	if(dataid.isEmpty()){
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 400);
                map.put("mission", "enregistrement not found");
                return new ResponseEntity<Object>(map,HttpStatus.OK);
        	}else {
        		
        		dataid.get().setIduser(datas.getIduser());
        		dataid.get().setState(datas.getState());
        		Notifications data = service.saveData(dataid.get());
            	if(data!= null) {	
                	map.clear();
                    map.put("request date", new Date());
                    map.put("code_status", 200);
                    map.put("mission", "is updated");	
            	}else {
                	map.clear();
                    map.put("request date", new Date());
                    map.put("code_status", 400);
                    map.put("mission", "is not updated");
            	}
                return new ResponseEntity<Object>(map,HttpStatus.OK);
        	}
        } catch (Exception e) {
            map.clear();
        	if(e.getClass().getName().contains("DataIntegrityViolationException")) {
                map.put("exeption", "user allready existe");
        	}else {
        		map.put("exeption", e.getClass().getName());
        	}
            map.put("request date", new Date());
            map.put("code_status", 400);
            map.put("mission", null);
            
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
    }
}

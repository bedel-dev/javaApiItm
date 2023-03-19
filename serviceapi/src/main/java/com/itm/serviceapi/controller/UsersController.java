package com.itm.serviceapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itm.serviceapi.model.Users;
import com.itm.serviceapi.service.UsersService;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
    * Read - Get all employees
    * @return - An Iterable object of Employee full filled
    */
    @GetMapping("users/getAll")
    public   ResponseEntity<Object>  getAlldata() {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Iterable<Users> data = usersService.getallData();
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
    @PostMapping("users/adduser")
    public ResponseEntity<Object>add(@RequestBody Users user) {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Users data = usersService.saveData(user);
        	if(data!= null) {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 200);
                map.put("user", "is created");	
        	}else {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 400);
                map.put("user", "is not created");
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
    
    @PostMapping("login")
    public ResponseEntity<Object>login(@RequestBody Users user) {   	
        Map<String, Object> map = new HashMap<String, Object>();
        try {
        	Boolean data = usersService.liginuser(user);
        	if(data == true) {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 200);
                map.put("user", "is connected");	
        	}else {
            	map.clear();
                map.put("request date", new Date());
                map.put("code_status", 400);
                map.put("user", "is not connected");
        	}

            return new ResponseEntity<Object>(map,HttpStatus.OK);
        } catch (Exception e) {
            map.clear();
            map.put("request date", new Date());
            map.put("code_status", 200);
            map.put("user", null);
            return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
        }
    }
    

}

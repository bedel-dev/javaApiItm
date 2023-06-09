package com.itm.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itm.serviceapi.model.Emails;

@Repository
public interface EmailsRepository extends JpaRepository<Emails, Long> {

}

package com.itm.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itm.serviceapi.model.Missions;

@Repository
public interface MissionsRepository extends JpaRepository<Missions, Long> {

}

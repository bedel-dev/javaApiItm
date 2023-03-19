package com.itm.serviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itm.serviceapi.model.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

}

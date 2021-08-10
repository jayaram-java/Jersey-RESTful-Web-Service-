package com.ram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ram.model.SMSServiceInternal;

public interface SMSServiceInternalRepository extends CrudRepository<SMSServiceInternal, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM smsservice_internal AS i WHERE i.status_id = :statusId LIMIT 45")
	public List<Object[]> findInitialNotificationList(@Param("statusId") String statusId);

}

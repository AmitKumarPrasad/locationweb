package com.amit.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amit.location.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
	/*
	 * @Query("select type,count(type) from location group by type") public
	 * List<Object[]> findTypeAndTypeCount();
	 */

}

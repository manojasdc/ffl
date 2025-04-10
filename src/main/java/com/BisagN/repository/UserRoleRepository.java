package com.BisagN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.UserRole;
@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, Integer>{

	@Query(value = "From UserRole")
	List<UserRole> LoadUserRoleData();

	
		
}

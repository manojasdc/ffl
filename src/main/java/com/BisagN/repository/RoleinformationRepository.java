package com.BisagN.repository;

import java.util.List;	

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.Roleinformation;

@Repository
public interface RoleinformationRepository extends JpaRepository<Roleinformation, Integer> {

	@Query("From Roleinformation order by role_id")
	public List<Roleinformation> GetRoleId();
	
	@Query(value = "select * from public.roleinformation where role_id = (select role_id from public.userroleinformation where user_id = ?1)", nativeQuery = true )
	List<Roleinformation> getRolename(int id);
	
}

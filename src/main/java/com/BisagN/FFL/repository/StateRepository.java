package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbCountryName;
import com.BisagN.FFL.models.TbStateName;


@Repository
public interface StateRepository extends JpaRepository<TbStateName, Integer> {
	
	@Query(value = "FROM TbStateName")
	List<TbStateName> LoadStateData();
	
	@Query(value = "FROM TbStateName where country_id=:id and id != '-1' ORDER BY id ASC")
	List<TbStateName> LoadData(@Param("id") int id);

}
package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbCityName;
import com.BisagN.FFL.models.TbCountryName;


@Repository
public interface CityRepository extends JpaRepository<TbCityName, Integer> {
	
	@Query(value = "FROM TbCityName")
	List<TbCityName> LoadCityData();
	
	@Query(value = "FROM TbCityName where state_id=:id and id != '-1' ORDER BY id ASC")
	List<TbCityName> LoadData(@Param("id") int id);

}
package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbProfileDtl;
import com.BisagN.FFL.models.TbRegistrationDetail;


@Repository
public interface ProfileRepository extends JpaRepository<TbProfileDtl, Integer>{
	
	@Query("FROM TbProfileDtl where createdBy=?1")
	TbProfileDtl getDetails(Integer created_by);
	
//	@Query("FROM TbProfileDtl where createdBy=?1")
//	List<TbProfileDtl> getDetails1(Integer created_by);
	
	@Query("FROM TbProfileDtl where name like ?1%")
	List<TbProfileDtl> profiledata(String name);
}

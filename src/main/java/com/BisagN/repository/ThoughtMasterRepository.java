package com.BisagN.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.BisagN.models.TbThoughtDtl;


@Repository
public interface ThoughtMasterRepository extends JpaRepository<TbThoughtDtl, Integer> {
	
	@Query(value = "FROM TbThoughtDtl where status = '1'",countQuery = "select count(*) From TbThoughtDtl where status ='1'")
	Page<TbThoughtDtl> LoadData(Pageable pageable);
	
	@Query(value="select thought_of_day from tb_thought_dtl order by random() limit 1", nativeQuery = true)
	public String findRandamthoughts();
	
	@Query("FROM TbThoughtDtl where lower(thoughtOfDay) = ?1 and status='1' ")
	public List CheckThoughtsexist(String thoughtOfDay);

}

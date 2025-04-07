package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbHallOfFame;

@Repository
public interface HallOfFameRepository extends JpaRepository<TbHallOfFame, Integer> {
	
	
	@Query(value = "From TbHallOfFame where status = '1' and  createdBy=?1 and (?2 is null or CONCAT(lower(achievement)) LIKE %?2%)", countQuery = "select count(*) From TbHallOfFame where status = '1' and  createdBy=?1  and (?2 is null or CONCAT(lower(achievement)) LIKE %?2%)")
	Page<TbHallOfFame> LoadHallOfFame(Integer id,String search, Pageable pageable);
	
	@Query(value = "select * from tb_hall_of_fame where institute_map=?3  and status='1' limit ?2 offset ?1", nativeQuery = true )
	List<TbHallOfFame> LoadHallOffameshowData(int currentPage,int totalperpage,Integer userid);
	

	@Query(value = "select count(*) from tb_hall_of_fame where institute_map=?1  and status='1'", nativeQuery = true )
	Integer LoadHallOffameshowData1(Integer userid);
	
	@Query("FROM TbHallOfFame where lower(achievement) =?1")
	public List checkhalloffameExists(String achievement);
	
}
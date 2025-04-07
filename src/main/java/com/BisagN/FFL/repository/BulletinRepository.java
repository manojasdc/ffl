package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbBulletin;

@Repository
public interface BulletinRepository extends JpaRepository<TbBulletin, Integer> {

	@Query(value = "SELECT b.id, b.title, b.description, b.created_by, b.date, COALESCE(ba.approveStatus, NULL) "
	        + "FROM TbBulletin b "
	        + "LEFT JOIN TbBulletinApproval ba ON b.id = ba.bulletin_id AND (ba.username = :username OR ba.username IS NULL)")
	List<Object[]> getAllBulletins(@Param("username") String username);

}

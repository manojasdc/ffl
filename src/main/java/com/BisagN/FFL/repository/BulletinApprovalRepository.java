package com.BisagN.FFL.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BisagN.FFL.models.TbBulletinApproval;

public interface BulletinApprovalRepository extends JpaRepository<TbBulletinApproval, Integer> {

	@Query("SELECT ba.bulletin_id, ba.username , b.title , ba.approveStatus FROM TbBulletinApproval ba "
		     + "JOIN TbBulletin b ON ba.bulletin_id = b.id "
		     + "WHERE b.created_by = :user_name AND ba.username != :user_name "
		     + "AND ba.approveStatus = 'PENDING'")
	List<Object[]> getAllRequestedBulletins(@Param("user_name") String user_name);
	
	@Modifying
	@Transactional
	@Query("UPDATE TbBulletinApproval ba SET ba.approveStatus = :status WHERE ba.bulletin_id = :bulletinId AND ba.username = :username")
	int updateApprovalStatus(@Param("bulletinId") int bulletinId, @Param("username") String username, @Param("status") String status);

	@Modifying
	@Transactional
	@Query("DELETE FROM TbBulletinApproval ba WHERE ba.bulletin_id = :bulletinId AND ba.username = :username")
	void deleteByBulletinIdAndUsername(@Param("bulletinId") int bulletinId, @Param("username") String username);

}

package com.BisagN.FFL.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbNotificationDtl;


@Repository
public interface NotificationRepository extends JpaRepository<TbNotificationDtl, Integer> {

	@Query(value = "select * from tb_notification_dtl where  notification_to_id=?1 and status='1' and read_status='N' order by id desc limit 10", nativeQuery = true )
	List<TbNotificationDtl> LoadNotificationshowData(Integer notification_to_id);
	
	@Query(value = "select count(*) from tb_notification_dtl where  notification_to_id=?1 and status='1' and read_status='N'", nativeQuery = true )
	Integer LoadNotificationshowData1(Integer notification_to_id);
	
	@Query(value = "select * from tb_notification_dtl where  notification_to_id=?3 and status='1' and read_status='N' order by id desc limit ?2 offset ?1", nativeQuery = true )
	List<TbNotificationDtl> LoadNotificationData1(int currentPage,int totalperpage,Integer notification_to_id);
	
	@Query(value = "select * from tb_notification_dtl where  notification_to_id=?1 and status='1' and read_status='N'", nativeQuery = true )
	List<TbNotificationDtl> UpdateNotificationData1(Integer notification_to_id);
}



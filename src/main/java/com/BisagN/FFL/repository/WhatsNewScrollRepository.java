package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbPictureGallary;
import com.BisagN.FFL.models.TbUserAlumniEjournal;
import com.BisagN.FFL.models.TbWhatsNewScroll;


public interface WhatsNewScrollRepository  extends JpaRepository<TbWhatsNewScroll, Integer>  {
	
	
	
	@Query(value = "FROM TbWhatsNewScroll  where  createdBy=?1  and status='1' and (?2 is null or CONCAT(lower(description)) LIKE %?2%) ", countQuery = "select count(*) From TbWhatsNewScroll where createdBy=?1  and status='1' and (?2 is null or CONCAT(lower(description)) LIKE %?2%)")
	Page<TbWhatsNewScroll> LoadWhatsNewScrollData1(Integer createdBy,String search, Pageable pageable);
	
	
	@Query(value = "From TbWhatsNewScroll where status = '1' and instituteMap=?1 and (?2 is null or CONCAT(lower(description)) LIKE %?2%)", countQuery = "select count(*) From TbWhatsNewScroll  where status = '1' and instituteMap=?1 and (?2 is null or CONCAT(lower(description)) LIKE %?2%)")
	Page<TbWhatsNewScroll> LoadWhatsNewScrollData2(Integer created_by,String search, Pageable pageable);
	
	@Query(value = "From TbWhatsNewScroll where status = '1' and (?1 is null or CONCAT(lower(description)) LIKE %?1%)", countQuery = "select count(*) From TbWhatsNewScroll where status ='1'")
	Page<TbWhatsNewScroll> LoadWhatsNewScrollData3(String search, Pageable pageable);
	
//	@Query(value = "select * from tb_picture_gallary where institute_map=?3 and status='1' limit ?2 offset ?1", nativeQuery = true )
//	List<TbPictureGallary> LoadPhotoGallaryData(int currentPage,int totalperpage, int institute_map);
//	
//	@Query(value = "select count(*) from tb_picture_gallary where institute_map=?1", nativeQuery = true )
//	Integer LoadphotogallaryshowData1(int institute_map);
//	
//	@Query(value = "FROM TbPictureGallary WHERE approvalStatus = 'Pending' and instituteMap=?1 ",
//		       countQuery = "SELECT COUNT(*) FROM TbPictureGallary WHERE approvalStatus = 'Pending' and instituteMap=?1")
//		Page<TbPictureGallary> LoadPictureGallaryApprovalData(Integer id,String search, Pageable pageable);
	
	@Query(value = "select * from tb_whats_new_scroll where institute_map=?1 and status='1'", nativeQuery = true )
	List<TbWhatsNewScroll> LoadWhatsNewScrollData(int institute_map);
	
	@Query(value = "select * from tb_whats_new_scroll where institute_map=?1 and status='1'", nativeQuery = true )
	TbWhatsNewScroll LoadWhatsNewScrollData1(int institute_map);
	
	@Query(value = "FROM TbWhatsNewScroll  where approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(description)) LIKE %?2%) ", countQuery = "select count(*) From TbWhatsNewScroll where approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(lower(description)) LIKE %?2%)")
	Page<TbWhatsNewScroll> LoadWhatsNewScrollApprovalData(Integer id, String search, Pageable pageable);
	
}
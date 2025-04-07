package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BisagN.FFL.models.TbPictureGallary;

public interface PhotoGallaryRepository extends JpaRepository<TbPictureGallary, Integer> {
	@Query(value = "From TbPictureGallary where status = '1' and createdBy=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)", countQuery = "select count(*) From TbPictureGallary where status ='1' and createdBy=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)")
	Page<TbPictureGallary> LoadPictureGallaryData(Integer created_by, String search, Pageable pageable);

	@Query(value = "From TbPictureGallary where status = '1' and instituteMap=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)", countQuery = "select count(*) From TbPictureGallary where status ='1' and instituteMap=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)")
	Page<TbPictureGallary> LoadPictureGallaryData1(Integer created_by, String search, Pageable pageable);

	@Query(value = "From TbPictureGallary where status = '1' and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)", countQuery = "select count(*) From TbPictureGallary where status ='1' and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)")
	Page<TbPictureGallary> LoadPictureGallaryData2(String search, Pageable pageable);

	@Query(value = "select * from tb_picture_gallary where institute_map=?3  and status='1' limit ?2 offset ?1", nativeQuery = true)
	List<TbPictureGallary> LoadPhotoGallaryData(int currentPage, int totalperpage, int institute_map);

	@Query(value = "select count(*) from tb_picture_gallary where institute_map=?1  and status='1'", nativeQuery = true)
	Integer LoadphotogallaryshowData1(int institute_map);

	@Query(value = "FROM TbPictureGallary WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%) ", countQuery = "SELECT COUNT(*) FROM TbPictureGallary WHERE approvalStatus = 'Pending' and instituteMap=?1 and (?2 is null or CONCAT(Lower(description), Lower(category)) LIKE %?2%)")
	Page<TbPictureGallary> LoadPictureGallaryApprovalData(Integer id, String search, Pageable pageable);

	@Query("FROM TbPictureGallary where lower(imageUpload)=?1 or lower(category) =?2 or lower(description) =?3 ")
	public List checkPictureGallaryExists(String photo, String category, String description);

}
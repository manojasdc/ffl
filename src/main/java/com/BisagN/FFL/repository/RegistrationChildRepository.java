package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.FFL.models.TbRegistrationDetailChild;
import com.BisagN.FFL.models.Userloginchild;

@Repository
public interface RegistrationChildRepository extends JpaRepository<TbRegistrationDetailChild, Integer> {

	@Query("FROM TbRegistrationDetailChild U where U.registrationId.id=?1 and U.instituteId.id=?2")
	public TbRegistrationDetailChild findbyregistrationchild(Integer registrationid, Integer instituteid);

	@Query(value = "select *  from tb_registration_detail_child where registration_status='Accepted' and institute_id=?3 limit ?2 offset ?1", nativeQuery = true)
	List<TbRegistrationDetailChild> LoadAlumniDashboard(int currentPage, int totalperpage, int aluminiinstituteid);

	@Query(value = " select rc from TbRegistrationDetailChild rc inner join TbRegistrationDetail r   ON r.id = rc.registrationId\n"
			+ "inner join TbInstituteDetail i on i.id=rc.instituteId.id \n"
			+ "inner join TbCountryName c on r.countryId.id =c.id \n"
			+ "where  rc.embasyStatus='Pending'  and r.countryId.id = ?1 and (?2 is null or CONCAT(lower(r.alumniName),lower(r.emailId),r.contactNumber,rc.passoutYear,lower(rc.rollNumber),lower(i.instituteName),lower(c.countryName),lower(rc.embasyStatus)) LIKE %?2%)", countQuery = "select count(rc) from TbRegistrationDetailChild rc inner join TbRegistrationDetail r   ON r.id = rc.registrationId \n"
					+ "inner join TbInstituteDetail i on i.id=rc.instituteId.id \n"
					+ "inner join TbCountryName c on r.countryId.id =c.id \n"
					+ "where  rc.embasyStatus='Pending'  and r.countryId.id = ?1 and (?2 is null or CONCAT(lower(r.alumniName),lower(r.emailId),r.contactNumber,rc.passoutYear,lower(rc.rollNumber),lower(i.instituteName),lower(c.countryName),lower(rc.embasyStatus)) LIKE %?2%)")
	Page<TbRegistrationDetailChild> loadRegistrationDataembasy(Integer countryid, String search, Pageable pageable);

	@Query(value = "select count(rc) from TbRegistrationDetailChild rc inner join TbRegistrationDetail r   ON r.id = rc.registrationId inner join TbCountryName c on r.countryId.id =c.id where rc.embasyStatus='Pending' and r.countryId.id = ?1")
	Integer pendingembasycount(Integer countryname);

	@Query(value = "select count(rc) from TbRegistrationDetailChild rc inner join TbRegistrationDetail r   ON r.id = rc.registrationId inner join TbCountryName c on r.countryId.id =c.id where rc.embasyStatus='Accepted' and r.countryId.id = ?1")
	Integer acceptedembasycount(Integer countryname);

	@Query(value = "select count(rc) from TbRegistrationDetailChild rc inner join TbRegistrationDetail r   ON r.id = rc.registrationId inner join TbCountryName c on r.countryId.id =c.id where rc.embasyStatus='Rejected' and r.countryId.id = ?1")
	Integer rejectedembasycount(Integer countryname);

	@Query(value="select count(*) from tb_registration_detail t1\n"
			+ "inner join  tb_registration_detail_child t2 \n"
			+ "on t1.id = t2.registration_id\n"
			+ "where t1.country_id = ?1\n"
			+ "and t2.roll_number = ?2\n"
			+ "and t2.institute_id =?3",nativeQuery = true)
	public Integer CheckRollNumberExist(int country_id,  String rollnumber,int ins_id);
}

package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbRegistrationDetail;

@Repository
public interface ViewRegistrationRepository  extends JpaRepository<TbRegistrationDetail,Integer>{

		
	
//@Query(value = "SELECT r FROM TbRegistrationDetail r INNER JOIN TbInstituteDetail i ON i.id = r.instituteId WHERE r.registrationStatus = 'Pending' AND i.instituteName IS NOT NULL AND (?1 IS NULL OR CONCAT(LOWER(r.alumniName), r.passoutYear, r.rollNumber, LOWER(i.instituteName), LOWER(r.countryId.countryName), LOWER(r.registrationStatus)) LIKE %?1%)",
//	       countQuery = "SELECT COUNT(r) FROM TbRegistrationDetail r INNER JOIN TbInstituteDetail i ON i.id = r.instituteId WHERE r.registrationStatus = 'Pending' AND i.instituteName IS NOT NULL AND (?1 IS NULL OR CONCAT(LOWER(r.alumniName), r.passoutYear, r.rollNumber, LOWER(i.instituteName), LOWER(r.countryId.countryName), LOWER(r.registrationStatus)) LIKE %?1%)")
//	Page<TbRegistrationDetail> loadRegistrationData(String search,String username, Pageable pageable);

   @Query(value = "SELECT reg FROM TbRegistrationDetail reg inner join TbRegistrationDetailChild rc ON reg.id = rc.registrationId\n"
		+ "inner join TbInstituteDetail i on i.id=rc.instituteId.id \n"
		+ "inner join Userloginchild uc on uc.instituteId = i.id \n"
		+ "inner join UserLogin l on uc.userId.userId = l.userId \n"
		+ "inner join TbCountryName c on c.id=reg.countryId.id "
		+ "where l.userId=?1 and rc.registrationStatus='Pending' and (c.countryName='INDIA' or rc.embasyStatus='Accepted') and (?2 is null or CONCAT(lower(reg.alumniName),rc.passoutYear,lower(rc.rollNumber),lower(reg.emailId),reg.contactNumber,lower(i.instituteName),lower(c.countryName),lower(rc.registrationStatus)) LIKE %?2%)",  countQuery =  "select count(reg) from TbRegistrationDetail reg inner join TbRegistrationDetailChild rc   ON reg.id = rc.registrationId \n"
	    + "inner join TbInstituteDetail i on i.id=rc.instituteId.id \n"
		+ "inner join Userloginchild uc on uc.instituteId = i.id \n"
		+ "inner join UserLogin l on uc.userId.userId = l.userId \n"
		+ "inner join TbCountryName c on c.id=reg.countryId.id \n"
		+ "where l.userId=?1 and rc.registrationStatus='Pending' and (c.countryName='INDIA' or rc.embasyStatus='Accepted') and (?2 is null or CONCAT(lower(reg.alumniName),rc.passoutYear,lower(rc.rollNumber),lower(i.instituteName),lower(reg.emailId),reg.contactNumber,lower(c.countryName),lower(rc.registrationStatus)) LIKE %?2%)")
	Page<TbRegistrationDetail> loadRegistrationData(Integer username,String search, Pageable pageable);
	

	
}

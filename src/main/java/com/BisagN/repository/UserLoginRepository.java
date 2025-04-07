package com.BisagN.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbRegistrationDetail;
import com.BisagN.models.TB_LDAP_MODULE_MASTER;
import com.BisagN.models.TB_LDAP_SCREEN_MASTER;
import com.BisagN.models.TB_LDAP_SUBMODULE_MASTER;
import com.BisagN.models.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	@Query(value = "From UserLogin order by id asc")
	List<UserLogin> LoadUserData();

	@Query(value = "select l From UserLogin l INNER JOIN Userloginchild lc ON lc.userId.userId=l.userId where l.created_by = ?2 and (?1 is null or LOWER(CONCAT(l.userName,l.login_name,l.army_no,lc.instituteId.instituteName)) LIKE LOWER(CONCAT('%',?1,'%')))", countQuery = "select count(l) From UserLogin l INNER JOIN Userloginchild lc ON lc.userId.userId=l.userId where l.created_by = ?2 and (?1 is null or LOWER(CONCAT(l.userName,l.login_name,l.army_no,lc.instituteId.instituteName)) LIKE LOWER(CONCAT('%',?1,'%')))")
	Page<UserLogin> LoadUserData1(String search, String username, Pageable pageable);

//	@Query("FROM UserLogin where lower(login_name) = ?1  and lower(userName) = ?2 ")
//	public List CheckLoginNameDetailsexist(String LoginName,String userName);

	@Query("FROM UserLogin where  lower(userName) = ?1 ") //
	public List<UserLogin> CheckLoginNameDetailsexist(String userName);

	@Query("select U FROM UserLogin U INNER JOIN Userroleinformation Ur ON Ur.userId.userId=U.userId INNER JOIN Role r ON Ur.roleId.roleId=r.roleId where U.instituteId=?1  and r.roleId=?2 and r.role='ADMIN' ") //
	public List CheckLoginNameDetailsexist2(Integer instituteId, Integer userrolid);

	@Query("select U FROM UserLogin U INNER JOIN Userroleinformation Ur ON Ur.userId.userId=U.userId INNER JOIN Role r ON Ur.roleId.roleId=r.roleId where U.instituteId=?1 and r.roleId=?2 and r.role='EMBASSY ADMIN'") //
	public List CheckLoginNameDetailsexist3(Integer countryId, Integer userrolid);

	@Query(value = "From UserLogin where userid = :id order by id asc")
	public UserLogin GetUserDataByIDForActivateORDeactivate(int id);

	@Query(value = "From UserLogin", countQuery = "select count(*) From UserLogin ")
	Page<UserLogin> LoadUserData1(org.springframework.data.domain.Pageable pageable);

	@Query("FROM UserLogin U where U.userName=?1 and enabled =1")
	public UserLogin findUser(String userName);

	@Query("FROM UserLogin U where U.userId=?1")
	public UserLogin findByRoleId(int userId);

	@Query(value = "Select cast(r.role as text) from userroleinformation ur, roleinformation r where ur.role_id = r.role_id and cast(ur.user_id as text) =?1", nativeQuery = true)
	public List<String> getRoleByuserId(String userId);

	@Query("from TB_LDAP_MODULE_MASTER b where b.id > 0 and b.id in (select a.module.id from TB_LDAP_ROLEMASTER a where a.roleid=?1 and  a.module.id != 0 ) order by b.id")
	public List<TB_LDAP_MODULE_MASTER> getModulelist(int roleid);

	@Query("from TB_LDAP_SUBMODULE_MASTER b where b.module.id =?1 and b.id in (select a.sub_module.id from TB_LDAP_ROLEMASTER a where a.roleid=?2) order by b.id ")
	public List<TB_LDAP_SUBMODULE_MASTER> getSubModulelist(int moduleid, int roleid);

	@Query("from TB_LDAP_SCREEN_MASTER b where b.id in (select a.screen.id from TB_LDAP_ROLEMASTER a where a.roleid=?1) order by b.id")
	public List<TB_LDAP_SCREEN_MASTER> getScreenlist(int roleid);

	@Query("from TB_LDAP_SCREEN_MASTER b where b.id in (select a.screen.id from TB_LDAP_ROLEMASTER a where a.roleid=?3 and  a.module.id =?1 and a.sub_module.id =?2) order by b.id")
	public List<TB_LDAP_SCREEN_MASTER> getScreenlist(int moduleid, int submoduleid, int roleid);

	@Query(value = "select userid From logininformation where username LIKE %?1% limit 1", nativeQuery = true)
	Integer instituteid(String instname);

	@Query(value = "select institute_id From logininformation where userid=?1 limit 1", nativeQuery = true)
	Integer instituteid1(Integer instname);

	@Query("FROM UserLogin where lower(userName) = ?1 ") 
	public List CheckLoginNameDetailsexist1(String userName);

	@Query(value = "select count(l) from TbRegistrationDetail l")
	Integer Loadallalumni();

	@Query(value = "select rgd.*,cn.country_name  from logininformation li \n"
			+ "inner join tb_registration_detail rgd on li.username=rgd.user_name\n"
			+ "inner join tb_country_name cn on cn.id=rgd.country_id", nativeQuery = true)
	public List<Map<String, Object>> loadUserList();

//	@Query(value = "select count(*) from userloginchild where institute_id in (select li.institute_id from  logininformation li\n"
//			+ "inner join userloginchild lich on li.userid=lich.user_id\n"
//			+ "inner join tb_institute_detail insdtl on insdtl.id=lich.institute_id where li.username=:username)", nativeQuery = true)
//	Integer loaduserbyinstitutewise(String username);
	
	@Query(value = "SELECT COUNT(DISTINCT r.id) \n"
			+ "FROM tb_registration_detail r \n"
			+ "LEFT JOIN tb_registration_detail_child rc ON rc.registration_id = r.id \n"
			+ "LEFT JOIN tb_institute_detail ins ON ins.id = rc.institute_id   \n"
			+ "WHERE ins.id = ?1", nativeQuery = true)
	Integer loaduserbyinstitutewise(Integer instituteid);

	
	@Query(value = "select count(r) from TbRegistrationDetail r INNER JOIN TbRegistrationDetailChild rc ON rc.registrationId = r.id "
			+ "	 INNER JOIN TbInstituteDetail ins ON ins.id = rc.instituteId.id "
			+ "	WHERE rc.instituteId.instituteName LIKE %?1%")
	Integer Loadallalumni1(String sessionusername);

	@Query("FROM UserLogin U where U.userName Like %?1%")
	public UserLogin findUserinstitute(String userName);

	@Query("select U FROM UserLogin U INNER JOIN Userroleinformation Ur ON Ur.userId.userId=U.userId INNER JOIN Role r ON Ur.roleId.roleId=r.roleId where U.instituteId=?1  and r.role='ADMIN'")
	public UserLogin findUserinstituteFromInsID(int insId);

	@Query("select U FROM UserLogin U INNER JOIN Userroleinformation Ur ON Ur.userId.userId=U.userId INNER JOIN Role r ON Ur.roleId.roleId=r.roleId where U.instituteId=?1  and r.role='EMBASSY ADMIN'")
	public UserLogin findUserCountry(int countryId);

	@Query(value = "SELECT count(distinct logininformation.userid) FROM public.logininformation inner join public.userroleinformation ON userroleinformation.user_id = logininformation.userid where userroleinformation.role_id = '21'", nativeQuery = true)
	Integer EmbassyCount();

	@Query(value = "SELECT count(distinct logininformation.userid) FROM public.logininformation inner join public.userroleinformation ON userroleinformation.user_id = logininformation.userid where userroleinformation.role_id = '20'", nativeQuery = true)
	Integer StudentCount();

	@Transactional
	@Query("FROM UserLogin U where U.userName=?1 and enabled =1")
	public UserLogin lock(String userName);

	@Transactional
	@Query("FROM UserLogin U where U.userName=?1 and enabled =1")
	public UserLogin updateFailAttemptsCap(String userName);

	@Transactional
	@Query("FROM UserLogin U where U.userName=?1 and enabled =1")
	public UserLogin resetFailAttemptsCap(String userName);
}

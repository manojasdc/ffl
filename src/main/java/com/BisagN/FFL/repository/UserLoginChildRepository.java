package com.BisagN.FFL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.BisagN.FFL.models.TbStateName;
import com.BisagN.FFL.models.Userloginchild;
import java.util.List;

@Repository
public interface UserLoginChildRepository extends JpaRepository<Userloginchild, Integer> {
	
	@Query(value="From Userloginchild where userId.userId=?1")
	List<Userloginchild> findbyuserloginid(Integer id);
	
	@Query("FROM Userloginchild U where U.userId.userId=?1")
	public Userloginchild findByuseridId(int userId);
	
	@Query("FROM Userloginchild U where U.userId.userId=?1 and U.instituteId.id=?2")
	public Userloginchild findByuserinstitueid(int userId, int instituteid);
	
}
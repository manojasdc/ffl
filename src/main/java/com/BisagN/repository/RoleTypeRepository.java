package com.BisagN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BisagN.models.TB_LDAP_ROLE_TYPE;

@Repository
public interface RoleTypeRepository extends JpaRepository<TB_LDAP_ROLE_TYPE, Integer> {

	@Query("From TB_LDAP_ROLE_TYPE order by role_type")
	public List<TB_LDAP_ROLE_TYPE> GetRoleType();

}

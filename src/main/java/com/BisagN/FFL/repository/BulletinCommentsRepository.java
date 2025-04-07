package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbBulletinComments;

@Repository
public interface BulletinCommentsRepository extends JpaRepository<TbBulletinComments, Integer>{
	List<TbBulletinComments> findByBulletinId(int bulletinId);
}

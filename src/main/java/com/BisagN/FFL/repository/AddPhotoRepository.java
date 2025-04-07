package com.BisagN.FFL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbAdminSetting;

@Repository
public interface AddPhotoRepository extends JpaRepository<TbAdminSetting, Integer> {
	 List<TbAdminSetting> findByFlag(String flag);
}

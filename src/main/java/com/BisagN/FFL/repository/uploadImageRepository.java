package com.BisagN.FFL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BisagN.FFL.models.TbAdminImage;

@Repository
public interface uploadImageRepository extends JpaRepository<TbAdminImage, Integer> {

}

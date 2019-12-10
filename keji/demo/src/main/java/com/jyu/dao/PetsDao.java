package com.jyu.dao;

import com.jyu.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsDao extends JpaRepository<Pet,Long>, JpaSpecificationExecutor<Pet> {

}


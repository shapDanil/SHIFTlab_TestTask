package com.cft.taskshop.repository;

import com.cft.taskshop.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD,Integer>{
}

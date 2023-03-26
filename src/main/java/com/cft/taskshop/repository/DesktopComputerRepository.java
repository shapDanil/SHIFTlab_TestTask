package com.cft.taskshop.repository;


import com.cft.taskshop.model.DesktopComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopComputerRepository extends JpaRepository<DesktopComputer, Integer> {

}

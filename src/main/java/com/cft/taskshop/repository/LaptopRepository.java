package com.cft.taskshop.repository;

import com.cft.taskshop.model.DesktopComputer;
import com.cft.taskshop.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}

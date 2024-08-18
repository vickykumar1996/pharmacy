package com.apollo.pharmacy.repository;

import com.apollo.pharmacy.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository  extends JpaRepository<Medicine,Long> {

    Optional<Medicine> findByName(String name);
}

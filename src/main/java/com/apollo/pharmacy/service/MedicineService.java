package com.apollo.pharmacy.service;

import com.apollo.pharmacy.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {

    public Medicine addMedicine(Medicine medicine);

   public List<Medicine> getAllMedicine();

   public Medicine getMedicineById(Long id);

   public Medicine updateMedicine(Long id,Medicine medicineDetails);

   public void deleteMedicine(Long id);

   public Optional<Medicine> findByName(String name);
}

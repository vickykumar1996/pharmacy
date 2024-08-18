package com.apollo.pharmacy.service;

import com.apollo.pharmacy.entity.Medicine;
import com.apollo.pharmacy.exception.ResourceNotFoundException;
import com.apollo.pharmacy.repository.MedicineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine addMedicine(Medicine medicine) {
        Medicine saveMedicine = medicineRepository.save(medicine);
        return saveMedicine;
    }

    @Override
    public List<Medicine> getAllMedicine() {
        List<Medicine> medicineList = medicineRepository.findAll();
        return medicineList;
    }

    @Override
    public Medicine getMedicineById(Long id) {
        Medicine medicineById = medicineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medicine not found with id: " + id));

        return medicineById;
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine medicineDetails) {

        Medicine updateMedicine = medicineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nedicine is not found with this id" + id));
        // update fields
        updateMedicine.setName(medicineDetails.getName());
        updateMedicine.setManufacture(medicineDetails.getManufacture());
        updateMedicine.setQuantity(medicineDetails.getQuantity());
        updateMedicine.setPrice(medicineDetails.getPrice());
        updateMedicine.setExpiryDate(medicineDetails.getExpiryDate());

        return medicineRepository.save(updateMedicine);
    }

    @Override
    public void deleteMedicine(Long id)  {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found with id: " + id));
        medicineRepository.delete(medicine);
    }

    @Override
    public Optional<Medicine> findByName(String name) {
        return medicineRepository.findByName(name);
    }


//    @Override
//    public Medicine findByName(String name) {
//        return medicineRepository.findByName(name)
//                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found with Name: " + name));
//    }

}

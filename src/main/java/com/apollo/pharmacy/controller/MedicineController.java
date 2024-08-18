package com.apollo.pharmacy.controller;

import com.apollo.pharmacy.entity.Medicine;
import com.apollo.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine){
        Medicine addedMedicine = medicineService.addMedicine(medicine);
        return new ResponseEntity<>(addedMedicine, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicine(){
        List<Medicine> allMedicine = medicineService.getAllMedicine();
        return new ResponseEntity<>(allMedicine,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable long id){
        Medicine medicineById = medicineService.getMedicineById(id);
        return new ResponseEntity<>(medicineById,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable long id,@RequestBody Medicine medicineUpdate){
        Medicine updatedMedicineByMe = medicineService.updateMedicine(id, medicineUpdate);
        return new ResponseEntity<>(updatedMedicineByMe,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>("medicine is deleted.......",HttpStatus.OK);

    }


    @GetMapping("/findByName")
    public ResponseEntity<Medicine> findByName(@RequestParam String name){
        Optional<Medicine> byName = medicineService.findByName(name);

        if(byName.isPresent()){
            return new ResponseEntity<>(byName.get(),HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}

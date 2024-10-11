package com.med.medicamentapi.repository;


//import com.med.medicamentapi.model.BulbModel;
import com.med.medicamentapi.model.CabinetModel;
import com.med.medicamentapi.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CabinetRepository extends JpaRepository<CabinetModel, UUID> {
//    List<PatientModel> findByName(String name);
}

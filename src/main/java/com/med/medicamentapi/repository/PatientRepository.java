package com.med.medicamentapi.repository;


//import com.med.medicamentapi.model.BulbModel;
import com.med.medicamentapi.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
    @Query("SELECT p FROM PatientModel p WHERE p.user_account.id = :userAccountId")
    PatientModel findPatientByUserAccountId(UUID userAccountId);
}

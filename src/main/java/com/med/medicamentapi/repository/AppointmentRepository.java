package com.med.medicamentapi.repository;


//import com.med.medicamentapi.model.BulbModel;
import com.med.medicamentapi.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
    List<AppointmentModel> findByPatientId(UUID id);
}

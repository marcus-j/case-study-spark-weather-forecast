package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

	List<Patient> findByName(String name);
}

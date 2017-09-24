package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

	List<Doctor> findByName(String name);
}

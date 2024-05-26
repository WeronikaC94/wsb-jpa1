package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE p.lastName = ?1")
    List<PatientEntity> findByLastName(String lastName);

    @Query("SELECT p FROM PatientEntity p WHERE (SELECT COUNT(v) FROM VisitEntity v WHERE v.patient.id = p.id) > ?1")
    List<PatientEntity> findPatientsWithMoreThanXVisits(Long x);

    @Query("SELECT v FROM VisitEntity v WHERE v.patient.id = ?1")
    List<VisitEntity> findVisitsByPatientId(Long patientId);

    @Query("SELECT p FROM PatientEntity p WHERE p.dateOfBirth > ?1")
    List<PatientEntity> findPatientsByBirthDateAfter(LocalDate date);
}

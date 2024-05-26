package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitDao extends JpaRepository<VisitEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE (SELECT COUNT(v) FROM VisitEntity v WHERE v.patient.id = p.id) > ?1")
    List<PatientEntity> findPatientsWithMoreThanXVisits(Long x);

}

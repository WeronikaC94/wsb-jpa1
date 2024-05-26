package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        String lastName = "Makota";

        List<PatientEntity> patients = patientDao.findByLastName(lastName);

        assertThat(patients).isNotEmpty();
        assertThat(patients.size()).isEqualTo(1); //
    }


    @Test
    @Transactional
    public void testShouldFindPatientsWithMoreThanXVisits() {
        Long X = 1L;

        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(X);

        assertThat(patients).isNotEmpty();

    }




    @Transactional
    @Test
    public void testShouldFindVisitsByPatientId() {
        Long patientId = 1L;

        List<VisitEntity> visits = patientDao.findVisitsByPatientId(patientId);

        assertThat(visits).isNotEmpty();
        assertThat(visits.size()).isGreaterThan(0);
    }

    @Transactional
    @Test
    public void testShouldFindPatientsByBirthDateAfter() {
        LocalDate date = LocalDate.parse("1985-01-01");

        List<PatientEntity> patients = patientDao.findPatientsByBirthDateAfter(date);

        assertThat(patients).isNotEmpty();
    }
}

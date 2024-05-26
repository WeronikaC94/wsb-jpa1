insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'testowa', 'ulica', 'city', '66-666');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'Ulica', 'Kwiatowa', 'Miasto', '11-646');

insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id)
            values (1, '1994-05-24', 'test@wp.pl', 'Weronika', 'Czyż', 1, '111-111-111', 1);
insert into patient (id, date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id)
            values (2, '2004-08-04', 'poczta@wp.pl', 'Ala', 'Makota', 2, '112-111-111', 3);

insert into  medical_treatment (id, description, type)
            values (1, 'gips kończyna górna', 'USG');

insert into  doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id)
            values (1, '1', 'doctor@wp.pl', 'Doktor','Dobry', 'SURGEON', '123-555-123', 2);

insert into  visit (id, description, time, patient_id, medical_treatment_id, doctor_id)
            values (1, 'obrzek reki', '2024-05-21 10:30:00', 1, 1, 1);
insert into  visit (id, description, time, patient_id, medical_treatment_id, doctor_id)
            values (2, 'złamany palec', '2024-07-11 12:30:00', 1, 1, 1);
insert into  visit (id, description, time, patient_id, medical_treatment_id, doctor_id)
            values (3, 'złamany palec', '2024-07-11 12:30:00', 2, 1, 1);


SELECT * FROM PATIENT WHERE LAST_NAME = 'Makota';

SELECT * FROM VISIT WHERE PATIENT_ID = 1;

SELECT p.* FROM PATIENT p
                    JOIN VISIT v ON p.ID = v.PATIENT_ID
GROUP BY p.ID
HAVING COUNT(v.ID) > 1;

SELECT * FROM PATIENT WHERE DATE_OF_BIRTH > '1985-01-01';









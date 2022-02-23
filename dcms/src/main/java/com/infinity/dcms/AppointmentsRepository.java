package com.infinity.dcms;

import java.sql.Timestamp;


import java.util.Date;
import java.util.List;



import com.infinity.dcms.Appointments;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
public interface AppointmentsRepository extends CrudRepository<Appointments, Integer> {
    @Query("FROM Appointments WHERE appointmentdate < adddate(CurDate() ,1) AND (status ='booked' OR status ='update') ORDER BY appointmentdate ASC")
    List<Appointments> findByAppointmentdate();

    List<Appointments> findByPid(Integer pid);

    @Query("SELECT COUNT(a) FROM Appointments a WHERE a.status=?1 AND a.appointmentdate >= ?2")
        long countByStatus(String name,Date date);



    int deleteByPid(Integer pid);

}

package faber.app.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faber.app.flightapp.entity.ArrivalAirport;

/**
 * ArrivalAirportRepository
 * 
 * @author TuanAnh
 *
 */
@Repository
public interface ArrivalAirportRepository extends JpaRepository<ArrivalAirport, Integer>{

}

package faber.app.flightapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import faber.app.flightapp.entity.Flight;

/**
 * FlightRepository
 * 
 * @author TuanAnh
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // findOneWayByDepartureDateAndTime
    @Query(value = "SELECT f.* FROM flights f WHERE f.departure_airport_id = ?1 AND f.arrival_airport_id = ?2 AND LOWER(f.departure_date_and_time) LIKE LOWER(concat('%', concat(?3, '%')))", nativeQuery=true)
    List<Flight> findOneWayByDepartureDateAndTime(Integer departureAirportId, Integer arrivalAirportId, Date departureDateAndTime);
    
    // findByDepartureDateAndTimeAndArrivalDateAndTime
    @Query(value = "SELECT f.* FROM flights f WHERE f.departure_airport_id = ?1 AND f.arrival_airport_id = ?2 AND LOWER(f.departure_date_and_time) LIKE LOWER(concat('%', concat(?3, '%'))) AND LOWER(f.arrival_date_and_time) LIKE LOWER(concat('%', concat(?4, '%')))", nativeQuery=true)
    List<Flight> findByDepartureDateAndTimeAndArrivalDateAndTime(Integer departureAirportId, Integer arrivalAirportId, Date departureDateAndTime, Date arrivalDateAndTime);

    // findReturnFlightsByDepartureDateAndTime
    @Query(value = "SELECT f.* FROM flights f WHERE f.departure_airport_id = ?1 AND f.arrival_airport_id = ?2 AND LOWER(f.departure_date_and_time) LIKE LOWER(concat('%', concat(?3, '%')))", nativeQuery=true)
    List<Flight> findReturnFlightsByDepartureDateAndTime(Integer departureAirportId, Integer arrivalAirportId, Date departureDateAndTime);
}

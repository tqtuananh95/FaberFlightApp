package faber.app.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faber.app.flightapp.entity.DepartureAirport;

/**
 * DepartureAirportRepository
 * 
 * @author TuanAnh
 *
 */
@Repository
public interface DepartureAirportRepository extends JpaRepository<DepartureAirport, Integer> {

}

package faber.app.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import faber.app.flightapp.entity.Order;

/**
 * OrderRepository
 * 
 * @author TuanAnh
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

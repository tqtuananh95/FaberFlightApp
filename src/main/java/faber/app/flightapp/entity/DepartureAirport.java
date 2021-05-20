package faber.app.flightapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DepartureAirport
 * 
 * @author TuanAnh
 *
 */
@Entity
@Table(name = "departure_airport")
public class DepartureAirport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departure_airport_id")
    private Integer departureAirportId;

    @Column(name = "departure_airport_name", nullable = false)
    private String departureAirportName;

    public DepartureAirport() {
        super();
    }

    public DepartureAirport(String departureAirportName) {
        super();
        this.departureAirportName = departureAirportName;
    }

    /**
     * @return the departureAirportId
     */
    public Integer getDepartureAirportId() {
        return departureAirportId;
    }

    /**
     * @param departureAirportId the departureAirportId to set
     */
    public void setDepartureAirportId(Integer departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    /**
     * @return the departureAirportName
     */
    public String getDepartureAirportName() {
        return departureAirportName;
    }

    /**
     * @param departureAirportName the departureAirportName to set
     */
    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }
}

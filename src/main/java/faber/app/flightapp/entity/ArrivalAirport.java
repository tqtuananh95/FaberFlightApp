package faber.app.flightapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ArrivalAirport
 * 
 * @author TuanAnh
 *
 */
@Entity
@Table(name = "arrival_airport")
public class ArrivalAirport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arrival_airport_id")
    private Integer arrivalAirportId;

    @Column(name = "arrival_airport_name", nullable = false)
    private String arrivalAirportName;

    public ArrivalAirport() {
        super();
    }

    public ArrivalAirport(String arrivalAirportName) {
        super();
        this.arrivalAirportName = arrivalAirportName;
    }

    /**
     * @return the arrivalAirportId
     */
    public Integer getArrivalAirportId() {
        return arrivalAirportId;
    }

    /**
     * @param arrivalAirportId the arrivalAirportId to set
     */
    public void setArrivalAirportId(Integer arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    /**
     * @return the arrivalAirportName
     */
    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    /**
     * @param arrivalAirportName the arrivalAirportName to set
     */
    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }
}

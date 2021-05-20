package faber.app.flightapp.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Flight
 * 
 * @author TuanAnh
 *
 */
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightID;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private DepartureAirport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private ArrivalAirport arrivalAirport;

    @Column(name = "departure_date_and_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDateAndTime;

    @Column(name = "arrival_date_and_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDateAndTime;

    @Column(name = "price", nullable = false, precision = 19, scale = 0)
    private BigDecimal price;

    public Flight() {
        super();
    }

    public Flight(DepartureAirport departureAirport, ArrivalAirport arrivalAirport, Date departureDateAndTime,
            Date arrivalDateAndTime, BigDecimal price) {
        super();
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateAndTime = departureDateAndTime;
        this.arrivalDateAndTime = arrivalDateAndTime;
        this.price = price;
    }

    /**
     * @return the flightID
     */
    public Integer getFlightID() {
        return flightID;
    }

    /**
     * @param flightID the flightID to set
     */
    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    /**
     * @return the departureAirport
     */
    public DepartureAirport getDepartureAirport() {
        return departureAirport;
    }

    /**
     * @param departureAirport the departureAirport to set
     */
    public void setDepartureAirport(DepartureAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * @return the arrivalAirport
     */
    public ArrivalAirport getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * @param arrivalAirport the arrivalAirport to set
     */
    public void setArrivalAirport(ArrivalAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * @return the departureDateAndTime
     */
    public Date getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    /**
     * @param departureDateAndTime the departureDateAndTime to set
     */
    public void setDepartureDateAndTime(Date departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    /**
     * @return the arrivalDateAndTime
     */
    public Date getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    /**
     * @param arrivalDateAndTime the arrivalDateAndTime to set
     */
    public void setArrivalDateAndTime(Date arrivalDateAndTime) {
        this.arrivalDateAndTime = arrivalDateAndTime;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

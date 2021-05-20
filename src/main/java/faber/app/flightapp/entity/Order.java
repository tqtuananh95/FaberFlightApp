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
 * Order
 * 
 * @author TuanAnh
 *
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "time_of_order", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date timeOfOrder;

    @Column(name = "return_type", nullable = false)
    private Integer returnType;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

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

    @Column(name = "total_adult_senior_child", nullable = false)
    private String totalAdultSeniorChild;

    @Column(name = "price_per_flight", nullable = false, precision = 19, scale = 0)
    private BigDecimal pricePerFlight;

    @Column(name = "total_price_for_order", nullable = false, precision = 19, scale = 0)
    private BigDecimal totalPriceForOrder;

    public Order() {
        super();
    }

    public Order(Date timeOfOrder, Integer returnType, Flight flight, DepartureAirport departureAirport,
            ArrivalAirport arrivalAirport, Date departureDateAndTime, Date arrivalDateAndTime,
            String totalAdultSeniorChild, BigDecimal pricePerFlight, BigDecimal totalPriceForOrder) {
        super();
        this.timeOfOrder = timeOfOrder;
        this.returnType = returnType;
        this.flight = flight;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateAndTime = departureDateAndTime;
        this.arrivalDateAndTime = arrivalDateAndTime;
        this.totalAdultSeniorChild = totalAdultSeniorChild;
        this.pricePerFlight = pricePerFlight;
        this.totalPriceForOrder = totalPriceForOrder;
    }

    /**
     * @return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the timeOfOrder
     */
    public Date getTimeOfOrder() {
        return timeOfOrder;
    }

    /**
     * @param timeOfOrder the timeOfOrder to set
     */
    public void setTimeOfOrder(Date timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    /**
     * @return the returnType
     */
    public Integer getReturnType() {
        return returnType;
    }

    /**
     * @param returnType the returnType to set
     */
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }

    /**
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
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
     * @return the totalAdultSeniorChild
     */
    public String getTotalAdultSeniorChild() {
        return totalAdultSeniorChild;
    }

    /**
     * @param totalAdultSeniorChild the totalAdultSeniorChild to set
     */
    public void setTotalAdultSeniorChild(String totalAdultSeniorChild) {
        this.totalAdultSeniorChild = totalAdultSeniorChild;
    }

    /**
     * @return the pricePerFlight
     */
    public BigDecimal getPricePerFlight() {
        return pricePerFlight;
    }

    /**
     * @param pricePerFlight the pricePerFlight to set
     */
    public void setPricePerFlight(BigDecimal pricePerFlight) {
        this.pricePerFlight = pricePerFlight;
    }

    /**
     * @return the totalPriceForOrder
     */
    public BigDecimal getTotalPriceForOrder() {
        return totalPriceForOrder;
    }

    /**
     * @param totalPriceForOrder the totalPriceForOrder to set
     */
    public void setTotalPriceForOrder(BigDecimal totalPriceForOrder) {
        this.totalPriceForOrder = totalPriceForOrder;
    }
}

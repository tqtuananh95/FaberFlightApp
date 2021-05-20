package faber.app.flightapp.form;

/**
 * SearchForm
 * 
 * @author TuanAnh
 *
 */
public class SearchForm {

    private Integer departureAirportId;

    private Integer arrivalAirportId;

    private String departureDateAndTime;

    private String arrivalDateAndTime;

    private Integer adult;

    private Integer senior;

    private Integer children;

    public SearchForm() {
        super();
    }

    public SearchForm(Integer departureAirportId, Integer arrivalAirportId, String departureDateAndTime,
            String arrivalDateAndTime, Integer adult, Integer senior, Integer children) {
        super();
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureDateAndTime = departureDateAndTime;
        this.arrivalDateAndTime = arrivalDateAndTime;
        this.adult = adult;
        this.senior = senior;
        this.children = children;
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
     * @return the departureDateAndTime
     */
    public String getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    /**
     * @param departureDateAndTime the departureDateAndTime to set
     */
    public void setDepartureDateAndTime(String departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    /**
     * @return the arrivalDateAndTime
     */
    public String getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    /**
     * @param arrivalDateAndTime the arrivalDateAndTime to set
     */
    public void setArrivalDateAndTime(String arrivalDateAndTime) {
        this.arrivalDateAndTime = arrivalDateAndTime;
    }

    /**
     * @return the adult
     */
    public Integer getAdult() {
        return adult;
    }

    /**
     * @param adult the adult to set
     */
    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    /**
     * @return the senior
     */
    public Integer getSenior() {
        return senior;
    }

    /**
     * @param senior the senior to set
     */
    public void setSenior(Integer senior) {
        this.senior = senior;
    }

    /**
     * @return the children
     */
    public Integer getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Integer children) {
        this.children = children;
    }
}

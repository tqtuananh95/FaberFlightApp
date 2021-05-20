package faber.app.flightapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import faber.app.flightapp.entity.Flight;
import faber.app.flightapp.form.SearchForm;
import faber.app.flightapp.repository.ArrivalAirportRepository;
import faber.app.flightapp.repository.DepartureAirportRepository;
import faber.app.flightapp.repository.FlightRepository;

/**
 * HomeController
 *
 * @author TuanAnh
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private DepartureAirportRepository departureAirportRepository;

    @Autowired
    private ArrivalAirportRepository arrivalAirportRepository;

    @Autowired
    private FlightRepository flightRepository;

    /**
     * initScreen
     *
     * @param model
     * @return returnPage
     */
    @RequestMapping(method = RequestMethod.GET)
    private String initScreen(Model model) {

        model.addAttribute("dAirportList", departureAirportRepository.findAll());
        model.addAttribute("aAirportList", arrivalAirportRepository.findAll());
        return "home";
    }

    /**
     * searchFlight
     *
     * @param model
     * @param searchForm
     * @return returnPage
     * @throws ParseException
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    private String searchFlight(SearchForm searchForm, Model model) throws ParseException {
        // List Departure Airport Flight
        if (!searchForm.getDepartureDateAndTime().isEmpty() && searchForm.getArrivalDateAndTime().isEmpty()) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(searchForm.getDepartureDateAndTime());
            List<Flight> listFlight = flightRepository.findOneWayByDepartureDateAndTime(searchForm.getDepartureAirportId(),
                    searchForm.getArrivalAirportId(), date);
            model.addAttribute("dlistFlight", listFlight);
        } else {
            Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchForm.getDepartureDateAndTime());
            Date aDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchForm.getArrivalDateAndTime());
            List<Flight> listFlight = flightRepository.findByDepartureDateAndTimeAndArrivalDateAndTime(
                    searchForm.getDepartureAirportId(), searchForm.getArrivalAirportId(), dDate, aDate);
            model.addAttribute("dlistFlight", listFlight);
        }
        // List Arrival Airport Flight
        if (!searchForm.getArrivalDateAndTime().isEmpty()) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(searchForm.getArrivalDateAndTime());
            List<Flight> listFlight = flightRepository.findReturnFlightsByDepartureDateAndTime(searchForm.getArrivalAirportId(),
                    searchForm.getDepartureAirportId(), date);
            model.addAttribute("alistFlight", listFlight);
        }
        model.addAttribute("detailList", searchForm);
        return "flight";
    }
}

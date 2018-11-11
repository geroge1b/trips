package ro.sci.trips.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sci.trips.entity.Trip;
import ro.sci.trips.repository.TripRepository;
import ro.sci.trips.service.TripService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class MyAppController {

    private final TripService tripService;

    @Autowired
    public MyAppController(TripService tripService) {
        this.tripService = tripService;
    }


    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripsList";
    }

    @RequestMapping(value={"/tripEdit","/tripEdit/{id}"}, method = RequestMethod.GET)
    public String tripEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (null != id) {
            model.addAttribute("trip", tripService.getTrip(id));
        } else {
            model.addAttribute("trip", new Trip());
        }
        return "tripEdit";
    }

    @RequestMapping(value="/tripEdit", method = RequestMethod.POST)
    public String tripEdit(Model model, Trip trip) {
        tripService.createTrip(trip);
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripsList";
    }

    @RequestMapping(value = "/tripDelete/{id}", method = RequestMethod.GET)
    public String tripDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
        tripService.deleteTrip(id);
        model.addAttribute("trips", tripService.getAllTrips());
        return "tripsList";
    }
/*
    @RequestMapping(value = "/trips", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("index");
        List<Trip> tripList = tripService.getAllTrips();
        model.addObject("tripList", tripList);
        return model;
    }


    @RequestMapping(value = "/saveTrip/", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("tripForm") Trip trip) {
        tripService.editTrip(trip);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addTrip/", method = RequestMethod.POST)
    public ModelAndView addTrip() {
        ModelAndView model = new ModelAndView();
        Trip trip = new Trip();
        model.addObject("tripForm", trip);
        model.setViewName("trip_form");
        return model;
    }


    @RequestMapping(value = "/editTrip{id}", method = RequestMethod.GET)
    public ModelAndView editTrip(@PathVariable long id) {
        ModelAndView model = new ModelAndView();
        Trip trip = tripService.getTripById(id);

        model.addObject("tripForm", trip);
        model.setViewName("trip_form");
        return model;
    }



    @RequestMapping(value = "/deleteTrip/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id){
        tripService.deleteTrip(id);
        return new ModelAndView("redirect:/");
    }

*/

/*

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "index";
    }

    @RequestMapping(value = "trip/new", method = RequestMethod.GET)
    public String newTrip(Model model) {
        model.addAttribute("trip", tripService.createTrip(new Trip()));
        return "trip/tripform";
    }


    @RequestMapping(value = "/trip", method = RequestMethod.GET)
    public String addPageTrip(@ModelAttribute Trip trip, Model model) {
        tripService.createTrip(trip);
        model.addAttribute("trips", tripService.getAllTrips());
        return "result";
    }

    @RequestMapping(value={"/sendTrip"},method = RequestMethod.POST)
    public String selectTrip(Model model, HttpSession session, HttpServletRequest request) {

        String selectedTrip = request.getParameter("id");
        return "trips";
    }

*/

}

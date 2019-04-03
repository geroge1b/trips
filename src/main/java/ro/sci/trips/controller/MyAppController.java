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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTrips(@RequestParam(value = "tripId", required = false) Long tripId , Model model) {

        if(tripId != null){
            model.addAttribute("trips", tripService.getAllTripsById(tripId));
        }
        else {
            model.addAttribute("trips", tripService.getAllTrips());
        }
        return "index";
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
        return "index";
    }

    @RequestMapping(value = "/tripDelete/{id}", method = RequestMethod.GET)
    public String tripDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
        tripService.deleteTrip(id);
        model.addAttribute("trips", tripService.getAllTrips());
        return "index";
    }



    @RequestMapping(value={"/profile"}, method = RequestMethod.GET)
    public String showProfile() {

        return "profile";
    }



}

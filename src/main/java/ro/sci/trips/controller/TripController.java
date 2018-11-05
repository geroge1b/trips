package ro.sci.trips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.trips.entity.Trip;
import ro.sci.trips.service.TripService;

import java.util.List;

@Controller
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        //Trip t = new Trip(3, "My third trip", "The third place I've visited");
        //tripService.createTrip(t);
        model.addAttribute("trip", new Trip());
        return "homePage";
    }


    @RequestMapping(value = "/trip", method = RequestMethod.GET)
    public String homePage(@ModelAttribute List<Trip> trips, Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "homePage";
    }

}

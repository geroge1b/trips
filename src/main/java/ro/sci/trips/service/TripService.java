package ro.sci.trips.service;

import ro.sci.trips.entity.Trip;
import java.util.List;

public interface TripService {

    Trip createTrip(Trip trip);
    Trip getTrip(Long id);
    Trip getTripById(Long id);
    Trip editTrip(Trip trip);
    void deleteTrip(Long id);
    void deleteTrip(Trip trip);
    List<Trip> getAllTrips();

//    List<Trip> getAllTrips(int pageNumber, int pageSize);

}

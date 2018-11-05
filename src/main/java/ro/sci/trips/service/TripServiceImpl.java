package ro.sci.trips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.trips.entity.Trip;
import ro.sci.trips.repository.TripRepository;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip getTrip(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new NullPointerException("Not found"));
    }

    @Override
    public Trip editTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public void deleteTrip(Trip trip) {
        tripRepository.delete(trip);

    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}

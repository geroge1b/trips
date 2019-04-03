package ro.sci.trips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.trips.entity.Trip;
import ro.sci.trips.repository.TripRepository;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Override
    public Trip createTrip(Trip trip) {

        return tripRepository.save(trip);
    }

    @Override
    public Trip getTrip(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new NullPointerException("Not found"));
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.findById(id).get();
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
        return (List<Trip>) tripRepository.findAll();
    }

    @Override
    public List<Trip> getAllTripsById(Long id) {
        List<Trip> tcList = new ArrayList<>();
        List<Trip> all = getAllTrips();

        for (Trip t : all) {
            if (t.getId() == id) {
                tcList.add(0, t);
                break;
            }
        }
        for (Trip t : all) {
            if (t.getId() != (id)) {
                tcList.add(t);
            }
        }

        return tcList;
    }


    /*
        @Override
        public List<Trip> getAllTrips(int pageNumber, int pageSize) {
            return tripRepository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
        }
    */
}

package com.amit.location.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.location.entities.Location;
import com.amit.location.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {

		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);

	}

	@Override
	public Location getLocationById(long id) {
		return locationRepository.getOne(id);
	}

	@Override
	public List<Location> getAllLocations() {

		return locationRepository.findAll();
	}

}

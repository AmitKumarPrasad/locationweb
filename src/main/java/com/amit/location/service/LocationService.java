package com.amit.location.service;

import java.util.List;

import com.amit.location.entities.Location;

public interface LocationService {
	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(long id);

	List<Location> getAllLocations();

}

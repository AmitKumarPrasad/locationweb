package com.amit.location.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.location.entities.Location;
import com.amit.location.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	private LocationRepository repository;

	@GetMapping("/getAllLocations")
	public List<Location> getLocations() {
		return repository.findAll();
	}

	@PostMapping("/save")
	public Location createNew(@Valid @RequestBody Location location) {
		return repository.save(location);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Location> getById(@PathVariable(value = "id") Long id) {
		Location location = repository.getOne(id);
		if (location == null) {
			return new ResponseEntity<Location>(location, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Location>(location, HttpStatus.OK);

	}

	@PutMapping("/update")
	public Location updateLocation(@Valid @RequestBody Location location) {
		return repository.save(location);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteLocation(@PathVariable(value = "id") Long id) {
		repository.deleteById(id);
	}

}

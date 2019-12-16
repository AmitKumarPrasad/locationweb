package com.amit.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.location.entities.Location;
import com.amit.location.repository.LocationRepository;
import com.amit.location.service.LocationService;
import com.amit.location.util.EmailUtil;
import com.amit.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private LocationRepository repository;

	@Autowired
	EmailUtil emailUtil;

	/*
	 * @Autowired private ReportUtil reportUtil;
	 */
	/*
	 * @Autowired private ServletContext sc;
	 */

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap model) {
		Location locationSaved = locationService.saveLocation(location);
		String msg = "Location Saved With ID:" + locationSaved.getId();
		model.addAttribute("msg", msg);
		emailUtil.sendEmail("amitkumarprasad0@gmail.com", "Location Saved",
				"Lcation Saved Successfull and about to return response");
		System.out.println(location);
		return "createLocation";

	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap map) {
		List<Location> locations = locationService.getAllLocations();
		map.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("deleteLocation")
	public String deleteLocations(@RequestParam("id") long id, ModelMap map) {
		// Location location = locationService.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		locationService.deleteLocation(location);
		List<Location> locations = locationService.getAllLocations();
		map.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") long id, ModelMap map) {
		Location location = locationService.getLocationById(id);
		map.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap map) {
		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		map.addAttribute("locations", locations);
		return "displayLocations";
	}

	/*
	 * @RequestMapping("/generateReport") public String generateReport() { String
	 * path = sc.getRealPath("/"); List<Object[]> data =
	 * repository.findTypeAndTypeCount(); reportUtil.generatePieChart(path, data);
	 * return "report";
	 * 
	 * }
	 */

}

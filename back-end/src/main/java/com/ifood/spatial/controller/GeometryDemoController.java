package com.ifood.spatial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifood.spatial.service.GeometryDemoService;
import com.ifood.spatial.service.model.GeometryDemo;


@RestController
@RequestMapping("geometryDemo")
public class GeometryDemoController {
	
	@Autowired
	private GeometryDemoService geometryDemoService;
	
    @CrossOrigin
	@PostMapping
	public void save(@RequestBody GeometryDemo geometryDemo) {
		geometryDemoService.save(geometryDemo);
	}
    
    @CrossOrigin
	@PostMapping("saveDifference")
	public void saveDifference(@RequestBody GeometryDemo geometryDemo) {
		geometryDemoService.saveDifference(geometryDemo);
	}
    
    @CrossOrigin
	@PostMapping("saveBuffer")
	public void saveBuffer(@RequestBody GeometryDemo geometryDemo) {
		geometryDemoService.saveBuffer(geometryDemo);
	}
	
    @CrossOrigin
	@GetMapping
	public List<GeometryDemo> findAll() {
		return geometryDemoService.findAll();
	}
    
    @CrossOrigin
	@DeleteMapping
	public void deleteAll() {
    	geometryDemoService.deleteAll();
	}

}

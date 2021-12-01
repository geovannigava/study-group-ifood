package com.ifood.spatial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.ifood.spatial.service.model.GeometryDemo;
import com.ifood.spatial.service.repository.GeometryDemoRepository;
import com.ifood.spatial.util.GeoUtil;
import com.vividsolutions.jts.geom.Geometry;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GeometryDemoService {
	
	@Autowired
	private GeometryDemoRepository geometryRepository;
	

	public void save(@RequestBody GeometryDemo geometryDemo) {
		Double area = GeoUtil.calcAreaInMeters(geometryDemo.getGeom());
		System.out.println(area);
		geometryDemo.getGeom().setSRID(4674);
		geometryRepository.save(geometryDemo);
	}
	
	public void saveDifference(GeometryDemo geometryDemo) {
		geometryDemo.setGeom(this.difference(geometryDemo.getGeom()));
		this.save(geometryDemo);
	}
	
	public void saveBuffer(GeometryDemo geometryDemo) {
		geometryDemo.setGeom(geometryDemo.getGeom().buffer(0.0002D));
		this.save(geometryDemo);
	}
	
	public List<GeometryDemo> findAll() {
		return geometryRepository.findAll();
	}
    

	public void deleteAll() {
		 geometryRepository.deleteAll();
	}
	
	
	private Geometry difference(Geometry geom) {
		List<GeometryDemo> geomDb = this.findAll();

		if(!geomDb.isEmpty()) {
			Geometry areaExcluir = null;
			for (int i = 0; i < geomDb.size(); i++) {
				for (int j = 0; j < geomDb.get(i).getGeom().getNumGeometries(); j++) {
					if(areaExcluir == null) {
						areaExcluir = geomDb.get(i).getGeom().getGeometryN(j);
					}else {
						areaExcluir = areaExcluir.union(geomDb.get(i).getGeom().getGeometryN(j));
					}
				}
			}
			if (areaExcluir != null) {
				geom = geom.getGeometryN(0).difference(areaExcluir);
			}
		}
		return geom;
	}
	
}

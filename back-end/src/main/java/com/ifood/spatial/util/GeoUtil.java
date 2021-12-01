package com.ifood.spatial.util;

import java.io.IOException;

import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

public class GeoUtil {
	private static final Integer SRID = 4674;
	private static final Integer PRECISION = 20;

	public static Geometry toGeometry(String geoJson) {
		try {
			GeometryJSON gjson = new GeometryJSON(PRECISION);
			Geometry geometry;
			geometry = gjson.read(geoJson);
			geometry.setSRID(SRID);
			
			return geometry;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toGeoJson(Geometry geometry){
		GeometryJSON gjson = new GeometryJSON(PRECISION);
		return gjson.toString(geometry);
	}
	
	public static Double calcAreaInMeters(Geometry geometry) {
		if(geometry.isEmpty())
			return null;
		
		Point centroid = geometry.getCentroid();
	    try {

	    	CoordinateReferenceSystem sourceCRS = CRS.decode("AUTO2:42004,"+centroid.getX()+","+centroid.getY());
			
			MathTransform transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, sourceCRS);
	        Geometry projed = JTS.transform(geometry, transform);
	        return projed.getArea();
	    }catch (Exception e) {

	    	e.printStackTrace();
		}
	    return 0d;

	      
	}
	
}
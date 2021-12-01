package com.ifood.spatial.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifood.spatial.service.model.GeometryDemo;

@Repository
public interface GeometryDemoRepository extends JpaRepository<GeometryDemo, Long>{

}

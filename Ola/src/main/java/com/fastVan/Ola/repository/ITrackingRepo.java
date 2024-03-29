package com.fastVan.Ola.repository;

import com.fastVan.Ola.model.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrackingRepo extends JpaRepository<TrackingInfo,Integer> {
}

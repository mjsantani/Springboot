package com.example.vehicle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStatRepository extends JpaRepository<VehicleStat, Long>{

}

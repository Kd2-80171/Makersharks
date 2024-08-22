package com.app.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.ManufacturingProcess;
import com.app.entity.NatureOfBusiness;
import com.app.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	@Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.natureOfBusiness = :natureOfBusiness AND :manufacturingProcess MEMBER OF s.manufacturingProcesses")
	Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcess(@Param("location") String location,
			@Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
			@Param("manufacturingProcess") ManufacturingProcess manufacturingProcess, Pageable pageable);
}
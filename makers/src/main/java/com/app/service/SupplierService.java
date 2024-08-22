package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.entity.ManufacturingProcess;
import com.app.entity.NatureOfBusiness;
import com.app.entity.Supplier;
import com.app.repo.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public Page<Supplier> searchSuppliers(String location, NatureOfBusiness natureOfBusiness,
			ManufacturingProcess manufacturingProcess, Pageable pageable) {
		return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcess(location, natureOfBusiness,
				manufacturingProcess, pageable);
	}
	
//	public Supplier saveSupplier(Supplier supplier) {
//	    return supplierRepository.save(supplier);
//	}

}
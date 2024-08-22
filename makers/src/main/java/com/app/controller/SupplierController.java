package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.ManufacturingProcess;
import com.app.entity.NatureOfBusiness;
import com.app.entity.Supplier;
import com.app.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/query")
	public Page<Supplier> querySuppliers(@RequestParam String location, @RequestParam NatureOfBusiness natureOfBusiness,
			@RequestParam ManufacturingProcess manufacturingProcess, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcess,
				PageRequest.of(page, size));
	}

//	@PostMapping("/add")
//	public Supplier addSupplier(@RequestBody @Valid Supplier supplier) {
//		return supplierService.saveSupplier(supplier);
//	}

}
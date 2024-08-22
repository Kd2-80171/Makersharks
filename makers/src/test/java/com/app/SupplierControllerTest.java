package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.app.controller.SupplierController;
import com.app.entity.ManufacturingProcess;
import com.app.entity.NatureOfBusiness;
import com.app.service.SupplierService;

@SpringBootTest
public class SupplierControllerTest {

	@Mock
	private SupplierService supplierService;

	@InjectMocks
	private SupplierController supplierController;

	@Test
	public void testQuerySuppliers() {
		when(supplierService.searchSuppliers("India", NatureOfBusiness.SMALL_SCALE,
				ManufacturingProcess.THREE_D_PRINTING, PageRequest.of(0, 10)))
				.thenReturn(new PageImpl<>(Collections.emptyList()));

		Page<?> result = supplierController.querySuppliers("India", NatureOfBusiness.SMALL_SCALE,
				ManufacturingProcess.THREE_D_PRINTING, 0, 10);

		assertEquals(0, result.getTotalElements());
	}
}

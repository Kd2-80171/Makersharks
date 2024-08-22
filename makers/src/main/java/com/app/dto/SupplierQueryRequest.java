package com.app.dto;

import com.app.entity.ManufacturingProcess;
import com.app.entity.NatureOfBusiness;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupplierQueryRequest {

    @NotEmpty
    private String location;

    @NotNull
    private NatureOfBusiness natureOfBusiness;

    @NotNull
    private ManufacturingProcess manufacturingProcess;

    private int page = 0; // default page number
    private int size = 10; // default page size
}
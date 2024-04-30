package com.jdc.payroll.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.payroll.master.input.LeaveTypeForm;
import com.jdc.payroll.master.input.LeaveTypeSearch;
import com.jdc.payroll.master.output.LeaveTypeInfo;
import com.jdc.payroll.master.service.LeaveTypeService;
import com.jdc.payroll.utils.response.ApiResponse;
import com.jdc.payroll.utils.response.DataModificationResult;

@RestController
@RequestMapping("leave-type")
public class LeaveTypeApi {
	
	@Autowired
	private LeaveTypeService service;

	@GetMapping
	ApiResponse<List<LeaveTypeInfo>> search(LeaveTypeSearch search) {
		return ApiResponse.success(service.search(search));
	}
	
	@GetMapping("{id}")
	ApiResponse<LeaveTypeInfo> findById(@PathVariable int id) {
		return ApiResponse.success(service.findById(id));
	}
	
	@PostMapping
	ApiResponse<DataModificationResult<Integer>> create(
			@Validated @RequestBody LeaveTypeForm form, BindingResult result) {
		return ApiResponse.success(service.create(form));
	}	

	@PutMapping("{id}")
	ApiResponse<DataModificationResult<Integer>> update(@PathVariable int id, 
			@Validated @RequestBody LeaveTypeForm form, BindingResult result) {
		return ApiResponse.success(service.update(id, form));
	}	
}

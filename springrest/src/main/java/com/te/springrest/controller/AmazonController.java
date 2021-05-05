package com.te.springrest.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springrest.beans.AmazonResponce;
import com.te.springrest.beans.Items_info;
import com.te.springrest.service.AmazonService;

@RestController
public class AmazonController {
	@Autowired
	private AmazonService service;
	
	

	@GetMapping(path = "/getEmp",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public AmazonResponce getEmpData(int id) {

		AmazonResponce response = new AmazonResponce();
		Items_info infoBean = service.getData(10);

		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}// end of getEmpData
	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AmazonResponce addEmpData(@RequestBody Items_info infoBean) {
		AmazonResponce response = new AmazonResponce();

		if (service.addItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}// end of addEmp

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AmazonResponce updateEmpData(@RequestBody Items_info infoBean) {
		AmazonResponce response = new AmazonResponce();

		if (service.updateItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public AmazonResponce deleteEmpData(@PathVariable(name = "Id")int id ) {
		AmazonResponce response = new AmazonResponce();

		if (service.removeItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}
}

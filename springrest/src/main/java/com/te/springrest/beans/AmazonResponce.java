package com.te.springrest.beans;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmazonResponce implements Serializable {

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("Items_info")
	@XmlElement(name = "Items_info")
	private Items_info bean;
	
	
	private List<Items_info> items_infos;


	public List<Items_info> getItems_infos() {
		return items_infos;
	}


	public void setItems_infos(List<Items_info> items_infos) {
		this.items_infos = items_infos;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Items_info getBean() {
		return bean;
	}


	public void setBean(Items_info bean) {
		this.bean = bean;
	}


	
	

}

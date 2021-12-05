package com.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllBooks implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Object> listObject = new ArrayList<>();

	public AllBooks(List<Object> listObject) {
		super();
		this.listObject = listObject;
	}

	public List<Object> getListObject() {
		return listObject;
	}

	public void setListObject(List<Object> listObject) {
		this.listObject = listObject;
	}

}

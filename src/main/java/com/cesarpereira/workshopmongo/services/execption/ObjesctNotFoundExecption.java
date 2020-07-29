package com.cesarpereira.workshopmongo.services.execption;

public class ObjesctNotFoundExecption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjesctNotFoundExecption (String msg) {
		super(msg);
	}
	
	
	
}

package com.cesarpereira.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cesarpereira.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User cesar = new User("1", "Cesar", "cesar.pereiram@gmail.com");
		User francine = new User("2", "Francine", "xxx.pereiram@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(cesar, francine));
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
}

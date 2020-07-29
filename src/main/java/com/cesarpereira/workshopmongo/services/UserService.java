package com.cesarpereira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesarpereira.workshopmongo.domain.User;
import com.cesarpereira.workshopmongo.dto.UserDTO;
import com.cesarpereira.workshopmongo.repository.UserRepository;
import com.cesarpereira.workshopmongo.services.execption.ObjesctNotFoundExecption;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjesctNotFoundExecption("Objeto não encontrado"));
		}
	
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}

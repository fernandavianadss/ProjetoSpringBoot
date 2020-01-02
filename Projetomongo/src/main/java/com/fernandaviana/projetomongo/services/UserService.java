package com.fernandaviana.projetomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandaviana.projetomongo.domain.User;
import com.fernandaviana.projetomongo.dto.UserDTO;
import com.fernandaviana.projetomongo.interfaces.UserRepository;
import com.fernandaviana.projetomongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setName(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getEmail(), objDto.getName());
	}
	
	
}

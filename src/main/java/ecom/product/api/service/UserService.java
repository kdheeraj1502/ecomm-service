package ecom.product.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ecom.product.api.model.User;

@Service
public interface UserService {
	
	public User save(User user);
	public void deleteById(long id);
	public Optional<User> findById(long id);
	public List<User> findAll();
}

package ecom.product.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecom.product.api.model.User;
import ecom.product.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private List<User> userList;
	
	@Autowired
	private User user;
	
	UserServiceImpl(){
		userList.add(user);
	}

	@Override	
	public void deleteById(long id) {
		userList.stream().filter(u -> {
			if(u.getUserId() == id) {
				userList.remove(u);
				return true;
			}
			return false;
		}).close();
	}
	@Override
	public Optional<User> findById(long id) {
		Optional<User> user = Optional.of(userList.stream().filter(u -> {
			if(u.getUserId() == id) {
				return true;
			}
			else
				return false;
		}).collect(Collectors.toList()).get(0));
		return user;
	}

	public List<User> findAll() {
		return userList;
	}

	@Override
	public User save(User user) {
		userList.add(user);
		return user;
	}

}

package ecom.product.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecom.product.api.model.User;
import ecom.product.api.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserServiceImpl userService;
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
    	User inserted = userService.save(user);
        return ResponseEntity.ok(inserted);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
    	User updated = userService.save(user);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/find")
    public ResponseEntity<String> findAll() {
        //return ResponseEntity.ok(userService.findAll());
    	return ResponseEntity.ok("found");
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
    	Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
    	userService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}

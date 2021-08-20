package com.alder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alder.model.User;
import com.alder.repository.UserRespository;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AppController {
	
	private UserRespository userRespository;
	
	@Autowired
	public AppController(UserRespository userRespository) {
		super();
		this.userRespository = userRespository;
	}

	@RequestMapping(value = "submitUserDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void submitUserDetails(@RequestBody User user) {
		this.userRespository.save(user);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<User>> login(@RequestBody User user) {
		Optional<User> user2 = this.userRespository.findById(user.getEmail());
		if (user2.isPresent()) {
			if (user2.get().getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>(user2, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "findUserByEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<User>> findUser(@RequestParam String email) {
		return new ResponseEntity<>(this.userRespository.findById(email), HttpStatus.OK);
	}
}
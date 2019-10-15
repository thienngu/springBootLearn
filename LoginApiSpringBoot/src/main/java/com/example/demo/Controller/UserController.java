package com.example.demo.Controller;


import com.example.demo.exception.AppException;


import com.example.demo.model.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.JwtAuthenticationResponse;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.SignUpRequest;
import com.example.demo.payload.UserSummary;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.UserPrincipal;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;


	@RestController
	@RequestMapping("/api")
	public class UserController {

	    @Autowired
	    private UserRepository userRepository;

	    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

	    @GetMapping("/user/me")
	   
	    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
	        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getEmail());
	        return userSummary;
	    }
		
		  @GetMapping("/users/{username}")
	    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
	        User user = userRepository.findByUsername(username)
	                .orElseThrow(new ResourceNotFoundException("User", "username", username));

	       

	        UserProfile userProfile = new UserProfile(user.getUsername(), user.getEmail());

	        return userProfile;
	    }
}

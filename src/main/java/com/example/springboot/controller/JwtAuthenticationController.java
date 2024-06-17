/*
package com.example.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.config.JwtTokenUtil;
import com.example.springboot.dto.ResponseVo;
import com.example.springboot.dto.UserDTO;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.model.JwtRequest;
import com.example.springboot.model.JwtResponse;
import com.example.springboot.model.User;
import com.example.springboot.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private EmployeeMapper mapper;

	//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO user) throws Exception {
		User existingUser = userDetailsService.findByUsername(user.getUsername());
		if(existingUser != null && existingUser.getId() >0) {
			ResponseVo vo = mapper.mapUser(existingUser, ResponseVo.class);
			if(vo != null && vo.getId()>0)
				vo.setMessage(" User Already Exists, Choose Some Other User Name");
			return ResponseEntity.ok(vo);
		}else {
			User createdUser = userDetailsService.save(user);
			if(createdUser != null && createdUser.getId()>0) {
				ResponseVo vo = mapper.mapUser(createdUser, ResponseVo.class);
				vo.setMessage(" User Created Successfully");
				return ResponseEntity.ok(vo);
			}
		}
		return null;
		
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}*/

package com.IntiFotmation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IntiFotmation.config.AuthentificationRequest;
import com.IntiFotmation.config.AuthentificationResponse;
import com.IntiFotmation.config.jwtUtil;
import com.IntiFotmation.service.CustemUserDetailService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class jwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private CustemUserDetailService custemUserDetailsService;
	
	
	@Autowired
	private jwtUtil jwtokenUtil;

	@GetMapping("/test")
	public String test()
	{
		return "Bonjour";
	}
	
	@RequestMapping(value="/authenticate" ,method =RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		
		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}

}

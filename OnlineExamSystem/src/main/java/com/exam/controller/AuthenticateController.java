package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.config.JwtUtils;
import com.exam.service.UserDetailsServiceImpl;
import com.lti.Auth.JwtRequest;
import com.lti.Auth.JwtResponse;

@RestController
@CrossOrigin (origins = "*" , exposedHeaders = "**")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception{
		try {
			authenticate(jwtrequest.getUsername(), jwtrequest.getPassword());
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not Found");
		} 
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtrequest.getUsername());
		String token = jwtUtils.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

//	private void authenticate(String username, String password) throws Exception {
//		try {
//			
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//			
//		} catch (DisabledException e) {
//			throw new Exception("User Disabled");
//		} catch (BadCredentialsException e) {
//			throw new Exception("Invalid Creds");
//		}
//	}
	private void authenticate(String username, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }
    }
}

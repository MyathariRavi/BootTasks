package com.tasks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.mailservice.MailService;
import com.tasks.pojos.AuthRequest;
import com.tasks.pojos.AuthResponse;
import com.tasks.pojos.CustomerErrorType;
import com.tasks.pojos.User;
import com.tasks.security.JwtUtil;
import com.tasks.services.MyUserDetailsService;
import com.tasks.services.UserService;

@RestController
public class AppResource {

	@Autowired
	private AuthenticationManager auth;
	@Autowired
	private MyUserDetailsService usd;
	@Autowired
	private UserService userv;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private MailService mailService;
	
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello >>>>>>>>>  HOME ..  <<<<<<<<<<<";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authReq) throws Exception {
		System.out.println("In Authenticate API....");
		try {
			auth.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
			final UserDetails userDetails = usd.loadUserByUsername(authReq.getUsername());

			final String jwt = jwtUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AuthResponse(jwt));
		} catch (Exception ex) {
//			throw new Exception("Incorrect UserName OR Password...");
			return new ResponseEntity<>(new CustomerErrorType(" Cridentials Not Matched..."), HttpStatus.NOT_FOUND);

		}

	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<?> sendMail(@RequestBody String mail){
		try {
			mailService.sendMail(mail);
			return new ResponseEntity<>(HttpStatus.GONE);
			
			
		}catch(Exception ex) {
			return new ResponseEntity<>(new CustomerErrorType(ex.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllUserByMailDesc")
	public ResponseEntity<?> getAllUsersByMail(){
		try {
			List<User> userList = userv.getAllOrderedDescendingByMail();
				return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
			
		}catch(Exception ex) {
			return new ResponseEntity<>(new CustomerErrorType(ex.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
}

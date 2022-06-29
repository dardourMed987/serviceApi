package com.IntiFotmation.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IntiFotmation.entity.AuthentificationOK;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthntificationOkController {
	
	@GetMapping("/basicAuth")
	public AuthentificationOK afficher()
	{
		return new AuthentificationOK ("vous etes connecte");
	}

}

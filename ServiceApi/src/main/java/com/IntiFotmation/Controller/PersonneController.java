package com.IntiFotmation.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.IntiFotmation.entity.Personne;
import com.IntiFotmation.service.IpersonneService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {
	
	@Autowired
	IpersonneService personneService;
	
	@GetMapping("/personnes")
	public List<Personne> cherchertt()
	{
		List<Personne> liste= personneService.cherchertt();
		return liste;
	}
	
	@GetMapping("/personnes/{id}")
	public Personne chercherun(@PathVariable("id") int id)
	{
		Personne p= personneService.chercherUn(id);
		return p;
	}
	
	@PostMapping("/personnes")
	public void inserer(@RequestBody Personne p)
	{
		personneService.Ajouter(p);
	}
	
	
	@DeleteMapping("/personnes/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		personneService.delete(id);
	}
	
	
	@PutMapping("/personnes")
	public void modifier(@RequestBody Personne p)
	{
		personneService.Ajouter(p);
	}
	@PostMapping("/uploadFile")
	public String fileUpload(@RequestParam("nom") String nom,@RequestParam("file") MultipartFile file,HttpSession session) throws IOException{
		System.out.println(nom);
		String path=session.getServletContext().getRealPath("/");  
		String filename= file.getOriginalFilename();
		System.out.println(nom);
		
		
		try{  
	        byte barr[]=file.getBytes();  
	        System.out.println(file.getSize());
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e){
	        	e.printStackTrace();
	        	} 
		
		return "The File Uploaded Successfully";
	}
	
	

}

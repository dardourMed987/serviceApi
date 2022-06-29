package com.IntiFotmation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFotmation.entity.Utilisateur;



@Service
public class UtilisateurService implements IUtilisateurService {
	
	
	@Autowired
	com.IntiFotmation.dao.IUilisateurDao utilisateurDao;
	
	public Utilisateur chercherParUsername(String username)
	{
		return utilisateurDao.findByUsername(username);
	}

}

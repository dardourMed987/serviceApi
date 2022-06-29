package com.IntiFotmation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntiFotmation.entity.Utilisateur;



public interface IUilisateurDao extends JpaRepository<Utilisateur, Integer> {
	
	public Utilisateur findByUsername(String username);

}

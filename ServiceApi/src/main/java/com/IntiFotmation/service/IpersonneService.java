package com.IntiFotmation.service;

import java.util.List;

import com.IntiFotmation.entity.Personne;



public interface IpersonneService {
	
	public void Ajouter(Personne p);
	public List<Personne> cherchertt();
	public Personne chercherUn(int id);
	public void modifier(Personne p);
	public void delete(int id);

	

}

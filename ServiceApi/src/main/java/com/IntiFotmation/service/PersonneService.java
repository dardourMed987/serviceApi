package com.IntiFotmation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFotmation.dao.IpersonneDao;
import com.IntiFotmation.entity.Personne;



@Service
public class PersonneService implements  IpersonneService {
	
	@Autowired
	IpersonneDao pDao;
	

	public void Ajouter(Personne p)
	{
		pDao.save(p);
	}
	
	public List<Personne> cherchertt()
	{
		return pDao.findAll();
	}
	
	public Personne chercherUn(int id)
	{
		return pDao.findById(id).get();
	}
	
	public void modifier(Personne p)
	{
		pDao.save(p);
	}
	
	public void delete(int id)
	{
		pDao.deleteById(id);
	}
	

	
	
	

}

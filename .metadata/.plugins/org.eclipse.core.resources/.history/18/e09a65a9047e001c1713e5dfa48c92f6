package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;

public interface IMemberService {
	// Crud sur les membres
	public Member addMember(Member m);

	public void deleteMember(Long id);

	public Member updateMember(Member p);

	public Member findMember(Long id);

	public List<Member> findAll();

	// Filtrage par propriété
	public Member findByCin(String cin);

	public Member findByEmail(String email);

	public List<Member> findByNom(String nom);
	
	public List<Etudiant> findAllEtudiant();
	
	public List<EnseignantChercheur> findAllEnseignants();

	// recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);

	public Etudiant affecterencadrantToetudiant(Long idetd, Long idens);

	public List<Etudiant> findEtudiantsByEncadrant(Long idens);

	public void affecterauteurTopublication(Long idauteur, Long idpub);

	public List<PublicationBean> findPublicationparauteur(Long idauteur);

	public void affecterMemberToEvent(Long idMember, Long idEvent);

	public List<EvenementBean> findEventByMember(Long memberId);

	public void affecterMemberToOutil(Long idMember, Long idOutil);

	public List<OutilBean> findOutilByMember(Long memberId);
	
	public void addPhotoToMember(Long memberIdLong,  MultipartFile photo) throws IOException;

	void desaffecterMembreDeOutil(Long idMemer, Long idOutil);
	

}

package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.beans.EvenementBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberEventRepository;
import com.example.demo.dao.MemberOutilRepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.dao.Membrepubrepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.entities.Member_Event;
import com.example.demo.entities.Member_Outil;
import com.example.demo.entities.Member_Outil_Ids;
import com.example.demo.entities.Membre_Event_Ids;
import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;

@Service
public class MembreServiceImpl implements IMemberService {

	@Autowired
	MembreRepository membreRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantRepository enseignantRepository;
	@Autowired
	Membrepubrepository membrepubrepository;
	@Autowired
	MemberEventRepository membreEventrepository;
	@Autowired
	MemberOutilRepository membreOutilrepository;
	@Autowired
	PublicationProxyService publicationProxyService;
	@Autowired
	EvenementProxyService evenementProxyService;
	@Autowired
	OutilProxyService outilProxyService;

	public Member addMember(Member m) {
		return membreRepository.save(m);
	}

	public void deleteMember(Long id) {
		if (membreRepository.findById(id).isPresent())
			membreRepository.deleteById(id);
	}

	public Member updateMember(Member p) {
		return membreRepository.saveAndFlush(p);
	}

	public Member findMember(Long id) {
		return membreRepository.findById(id).get();
	}

	public List<Member> findAll() {
		return membreRepository.findAll();
	}

	public Member findByCin(String cin) {

		return membreRepository.findByCin(cin);
	}

	public Member findByEmail(String email) {

		return membreRepository.findByEmail(email);
	}

	public List<Member> findByNom(String nom) {

		return membreRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {

		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {

		return enseignantRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {

		return enseignantRepository.findByEtablissement(etablissement);
	}

	@Override
	public Etudiant affecterencadrantToetudiant(Long idetd, Long idens) {
		Etudiant etd = etudiantRepository.findById(idetd).get();
		EnseignantChercheur ens = enseignantRepository.findById(idens).get();
		etd.setEncadrant(ens);
		return etudiantRepository.save(etd);
	}

	@Override
	public List<Etudiant> findEtudiantsByEncadrant(Long idens) {

		EnseignantChercheur ens = enseignantRepository.findById(idens).get();

		return etudiantRepository.findByEncadrant(ens);
	}
	
	

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Member mbr = membreRepository.findById(idauteur).get();
		Membre_Publication mbs = new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpub, idauteur));
		membrepubrepository.save(mbs);
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs = new ArrayList<PublicationBean>();
		List<Membre_Publication> idpubs = membrepubrepository.findpubId(idauteur);
		idpubs.forEach(s ->
		pubs.add(publicationProxyService.findPublicationById(s.getId().getPublication_id())));
		return pubs;
	}

	@Override
	public void affecterMemberToEvent(Long idMember, Long idEvent) {
		Member mbr = membreRepository.findById(idMember).get();
		Member_Event mbs = new Member_Event();
		mbs.setMember(mbr);
		mbs.setId(new Membre_Event_Ids(idEvent, idMember));
		membreEventrepository.save(mbs);	
	}

	@Override
	public List<EvenementBean> findEventByMember(Long memberId) {
		List<EvenementBean> pubs = new ArrayList<EvenementBean>();
		List<Member_Event> idpubs = membreEventrepository.findEventId(memberId);
		idpubs.forEach(s ->
		pubs.add(evenementProxyService.findEventById(s.getId().getEventId())));
		return pubs;
	}

	@Override
	public void affecterMemberToOutil(Long idMember, Long idOutil) {
		Member mbr = membreRepository.findById(idMember).get();
		Member_Outil mbs = new Member_Outil();
		mbs.setMember(mbr);
		mbs.setId(new Member_Outil_Ids(idOutil, idMember));
		membreOutilrepository.save(mbs);			
	}

	@Override
	public List<OutilBean> findOutilByMember(Long memberId) {
		List<OutilBean> pubs = new ArrayList<OutilBean>();
		List<Member_Outil> idpubs = membreOutilrepository.findOutilId(memberId);
		idpubs.forEach(s -> 
			pubs.add(outilProxyService.findOutilById(s.getId().getOutil_id()))
		);
		return pubs;
	}
	
	

	@Override
	public List<Etudiant> findAllEtudiant() {
		return etudiantRepository.findAll();
	}

	@Override
	public List<EnseignantChercheur> findAllEnseignants() {
		return enseignantRepository.findAll();
	}

	@Override
	public void addPhotoToMember(Long memberId, MultipartFile photo) throws IOException {
		Member mbr = membreRepository.findById(memberId).get();
		System.out.println("Original Image Byte Size - " + photo.getBytes().length);
		mbr.setPhoto(photo.getBytes());
		//System.out.println(photo.length);
		membreRepository.save(mbr);	
	}

	@Override
	public void desaffecterMembreDeOutil(Long idOutil) {
		membreOutilrepository.desaffecterMembreDeOutil(idOutil);		
	}

	@Override
	public void desaffecterMembreDePub(Long idPub) {
		membrepubrepository.desaffecterMembreDePub(idPub);
		
	}

	@Override
	public void desaffecterMembreDeEvent(Long idEvent) {
		membreEventrepository.desaffecterMembreDeEvent(idEvent);		
	}
	
	
}

package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.List;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {

		SecteurActivite set = new SecteurActivite();
		set.setCodeSecteurActivite(sa.getCodeSecteurActivite());
		set.setLibelleSecteurActivite(sa.getLibelleSecteurActivite());
        return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		
		return secteurActiviteRepository.findById(id).orElse(null);
	}


}

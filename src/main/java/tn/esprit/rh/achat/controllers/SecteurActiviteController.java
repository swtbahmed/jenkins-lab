package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.Dto.DTOSecteurActivite;
import tn.esprit.rh.achat.Dto.DTOStock;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.List;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();
	}

	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurActivite addSecteurActivite(@RequestBody DTOSecteurActivite s) {
		SecteurActivite stact= new SecteurActivite(s.getCodeSecteurActivite(),s.getLibelleSecteurActivite(),s.getFournisseurs());
		return secteurActiviteService.addSecteurActivite(stact);
	}

	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurActivite modifySecteurActivite(@RequestBody DTOSecteurActivite s) {
		SecteurActivite stact= new SecteurActivite(s.getCodeSecteurActivite(),s.getLibelleSecteurActivite(),s.getFournisseurs());
		return secteurActiviteService.updateSecteurActivite(stact);
	}
	
}

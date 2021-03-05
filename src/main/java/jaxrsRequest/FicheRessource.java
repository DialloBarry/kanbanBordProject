package jaxrsRequest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import DAO.DaoFiches;
import domainKanban.Fiche;
import domainKanban.User;

@Path("api")
public class FicheRessource {
	DaoFiches daoFiche = new DaoFiches() ;

	public FicheRessource() {
		
	}
	public FicheRessource(DaoFiches daoFiche) {
		super();
		
		this.daoFiche = daoFiche;
	}

	@GET
	@Path("/fiche")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fiche> getFicheAllFiches() {
		
	return  this.daoFiche.getAllFiches();
	}

	@GET
	@Path("/fiche/{ficheId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fiche getFicheByID(@PathParam(value="ficheId") long ficheId) {
		System.out.println("ficheId : "+ficheId);
		Fiche f = daoFiche.getFicheByID(ficheId);
		System.out.println("f : "+f);
		return f;

	}
	

	
	@GET
	@Path("/fiches/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Fiche> getFicheByUser(@PathParam("name") String name) {

		return this.daoFiche.finFicheByUserName(name);

	}


	
	@POST
	@Path("/fiches")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postFiche(Fiche fiche){
		daoFiche.saveFiche(fiche);	
	}

	
	@DELETE
	@Path("/fich/{idFiche}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFiche(@PathParam(value = "idFiche") long idFiche){
		System.out.println("*************"+idFiche);
		daoFiche.deleteFiche(idFiche);	
	}

}

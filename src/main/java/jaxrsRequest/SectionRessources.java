package jaxrsRequest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.DaoSection;
import domainKanban.Section;

@Path("api")
public class SectionRessources {
	DaoSection daoSection=new DaoSection();
	public SectionRessources() {
	}
	
	public SectionRessources(DaoSection daoSection) {
		this.daoSection=daoSection;
	}
	
	@GET
	@Path("/section/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Section> getAllSessions(){
		List<Section> sections= this.daoSection.getAllSessions();
		return sections;
		
	}
	
	@GET
	@Path("/section/{idSection}")
	@Produces(MediaType.APPLICATION_JSON)
	public Section getSection(@PathParam(value = "idSection") long idSection){
	return this.daoSection.getSectionByID(idSection);
		
	}
	
	@POST
	@Path("/section")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postSession(Section section){
		daoSection.saveSession(section);	
	}
	
	@DELETE
	@Path("/sectionD/{idSection}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFiche(@PathParam(value = "idSection") long idSection){
		System.out.println("*************"+idSection);
		daoSection.deleteSection(idSection);	
	}

}

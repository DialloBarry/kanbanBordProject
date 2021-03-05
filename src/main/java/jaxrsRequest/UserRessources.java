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

import DAO.DaoUser;
import domainKanban.User;

@Path("api")
public class UserRessources {
	DaoUser daouser= new DaoUser();
	
	
	public UserRessources(DaoUser daouser) {
		this.daouser=daouser;
	}
	public UserRessources() {
	}
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void postUsers(User user){
		daouser.saveUser(user);	
	}
	
	@GET
	@Path("/user/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllusers(){
	return this.daouser.getAllUser();
	}

	@GET
	@Path("/user/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam(value="idUser") long idUser){
		return this.daouser.getUserByID(idUser);
	}
	
	
	@DELETE
	@Path("/userD/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFiche(@PathParam(value = "id") long id){
		System.out.println("*************"+id);
		daouser.deleteUser(id);	
	}
	


}

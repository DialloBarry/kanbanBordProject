package serviceRest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoFiches;
import domainKanban.Fiche;

@WebServlet(name="userinfodb",
urlPatterns={"/UserInfoDB"})
public class UserInfoDB extends HttpServlet {
	DaoFiches fiche= new DaoFiches();
	private EntityManager manager;
	public UserInfoDB() {	}
	
	public UserInfoDB(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	@Override
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		
		
		Fiche ficheDB = new Fiche();
		Date date= format.parse(request.getParameter("date"),new ParsePosition(0));
		ficheDB.setDateButoire( date);
		ficheDB.setLibelle(request.getParameter("libelle"));
		ficheDB.setLieu(request.getParameter("lieu"));
		ficheDB.setNote(request.getParameter("note"));
		ficheDB.setUrl(request.getParameter("url"));
		fiche.saveFiche(ficheDB);
		PrintWriter out = response.getWriter();


		out.println("<HTML>\n<BODY>\n" +
				"<H1>  Informations enregistrees</H1>\n" +
//				"<UL>\n" +			
//				" <LI>Nom: "
//				+ request.getParameter("name") + "\n" +
//				" <LI>Prenom: "
//				+ request.getParameter("firstname") + "\n" +
//				" <LI>Age: "
//				+ request.getParameter("age") + "\n" +
//				"</UL>\n" +				
				"</BODY></HTML>");
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) 	throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		List<Fiche> myFiches = fiche.getAllFiches();
		String fichesInfos = "";
		for(Fiche fich : myFiches) {
			fichesInfos += " <LI>Libellé: "
			+ fich.getLibelle() + "\n" +
			" <LI>Lieu: "
			+ fich.getLieu() + "\n" +
			" <LI>Url: "
			+ fich.getUrl() + "\n" ;
		}
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n" +			
					fichesInfos +
		         "</UL>\n" +				
				"</BODY></HTML>");
	}

}

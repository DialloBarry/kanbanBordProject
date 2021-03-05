package domainKanban;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Section {
	
	Long id ;
	private List<Fiche> fiche = new ArrayList<Fiche>();
	private String status;
	public Section() {
		
	}
	
	
	public Section(List<Fiche> fiche, String status) {
		super();
		this.fiche = fiche;
		this.status=status;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "section",cascade = CascadeType.PERSIST)
	public List<Fiche> getFiche() {
		return fiche;
	}


	public void setFiche(List<Fiche> fiche) {
		this.fiche = fiche;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}

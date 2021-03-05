package domainKanban;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NamedQueries({
    @NamedQuery(name="touteslesfichesparnom",
    query = "select f from Fiche as f where f.user.name= :name")
})
@Entity
@Table(name="Fiches")
public class Fiche {
	Long id;
	private String libelle;
	private Date dateButoire;
	private Long tempsEstime;
	private User user;
	private List<String>  tag = new ArrayList<String>();
	private String lieu ;
	private String url ;
	private String note ;
	private Section section;
	
	public Fiche() {
		
	}
	
		
	public Fiche(Long id, String libelle, Date dateButoire, User user, List<String> tag, String lieu, String url, String note, Section section) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.dateButoire = dateButoire;
		this.user = user;
		this.tag = tag;
		this.lieu = lieu;
		this.url = url;
		this.note = note;
		this.section=section;
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getTempsEstime() {
		return tempsEstime;
	}


	public void setTempsEstime(Long tempsEstime) {
		this.tempsEstime = tempsEstime;
	}


	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateButoire() {
		return dateButoire;
	}
	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}
	
	@JsonIgnoreProperties("fiche")
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public String getLieu() {
		return lieu;
	}
	@ElementCollection
    @CollectionTable(name = "fiche_tag")
    @OrderColumn
	public List<String> getTag() {
		return tag;
	}


	public void setTag(List<String> tag) {
		this.tag = tag;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@ManyToOne
	@JsonIgnoreProperties("fiche")
	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}
	

}
 
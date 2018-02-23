/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zerguine
 */
@Entity
@Table(name = "savetweet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Savetweet.findAll", query = "SELECT s FROM Savetweet s")
    , @NamedQuery(name = "Savetweet.findByIdtweet", query = "SELECT s FROM Savetweet s WHERE s.idtweet = :idtweet")
    , @NamedQuery(name = "Savetweet.findByDatecreation", query = "SELECT s FROM Savetweet s WHERE s.datecreation = :datecreation")
    , @NamedQuery(name = "Savetweet.findByTweetcomplet", query = "SELECT s FROM Savetweet s WHERE s.tweetcomplet = :tweetcomplet")
    , @NamedQuery(name = "Savetweet.findByTweetnettoyer", query = "SELECT s FROM Savetweet s WHERE s.tweetnettoyer = :tweetnettoyer")
    , @NamedQuery(name = "Savetweet.findByRt", query = "SELECT s FROM Savetweet s WHERE s.rt = :rt")
    , @NamedQuery(name = "Savetweet.findByLocation", query = "SELECT s FROM Savetweet s WHERE s.location = :location")
    , @NamedQuery(name = "Savetweet.findByCategorie", query = "SELECT s FROM Savetweet s WHERE s.categorie = :categorie")
    , @NamedQuery(name = "Savetweet.findByOpinion", query = "SELECT s FROM Savetweet s WHERE s.opinion = :opinion")
    , @NamedQuery(name = "Savetweet.findByIduser", query = "SELECT s FROM Savetweet s WHERE s.iduser = :iduser")})
public class Savetweet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtweet")
    private String idtweet;
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Column(name = "tweetcomplet")
    private String tweetcomplet;
    @Column(name = "tweetnettoyer")
    private String tweetnettoyer;
    @Column(name = "rt")
    private String rt;
    @Column(name = "location")
    private String location;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "opinion")
    private String opinion;
    @Column(name = "iduser")
    private String iduser;

    public Savetweet() {
    }

    public Savetweet(String idtweet) {
        this.idtweet = idtweet;
    }

    public String getIdtweet() {
        return idtweet;
    }

    public void setIdtweet(String idtweet) {
        this.idtweet = idtweet;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getTweetcomplet() {
        return tweetcomplet;
    }

    public void setTweetcomplet(String tweetcomplet) {
        this.tweetcomplet = tweetcomplet;
    }

    public String getTweetnettoyer() {
        return tweetnettoyer;
    }

    public void setTweetnettoyer(String tweetnettoyer) {
        this.tweetnettoyer = tweetnettoyer;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtweet != null ? idtweet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Savetweet)) {
            return false;
        }
        Savetweet other = (Savetweet) object;
        if ((this.idtweet == null && other.idtweet != null) || (this.idtweet != null && !this.idtweet.equals(other.idtweet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnes.Savetweet[ idtweet=" + idtweet + " ]";
    }
    
}

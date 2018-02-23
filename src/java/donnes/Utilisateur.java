/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zerguine
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdutilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Utilisateur.findByProfileimgurl", query = "SELECT u FROM Utilisateur u WHERE u.profileimgurl = :profileimgurl")
    , @NamedQuery(name = "Utilisateur.findByScreenname", query = "SELECT u FROM Utilisateur u WHERE u.screenname = :screenname")
    , @NamedQuery(name = "Utilisateur.findByFullname", query = "SELECT u FROM Utilisateur u WHERE u.fullname = :fullname")
    , @NamedQuery(name = "Utilisateur.findByNbrfollowers", query = "SELECT u FROM Utilisateur u WHERE u.nbrfollowers = :nbrfollowers")
    , @NamedQuery(name = "Utilisateur.findByBio", query = "SELECT u FROM Utilisateur u WHERE u.bio = :bio")
    , @NamedQuery(name = "Utilisateur.findByLocation", query = "SELECT u FROM Utilisateur u WHERE u.location = :location")
    , @NamedQuery(name = "Utilisateur.findByCreatedat", query = "SELECT u FROM Utilisateur u WHERE u.createdat = :createdat")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idutilisateur")
    private String idutilisateur;
    @Column(name = "profileimgurl")
    private String profileimgurl;
    @Column(name = "screenname")
    private String screenname;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "nbrfollowers")
    private Integer nbrfollowers;
    @Column(name = "bio")
    private String bio;
    @Column(name = "location")
    private String location;
    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
    private Date createdat;
    @OneToMany(mappedBy = "iduser")
    private List<Tweet> tweetList;

    public Utilisateur() {
    }

    public Utilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getProfileimgurl() {
        return profileimgurl;
    }

    public void setProfileimgurl(String profileimgurl) {
        this.profileimgurl = profileimgurl;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getNbrfollowers() {
        return nbrfollowers;
    }

    public void setNbrfollowers(Integer nbrfollowers) {
        this.nbrfollowers = nbrfollowers;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    @XmlTransient
    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idutilisateur != null ? idutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idutilisateur == null && other.idutilisateur != null) || (this.idutilisateur != null && !this.idutilisateur.equals(other.idutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnes.Utilisateur[ idutilisateur=" + idutilisateur + " ]";
    }
    
}

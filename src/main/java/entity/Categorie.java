/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name = Categorie.FIND_ALL_CATEGORIE , 
                query = "select c from Categorie c "),
        @NamedQuery(name = Categorie.FIND_CATEGORIE_BY_NOME ,
                query = "select c from Categorie c WHERE c.id = :nome") , 
        @NamedQuery(name = Categorie.FIND_CATEGORIE_BY_NOME2 ,
                query = "select c from Categorie c WHERE c.nome = :nome") , 
        @NamedQuery(name = Categorie.FIND_CATEGORIE_BYUTENTE ,
                query = "select c from Categorie c where c.utente = :ut")
})




@Entity
@Table(name = "t_categorie")
public class Categorie implements Serializable{
    
    public static final String FIND_ALL_CATEGORIE = "Categorie.findAll";
    public static final String FIND_CATEGORIE_BY_NOME = "Categorie.findCatByNome";
    public static final String FIND_CATEGORIE_BY_NOME2 = "Categorie.findCatByNome2";
    public static final String FIND_CATEGORIE_BYUTENTE = "Categorie.findCatByUt";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Utenti utente;

    public Categorie() {
    }

    public Categorie( String nome, Utenti utente) {
        this.nome = nome;
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.utente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.utente, other.utente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nome=" + nome + ", utente=" + utente + '}';
    }

    
    

    

    
    
    
    
    
    
    
}

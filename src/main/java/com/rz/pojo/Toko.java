/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Programer-2
 */
@Entity
@Table(name = "TOKO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Toko.findAll", query = "SELECT t FROM Toko t"),
    @NamedQuery(name = "Toko.findByToko", query = "SELECT t FROM Toko t WHERE t.toko = :toko"),
    @NamedQuery(name = "Toko.findByNama", query = "SELECT t FROM Toko t WHERE t.nama = :nama")})
public class Toko implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOKO")
    private Short toko;
    @Size(max = 50)
    @Column(name = "NAMA")
    private String nama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toko")
    private Collection<Lokasi> lokasiCollection;

    public Toko() {
    }

    public Toko(Short toko) {
        this.toko = toko;
    }

    public Short getToko() {
        return toko;
    }

    public void setToko(Short toko) {
        this.toko = toko;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public Collection<Lokasi> getLokasiCollection() {
        return lokasiCollection;
    }

    public void setLokasiCollection(Collection<Lokasi> lokasiCollection) {
        this.lokasiCollection = lokasiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toko != null ? toko.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Toko)) {
            return false;
        }
        Toko other = (Toko) object;
        if ((this.toko == null && other.toko != null) || (this.toko != null && !this.toko.equals(other.toko))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rz.pojo.Toko[ toko=" + toko + " ]";
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.pojo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programer-2
 */
@Entity
@Table(name = "LOKASI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokasi.findAll", query = "SELECT l FROM Lokasi l"),
    @NamedQuery(name = "Lokasi.findByLokasi", query = "SELECT l FROM Lokasi l WHERE l.lokasi = :lokasi"),
    @NamedQuery(name = "Lokasi.findByNama", query = "SELECT l FROM Lokasi l WHERE l.nama = :nama")})
public class Lokasi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOKASI")
    private Short lokasi;
    @Size(max = 10)
    @Column(name = "NAMA")
    private String nama;
    @JoinColumn(name = "TOKO", referencedColumnName = "TOKO")
    @ManyToOne(optional = false)
    private Toko toko;

    public Lokasi() {
    }

    public Lokasi(Short lokasi) {
        this.lokasi = lokasi;
    }

    public Short getLokasi() {
        return lokasi;
    }

    public void setLokasi(Short lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Toko getToko() {
        return toko;
    }

    public void setToko(Toko toko) {
        this.toko = toko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lokasi != null ? lokasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lokasi)) {
            return false;
        }
        Lokasi other = (Lokasi) object;
        if ((this.lokasi == null && other.lokasi != null) || (this.lokasi != null && !this.lokasi.equals(other.lokasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rz.pojo.Lokasi[ lokasi=" + lokasi + " ]";
    }
    
}

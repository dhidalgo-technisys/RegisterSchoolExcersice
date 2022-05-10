/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.registerSchool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhidalgo
 */
@Entity
@Table(name = "register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r"),
    @NamedQuery(name = "Register.findByIdregister", query = "SELECT r FROM Register r WHERE r.idregister = :idregister"),
    @NamedQuery(name = "Register.findByPeriod", query = "SELECT r FROM Register r WHERE r.period = :period"),
    @NamedQuery(name = "Register.findByScore", query = "SELECT r FROM Register r WHERE r.score = :score"),
    @NamedQuery(name = "Register.findByDateFrom", query = "SELECT r FROM Register r WHERE r.dateFrom = :dateFrom"),
    @NamedQuery(name = "Register.findByDateTo", query = "SELECT r FROM Register r WHERE r.dateTo = :dateTo")})
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregister")
    private Integer idregister;

    @Column(name = "period")
    private String period;
   
    @Column(name = "score")
    private String score;
    @Column(name = "dateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "dateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "idCourse", referencedColumnName = "idcourse")
    @ManyToOne
    private Course idCourse;
    @JoinColumn(name = "idStudent", referencedColumnName = "idstudent")
    @ManyToOne
    private Student idStudent;

    public Register() {
    }

    public Register(Integer idregister) {
        this.idregister = idregister;
    }

    public Integer getIdregister() {
        return idregister;
    }

    public void setIdregister(Integer idregister) {
        this.idregister = idregister;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }

    public Student getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Student idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregister != null ? idregister.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.idregister == null && other.idregister != null) || (this.idregister != null && !this.idregister.equals(other.idregister))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.register.infrastructure.entity.Register[ idregister=" + idregister + " ]";
    }
    
}

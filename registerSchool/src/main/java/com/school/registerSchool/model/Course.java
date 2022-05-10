/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.registerSchool.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author dhidalgo
 */
@Entity
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByIdcourse", query = "SELECT c FROM Course c WHERE c.idcourse = :idcourse"),
    @NamedQuery(name = "Course.findByCourse", query = "SELECT c FROM Course c WHERE c.course = :course"),
    @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcourse")
    private Integer idcourse;

    @Column(name = "course")
    private String course;

    @Column(name = "description")
    private String description;
	/*
	 * @OneToMany(mappedBy = "idCourse") private List<Register> registerList;
	 */

    public Course() {
    }

    public Course(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


	/*
	 * public List<Register> getRegisterList() { return registerList; }
	 * 
	 * public void setRegisterList(List<Register> registerList) { this.registerList
	 * = registerList; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcourse != null ? idcourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.idcourse == null && other.idcourse != null) || (this.idcourse != null && !this.idcourse.equals(other.idcourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.register.infrastructure.entity.Course[ idcourse=" + idcourse + " ]";
    }
    
}

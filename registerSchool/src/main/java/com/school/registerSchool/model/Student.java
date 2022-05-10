/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.registerSchool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhidalgo
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdstudent", query = "SELECT s FROM Student s WHERE s.idstudent = :idstudent"),
    @NamedQuery(name = "Student.findByStudentNumber", query = "SELECT s FROM Student s WHERE s.studentNumber = :studentNumber")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudent")
    private Integer idstudent;

    @Column(name = "studentNumber")
    private String studentNumber;
    
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "fullname")
    private String fullname;
    
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
	/*
	 * @OneToMany(mappedBy = "idStudent") private List<Register> registerList;
	 */

    public Student() {
    }

    public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Student(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public Integer getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

   

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/*
	 * @XmlTransient public List<Register> getRegisterList() { return registerList;
	 * }
	 * 
	 * public void setRegisterList(List<Register> registerList) { this.registerList
	 * = registerList; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudent != null ? idstudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idstudent == null && other.idstudent != null) || (this.idstudent != null && !this.idstudent.equals(other.idstudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.register.infrastructure.entity.Student[ idstudent=" + idstudent + " ]";
    }
    
}

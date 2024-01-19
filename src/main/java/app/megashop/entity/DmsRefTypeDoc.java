package app.megashop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Column;


import java.util.Date;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Component
@Table(name="dms_ref_type_doc")
public class DmsRefTypeDoc extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idetypdo", nullable=false, length=12)
private int idetypdo;
@Column(name="labtypdo", nullable=true, length=60)
private String labtypdo;
@Column(name="codenatu", nullable=false, length=5)
private String codenatu;
@Column(name="disporde", nullable=false, length=3)
private int disporde;
@Column(name="flagacti", nullable=true, length=2)
private String flagacti;
@Column(name="is__defa", nullable=true, length=2)
private String is__defa;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='codenatu', forienClass='DmsRefNatureTypeDoc'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

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
@Table(name="dms_metadata_doc")
public class DmsMetadataDoc extends BasicEntity {

@Column(name="idendocu", nullable=false, length=25)
private int idendocu;
@Column(name="idetypdo", nullable=false, length=12)
private int idetypdo;
@Column(name="idenmeta", nullable=false, length=10)
private int idenmeta;
@Column(name="valemeta", nullable=true, length=400)
private String valemeta;
@Column(name="ordemeta", nullable=false, length=3)
private int ordemeta;
@Column(name="weigmeta", nullable=false, length=3)
private int weigmeta;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='idendocu', forienClass='DmsInformationDoc'}*/
/*ForeignKey{forienName='idenmeta', forienClass='DmsRefMetadata'}*/
/*ForeignKey{forienName='idetypdo', forienClass='DmsRefTypeDoc'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

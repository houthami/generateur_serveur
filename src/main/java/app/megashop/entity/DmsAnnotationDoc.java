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
@Table(name="dms_annotation_doc")
public class DmsAnnotationDoc extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idenanno", nullable=false, length=12)
private int idenanno;
@Column(name="idendocu", nullable=false, length=12)
private int idendocu;
@Column(name="codtypan", nullable=true, length=2)
private String codtypan;
@Column(name="textanno", nullable=true, length=800)
private String textanno;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='idendocu', forienClass='DmsInformationDoc'}*/
/*ForeignKey{forienName='codtypan', forienClass='DmsRefTypeAnnotation'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

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
@Table(name="dms_structure_node")
public class DmsStructureNode extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idennode", nullable=false, length=5)
private int idennode;
@Column(name="idenstru", nullable=false, length=5)
private int idenstru;
@Column(name="idenodpa", nullable=false, length=5)
private int idenodpa;
@Column(name="desinode", nullable=true, length=80)
private String desinode;
@Column(name="ordrnode", nullable=false, length=2)
private int ordrnode;
@Column(name="codtypno", nullable=false, length=1)
private String codtypno;
@Column(name="idenrefe", nullable=false, length=10)
private int idenrefe;
@Column(name="initrefe", nullable=true, length=5)
private String initrefe;
@Column(name="desirefe", nullable=true, length=60)
private String desirefe;
@Column(name="sourrefe", nullable=true, length=50)
private String sourrefe;
@Column(name="key_colu", nullable=true, length=20)
private String key_colu;
@Column(name="lablcolu", nullable=true, length=20)
private String lablcolu;
@Column(name="condwher", nullable=true, length=200)
private String condwher;
@Column(name="gardenti", nullable=false, length=1)
private int gardenti;
@Column(name="codedoma", nullable=true, length=2)
private String codedoma;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='idenstru', forienClass='DmsStructure'}*/
/*ForeignKey{forienName='idenodpa', forienClass='DmsStructureNode'}*/
/*ForeignKey{forienName='codtypno', forienClass='DmsRefTypeNode'}*/
/*ForeignKey{forienName='idenrefe', forienClass='DmsRefDynamique'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

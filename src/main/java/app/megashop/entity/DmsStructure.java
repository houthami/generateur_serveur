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
@Table(name="dms_structure")
public class DmsStructure extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idenstru", nullable=false, length=12)
private int idenstru;
@Column(name="initstru", nullable=true, length=2)
private String initstru;
@Column(name="struname", nullable=true, length=60)
private String struname;
@Column(name="descstru", nullable=true, length=600)
private String descstru;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

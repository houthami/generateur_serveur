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
@Table(name="dms_ref_dynamique")
public class DmsRefDynamique extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idenrefe", nullable=false, length=10)
private int idenrefe;
@Column(name="codedoma", nullable=true, length=2)
private String codedoma;
@Column(name="iderefpa", nullable=false, length=10)
private int iderefpa;
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
@Column(name="ordrrefe", nullable=false, length=5)
private int ordrrefe;
@Column(name="gardenti", nullable=false, length=1)
private int gardenti;
@Column(name="key_nive", nullable=true, length=100)
private String key_nive;
@Column(name="keyparni", nullable=true, length=100)
private String keyparni;
@Column(name="paranive", nullable=true, length=100)
private String paranive;
@Column(name="selecolu", nullable=true, length=100)
private String selecolu;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='codedoma', forienClass='DmsRefDomaine'}*/
/*ForeignKey{forienName='iderefpa', forienClass='DmsRefDynamique'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

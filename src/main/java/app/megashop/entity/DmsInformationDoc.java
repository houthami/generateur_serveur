package app.megashop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Column;


import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Component
@Table(name="dms_information_doc")
public class DmsInformationDoc extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idendocu", nullable=false, length=25)
private int idendocu;
@Column(name="key_node", nullable=true, length=100)
private String key_node;
@Column(name="idenstru", nullable=false, length=12)
private int idenstru;
@Column(name="extedocu", nullable=true, length=10)
private String extedocu;
@Column(name="desidocu", nullable=false, length=120)
private String desidocu;
@Column(name="sourdocu", nullable=true, length=100)
private String sourdocu;
@Column(name="authdocu", nullable=true, length=100)
private String authdocu;
@Column(name="refedocu", nullable=true, length=60)
private String refedocu;
@Column(name="receveon", nullable=false, length=1)
private Date receveon;
@Column(name="versdocu", nullable=true, length=30)
private String versdocu;
@Column(name="summdocu", nullable=true, length=4000)
private String summdocu;
@Column(name="sizedocu", nullable=false, length=20)
private int sizedocu;
@Column(name="filetype", nullable=true, length=200)
private String filetype;
@Column(name="pagecoun", nullable=false, length=6)
private int pagecoun;
@Column(name="typingon", nullable=false, length=1)
private Date typingon;
@Column(name="typingby", nullable=true, length=30)
private String typingby;
@Column(name="rank__on", nullable=false, length=1)
private Date rank__on;
@Column(name="rank__by", nullable=true, length=30)
private String rank__by;
@Column(name="tagsdocu", nullable=true, length=60)
private String tagsdocu;
@Column(name="visileve", nullable=false, length=2)
private int visileve;
@Column(name="pathdoss", nullable=true, length=300)
private String pathdoss;
@Column(name="statdocu", nullable=true, length=2)
private String statdocu;
@Column(name="datestat", nullable=false, length=1)
private Date datestat;
@Column(name="codeinte", nullable=false, length=5)
private int codeinte;
@Column(name="idenpoli", nullable=false, length=20)
private int idenpoli;
@Column(name="codeassu", nullable=false, length=12)
private int codeassu;
@Column(name="exersini", nullable=false, length=4)
private int exersini;
@Column(name="numesini", nullable=false, length=6)
private int numesini;
@Column(name="numepoli", nullable=false, length=15)
private int numepoli;
@Column(name="destdocu", nullable=true, length=100)
private String destdocu;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;
@Column(name="editedby", nullable=false, length=10)
private int editedby;
@Column(name="editedon", nullable=false, length=1)
private Date editedon;



}/*ForeignKey{forienName='idendocu', forienClass='DmsDocument'}*/
/*ForeignKey{forienName='idenstru', forienClass='DmsStructure'}*/
/*ForeignKey{forienName='createby', forienClass='OpfUser'}*/
/*ForeignKey{forienName='editedby', forienClass='OpfUser'}*/

package app.megashop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Column;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Component
@Table(name="dms_type_doc")
public class DmsTypeDoc extends BasicEntity {

@Column(name="idendocu", nullable=false, length=25)
private int idendocu;
@Column(name="idetypdo", nullable=false, length=12)
private int idetypdo;
@Column(name="typingon", nullable=false, length=1)
private Date typingon;



}/*ForeignKey{forienName='idendocu', forienClass='DmsInformationDoc'}*/
/*ForeignKey{forienName='idetypdo', forienClass='DmsRefTypeDoc'}*/

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
@Table(name="dms_operation_doc")
public class DmsOperationDoc extends BasicEntity {

@Column(name="idenoper", nullable=false, length=25)
private int idenoper;
@Column(name="idendocu", nullable=false, length=25)
private int idendocu;
@Column(name="codeoper", nullable=false, length=25)
private int codeoper;
@Column(name="ordeoper", nullable=false, length=3)
private int ordeoper;
@Column(name="createby", nullable=false, length=10)
private int createby;
@Column(name="createon", nullable=false, length=1)
private Date createon;



}/*ForeignKey{forienName='idenoper', forienClass='DmsRefOperation'}*/

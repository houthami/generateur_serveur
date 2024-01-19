package app.megashop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Component
@Table(name="dms_ref_operation")
public class DmsRefOperation extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="idenoper", nullable=false, length=10)
private int idenoper;
@Column(name="codeoper", nullable=true, length=5)
private String codeoper;
@Column(name="labloper", nullable=true, length=40)
private String labloper;
@Column(name="nom_tabl", nullable=true, length=40)
private String nom_tabl;
@Column(name="key_colo", nullable=true, length=40)
private String key_colo;
@Column(name="labecolo", nullable=true, length=40)
private String labecolo;
@Column(name="ordeoper", nullable=false, length=3)
private int ordeoper;
@Column(name="sql_list", nullable=true, length=600)
private String sql_list;



}
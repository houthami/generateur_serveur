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
@Table(name="dms_ref_type_doc_metadata")
public class DmsRefTypeDocMetadata extends BasicEntity {

@Column(name="idetypdo", nullable=false, length=12)
private int idetypdo;
@Column(name="idenmeta", nullable=false, length=10)
private int idenmeta;
@Column(name="codemeta", nullable=true, length=5)
private String codemeta;
@Column(name="lablmeta", nullable=true, length=40)
private String lablmeta;
@Column(name="codtypmd", nullable=true, length=1)
private String codtypmd;
@Column(name="defavale", nullable=true, length=60)
private String defavale;
@Column(name="nom_tabl", nullable=true, length=40)
private String nom_tabl;
@Column(name="key_colo", nullable=true, length=40)
private String key_colo;
@Column(name="labecolo", nullable=true, length=40)
private String labecolo;
@Column(name="ordemeta", nullable=false, length=3)
private int ordemeta;
@Column(name="weigmeta", nullable=false, length=3)
private int weigmeta;
@Column(name="mandator", nullable=false, length=1)
private int mandator;
@Column(name="sql_list", nullable=true, length=600)
private String sql_list;



}/*ForeignKey{forienName='idetypdo', forienClass='DmsRefTypeDoc'}*/
/*ForeignKey{forienName='codtypmd', forienClass='DmsRefTypeMetadata'}*/

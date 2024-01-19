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
@Table(name="dms_ref_key_word_type_doc")
public class DmsRefKeyWordTypeDoc extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="iden_tag", nullable=false, length=4)
private int iden_tag;
@Column(name="idetypdo", nullable=false, length=12)
private int idetypdo;
@Column(name="key_word", nullable=true, length=50)
private String key_word;



}/*ForeignKey{forienName='idetypdo', forienClass='DmsRefTypeDoc'}*/

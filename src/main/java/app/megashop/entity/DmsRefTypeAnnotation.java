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
@Table(name="dms_ref_type_annotation")
public class DmsRefTypeAnnotation extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="codtypan", nullable=false, length=2)
private String codtypan;
@Column(name="labtypan", nullable=true, length=100)
private String labtypan;
@Column(name="css_clas", nullable=true, length=50)
private String css_clas;



}
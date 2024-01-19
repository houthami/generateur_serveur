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
@Table(name="dms_ref_type_metadata")
public class DmsRefTypeMetadata extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="codtypmd", nullable=false, length=1)
private String codtypmd;
@Column(name="labtypmd", nullable=false, length=30)
private String labtypmd;



}
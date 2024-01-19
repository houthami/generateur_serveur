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
@Table(name="dms_ref_nature_type_doc")
public class DmsRefNatureTypeDoc extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="codenatu", nullable=false, length=5)
private String codenatu;
@Column(name="labenatu", nullable=false, length=30)
private String labenatu;



}
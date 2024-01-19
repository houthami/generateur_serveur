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
@Table(name="dms_ref_visibility_level")
public class DmsRefVisibilityLevel extends BasicEntity {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="codelevl", nullable=false, length=4)
private int codelevl;
@Column(name="labllevl", nullable=false, length=30)
private String labllevl;



}
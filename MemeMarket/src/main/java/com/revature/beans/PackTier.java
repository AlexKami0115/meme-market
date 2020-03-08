package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PackTiers")
public class PackTier {
	@Id
	@SequenceGenerator(name="packtier", sequenceName="PackTiers_seq", allocationSize=1)
	@GeneratedValue(generator="packtier", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="tierName")
	private String name;
	
	private Integer tierPrice;
}

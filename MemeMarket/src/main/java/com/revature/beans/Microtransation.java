package com.revature.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Microtransations")
public class Microtransation {
	@Id
	@SequenceGenerator(name="microtransations", sequenceName="Microtransations_seq", allocationSize=1)
	@GeneratedValue(generator="microtransations", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patronId")
	private Patron patron;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "packTierId")
	private PackTier packTier;
	
	@Column
	private Timestamp transDate;
	

}

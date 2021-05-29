package com.abhay.sb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cricinfo")
public class CrickInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "macthID")
	private Integer matchId;

	@Column(name = "team1")
	private String team1;
	
	@Column(name = "team2")
	private String team2;
	
	@Column(name = "matchdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date matchdate;
	

}

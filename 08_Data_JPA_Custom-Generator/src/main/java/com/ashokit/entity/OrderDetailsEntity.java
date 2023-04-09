package com.ashokit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ORDR_DTLS")
@Data
public class OrderDetailsEntity {

	@Id
	@Column(name="ORDER_ID")
	private String orderId;
	
	@Column(name="ORDER_BY")
	private String orderBy;
	
	@Column(name="ORDER_PLACED_DT")
	private Date orderPlacedDate;
}

package com.br.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="recibo")
public class Recibo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer iCodRec;
	
	@DateTimeFormat
	@Column
	private Date dDatRec;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="recibo_compra_fk")
	private Compra compra;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="recibo_pagamento_fk")
	private Pagamento pagamento;

	public Recibo(Integer iCodRec, Date dDatRec, Compra compra, Pagamento pagamento) {
		super();
		this.iCodRec = iCodRec;
		this.dDatRec = dDatRec;
		this.compra = compra;
		this.pagamento = pagamento;
	}

	public Integer getiCodRec() {
		return iCodRec;
	}

	public void setiCodRec(Integer iCodRec) {
		this.iCodRec = iCodRec;
	}

	public Date getdDatRec() {
		return dDatRec;
	}

	public void setdDatRec(Date dDatRec) {
		this.dDatRec = dDatRec;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public String toString() {
		return "Recibo [iCodRec=" + iCodRec + ", dDatRec=" + dDatRec + ", compra=" + compra + ", pagamento=" + pagamento
				+ "]";
	}

}
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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer iCodPag;
	
	@Column
	@NotNull(message="O campo tipo pagamento é obrigatório")
	@NotEmpty(message="O campo tipo pagamento é obrigatório")
	private String cTipPag;
	
	@Column
	private boolean bStaPag;
	
	@DateTimeFormat
	@Column
	private Date dDatPag;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pagamento_compra_fk")
	private Compra compra;


	public Pagamento(Integer iCodPag, String cTipPag, boolean bStaPag, Compra compra) {
		super();
		this.iCodPag = iCodPag;
		this.cTipPag = cTipPag;
		this.bStaPag = bStaPag;
		this.compra = compra;
	}


	public Integer getiCodPag() {
		return iCodPag;
	}


	public void setiCodPag(Integer iCodPag) {
		this.iCodPag = iCodPag;
	}


	public String getcTipPag() {
		return cTipPag;
	}


	public void setcTipPag(String cTipPag) {
		this.cTipPag = cTipPag;
	}


	public boolean isbStaPag() {
		return bStaPag;
	}


	public void setbStaPag(boolean bStaPag) {
		this.bStaPag = bStaPag;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	@Override
	public String toString() {
		return "Pagamento [iCodPag=" + iCodPag + ", cTipPag=" + cTipPag + ", bStaPag=" + bStaPag + "]";
	}

	
	
	
	
	
	
    

}

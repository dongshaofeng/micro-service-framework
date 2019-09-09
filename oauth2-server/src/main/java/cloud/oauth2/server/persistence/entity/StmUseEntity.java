package cloud.oauth2.server.persistence.entity;
//
//create table STM_USR
//(
//  usrid          NUMBER(8) not null,
//  usrname        VARCHAR2(50) not null,
//  password       VARCHAR2(50),
//  insideflag     NUMBER(1) default 1,
//  effflag        NUMBER(1) default 1,
//  effstartdate   DATE,
//  effenddate     DATE,
//  managerflag    NUMBER(1),
//  managerclassid NUMBER(8),
//  activeflag     NUMBER(1) default 1,
//  usrstation     NUMBER(8),
//  crtusrid       NUMBER(8) not null,
//  ownftykey      NUMBER(8) not null,
//  scopeftykey    NUMBER(8),
//  crtlog         DATE not null,
//  amdusrid       NUMBER(8) not null,
//  amdlog         DATE not null,
//  usrdesc        VARCHAR2(200),
//  deptid         NUMBER(8),
//  pw_eff_dt      DATE
//)

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 


@Entity
@Table(name="STM_USR")
@NamedQuery(name="StmUseEntity.findAll", query="SELECT o FROM StmUseEntity o")
public class StmUseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usrid",unique=true, nullable=false)
	private String usrid;

	@Column(name="usrname")
	private int usrname;
}

package cloud.resource.admin.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the third_party_account_entity_roles database table.
 * 
 */
@Entity
@Table(name="third_party_account_entity_roles")
@NamedQuery(name="ThirdPartyAccountEntityRole.findAll", query="SELECT t FROM ThirdPartyAccountEntityRole t")
public class ThirdPartyAccountEntityRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	private Date dateCreated;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	private Date lastModified;

	@Column(name="record_status")
	private int recordStatus;

	@Column(length=255)
	private String remarks;

	@Column(name="role_id", nullable=false)
	private BigInteger roleId;

	@Column(name="sort_priority")
	private int sortPriority;

	@Column(name="third_party_account_id", nullable=false)
	private BigInteger thirdPartyAccountId;

	private int version;

	public ThirdPartyAccountEntityRole() {
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public int getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigInteger getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public int getSortPriority() {
		return this.sortPriority;
	}

	public void setSortPriority(int sortPriority) {
		this.sortPriority = sortPriority;
	}

	public BigInteger getThirdPartyAccountId() {
		return this.thirdPartyAccountId;
	}

	public void setThirdPartyAccountId(BigInteger thirdPartyAccountId) {
		this.thirdPartyAccountId = thirdPartyAccountId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
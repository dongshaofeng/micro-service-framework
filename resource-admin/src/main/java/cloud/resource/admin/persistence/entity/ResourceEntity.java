package cloud.resource.admin.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the resource_entity database table.
 * 
 */
@Entity
@Table(name="resource_entity")
@NamedQuery(name="ResourceEntity.findAll", query="SELECT r FROM ResourceEntity r")
public class ResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;
 

	@Column(name="date_created", nullable=false)
	private Timestamp dateCreated;
 

	@Column(name="last_modified", nullable=false)
	private Timestamp lastModified;
 

	@Column(name="record_status", nullable=false)
	private int recordStatus;
 
	@Column(length=255)
	private String remark;

	@Column(length=255)
	private String remarks;

	@Column(nullable=false, length=50)
	private String roles;
 

	@Column(name="sort_priority")
	private int sortPriority;
 

	@Column(nullable=false, length=50)
	private String url;
 

	@Column(nullable=false)
	private int version;

	public ResourceEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public int getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getSortPriority() {
		return sortPriority;
	}

	public void setSortPriority(int sortPriority) {
		this.sortPriority = sortPriority;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
 
}
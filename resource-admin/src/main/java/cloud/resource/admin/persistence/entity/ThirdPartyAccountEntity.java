package cloud.resource.admin.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the third_party_account_entity database table.
 * 
 */
@Entity
@Table(name="third_party_account_entity")
@NamedQuery(name="ThirdPartyAccountEntity.findAll", query="SELECT t FROM ThirdPartyAccountEntity t")
public class ThirdPartyAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="account_open_code", length=255)
	private String accountOpenCode;

	@Column(name="avatar_url", length=255)
	private String avatarUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	private Date lastModified;

	@Column(name="nick_name", length=255)
	private String nickName;

	@Column(name="record_status")
	private int recordStatus;

	@Column(length=255)
	private String remarks;

	@Column(name="sort_priority")
	private int sortPriority;

	@Column(name="third_party", nullable=false, length=20)
	private String thirdParty;

	@Column(name="third_party_account_id", nullable=false, length=100)
	private String thirdPartyAccountId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	private int version;

	public ThirdPartyAccountEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountOpenCode() {
		return this.accountOpenCode;
	}

	public void setAccountOpenCode(String accountOpenCode) {
		this.accountOpenCode = accountOpenCode;
	}

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public int getSortPriority() {
		return this.sortPriority;
	}

	public void setSortPriority(int sortPriority) {
		this.sortPriority = sortPriority;
	}

	public String getThirdParty() {
		return this.thirdParty;
	}

	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

	public String getThirdPartyAccountId() {
		return this.thirdPartyAccountId;
	}

	public void setThirdPartyAccountId(String thirdPartyAccountId) {
		this.thirdPartyAccountId = thirdPartyAccountId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
package cloud.resource.admin.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_account_entity database table.
 * 
 */
@Entity
@Table(name="user_account_entity")
@NamedQuery(name="UserAccountEntity.findAll", query="SELECT u FROM UserAccountEntity u")
public class UserAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="account_open_code", length=255)
	private String accountOpenCode;

	@Column(length=255)
	private String address;

	@Column(name="avatar_url", length=255)
	private String avatarUrl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	@Column(length=255)
	private String city;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	private Date dateCreated;

	@Column(length=255)
	private String email;

	@Column(name="failure_count")
	private int failureCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="failure_time")
	private Date failureTime;

	@Column(length=255)
	private String gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	private Date lastModified;

	@Column(length=255)
	private String mobile;

	@Column(name="nick_name", length=255)
	private String nickName;

	@Column(nullable=false, length=255)
	private String password;

	@Column(length=255)
	private String province;

	@Column(name="record_status")
	private int recordStatus;

	@Column(length=255)
	private String remarks;

	@Column(name="sort_priority")
	private int sortPriority;

	@Column(nullable=false, length=40)
	private String username;

	private int version;

	public UserAccountEntity() {
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFailureCount() {
		return this.failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	public Date getFailureTime() {
		return this.failureTime;
	}

	public void setFailureTime(Date failureTime) {
		this.failureTime = failureTime;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
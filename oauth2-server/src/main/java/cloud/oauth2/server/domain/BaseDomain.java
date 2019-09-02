
package cloud.oauth2.server.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDomain implements Serializable {

	
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 创建时间
     */
    private Date dateCreated;
    /**
     * 修改时间
     */
    private Date lastModified;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Integer getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAdditionalData() {
		return additionalData;
	}
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
	private Integer recordStatus;
    /**
     * 更改次数/每次修改+1
     */
    private Integer version;
    private String remarks;
    private String additionalData;
}

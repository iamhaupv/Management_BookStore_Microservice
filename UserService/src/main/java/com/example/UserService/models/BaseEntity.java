package com.example.UserService.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String deleted;
	@CreatedDate
	private Date createAt;
	@LastModifiedDate
	private Date updateAt;
	@CreatedBy
	private Long createBy;
	@LastModifiedBy
	private Long updateBy;
	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", deleted=" + deleted + ", createAt=" + createAt + ", updateAt=" + updateAt
				+ ", createBy=" + createBy + ", updateBy=" + updateBy + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	public BaseEntity(Long id, String deleted, Date createAt, Date updateAt, Long createBy, Long updateBy) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	

}

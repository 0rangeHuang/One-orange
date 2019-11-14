package com.orange.one.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Document
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(length = 40)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String id;

    @Column(name = "created_date")
    protected Date createdDate = new Date();

    @Column(name = "last_update", columnDefinition = "timestamp")
    @UpdateTimestamp
    protected Date lastUpdate;
    /**
     * 是否删除，默认是未删除
     */
    @Column
    private Boolean isDeleted = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

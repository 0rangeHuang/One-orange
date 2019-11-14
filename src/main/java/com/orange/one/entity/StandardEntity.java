package com.orange.one.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint
        ;
@Entity
@DynamicUpdate
@Table(name = "tab_standard", uniqueConstraints = {@UniqueConstraint(name = "TSI_staffId_unique",columnNames = {"staffId"}),
                                                    @UniqueConstraint(name = "TSI_mobile_unique",columnNames = {"mobileNo"})},
                                        indexes = {@Index(name = "tab_staffId_index", columnList = "companyId, staffId"),
                                                    @Index(name = "tab_mobileNo_index", columnList = "companyId, mobileNo")})
public class StandardEntity extends BaseEntity {

    @Column(length = 40, nullable = false)
    private String companyId;

    @Column(length = 40, nullable = false)
    private String staffId;

    /**
     * 姓名
     */
    @Column(length = 32, nullable = false)
    private String staffName;

    /**
     * 手机号码
     */
    @Column(length = 18, nullable = false)
    private String mobileNo;

    /**
     * 照片
     */
    @Column(columnDefinition="MEDIUMTEXT")
    private String imageBase64;


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}

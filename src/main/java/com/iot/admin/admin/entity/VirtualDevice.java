package com.iot.admin.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class VirtualDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 10, nullable = false)
    private String tag;

    @Column(nullable = false,columnDefinition = "tinyint(1) default 0") 
    private Boolean enabled=false;

    @Column(nullable = false,columnDefinition = "tinyint(1) default 0") 
    private Boolean is_gateway=false;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    /*
    * This method is executed before create
    */
    @PrePersist
    protected void onCreate(){
        tag = tag.toUpperCase();
    }

    /*
    * This method is executed before update
    */
    @PreUpdate
    protected void onUpdate(){
        tag = tag.toUpperCase();
    }
    
}

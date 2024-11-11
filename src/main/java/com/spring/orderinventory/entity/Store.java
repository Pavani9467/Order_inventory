package com.spring.orderinventory.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id")
    private int storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

 
    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "logo_mime_type")
    private String logoMimeType;

    @Column(name = "logo_filename")
    private String logoFilename;

    @Column(name = "logo_charset")
    private String logoCharset;

    @Column(name = "logo_last_updated")
    private java.sql.Date logoLastUpdated;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.manager_dashboard.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "m_branch")
public class MBranch implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "index_no")
    private int indexNo;
    
    @Column(name = "name")
    private String name;

    public MBranch() {
    }

    public MBranch(int indexNo, String name) {
        this.indexNo = indexNo;
        this.name = name;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
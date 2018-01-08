/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.zmaster;

import com.mac.care_point.manager_dashboard.model.MBranch;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface MBranchRepostitory extends JpaRepository<MBranch, Integer>{
    
}

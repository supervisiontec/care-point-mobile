/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.zmaster;

import com.mac.care_point.manager_dashboard.model.MBranch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class MasterService {

    @Autowired
    private MBranchRepostitory mBranchRepostitory;

    public List<MBranch> findAllBranch() {
        return mBranchRepostitory.findAll();
    }
}

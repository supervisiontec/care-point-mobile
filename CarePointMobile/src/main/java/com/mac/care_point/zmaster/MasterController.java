/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.zmaster;

import com.mac.care_point.manager_dashboard.model.MBranch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@CrossOrigin
@RestController
@RequestMapping("/api/care-point-mobile/zmaster")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @RequestMapping(value = "/all-branch", method = RequestMethod.GET)
    public List<MBranch> findAllBranch() {
        return masterService.findAllBranch();
    }
}

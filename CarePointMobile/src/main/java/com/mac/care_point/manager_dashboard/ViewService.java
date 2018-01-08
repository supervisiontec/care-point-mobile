/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.manager_dashboard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kavish manjitha
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;

    public Object[] getJobCardDetails(Integer branch, String fromDate, String toDate) {
        return viewRepository.getJobCardDetails(branch, fromDate, toDate);
    }
    
    public Object[] getSalesDetails(Integer branch, String fromDate, String toDate) {
        return viewRepository.getSalesDetails(branch, fromDate, toDate);
    }
    
    public List<Object[]> getSalesDetailsList(Integer branch, String fromDate, String toDate) {
        return viewRepository.getSalesDetailsList(branch, fromDate, toDate);
    }
    
    public List<Object[]> getJobCardDetailsList(Integer branch, String fromDate, String toDate) {
        return viewRepository.getJobCardDetailsList(branch, fromDate, toDate);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.manager_dashboard;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kavish manjitha
 */
@CrossOrigin
@RestController
@RequestMapping("/api/care-point-mobile/manager-view/dashboard")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/job-card-details/{branch}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public Object[] getJobCardDetails(@PathVariable Integer branch, @PathVariable String fromDate, @PathVariable String toDate) {
        return viewService.getJobCardDetails(branch, fromDate, toDate);
    }

    @RequestMapping(value = "/sales-details/{branch}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public Object[] getSalesDetails(@PathVariable Integer branch, @PathVariable String fromDate, @PathVariable String toDate) {
        return viewService.getSalesDetails(branch, fromDate, toDate);
    }

    @RequestMapping(value = "/sales-details-list/{branch}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public List<Object[]> getSalesDetailsList(@PathVariable Integer branch, @PathVariable String fromDate, @PathVariable String toDate) {
        return viewService.getSalesDetailsList(branch, fromDate, toDate);
    }

    @RequestMapping(value = "/job-card-details-list/{branch}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public List<Object[]> getJobCardDetailsList(@PathVariable Integer branch, @PathVariable String fromDate, @PathVariable String toDate) {
        return viewService.getJobCardDetailsList(branch, fromDate, toDate);
    }
}

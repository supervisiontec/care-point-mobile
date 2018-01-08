(function () {
    'use strict';

    var service = function (systemConfig, $http) {

        this.loadBranchList = function () {
            return $http.get(systemConfig.apiUrl + "/api/care-point-mobile/zmaster/all-branch");
        };
        
        this.getJobCardDetails = function (branch, fromDate, toDate) {
            return $http.get(systemConfig.apiUrl + "/api/care-point-mobile/manager-view/dashboard/job-card-details/" + branch + "/" + fromDate + "/" + toDate);
        };
        
        this.getSalesDetails = function (branch, fromDate, toDate) {
            return $http.get(systemConfig.apiUrl + "/api/care-point-mobile/manager-view/dashboard/sales-details/" + branch + "/" + fromDate + "/" + toDate);
        };
        
        this.getJobCardDetailsList = function (branch, fromDate, toDate) {
            return $http.get(systemConfig.apiUrl + "/api/care-point-mobile/manager-view/dashboard/job-card-details-list/" + branch + "/" + fromDate + "/" + toDate);
        };
        
        this.getSalesDetailsList = function (branch, fromDate, toDate) {
            return $http.get(systemConfig.apiUrl + "/api/care-point-mobile/manager-view/dashboard/sales-details-list/" + branch + "/" + fromDate + "/" + toDate);
        };

    };

    angular.module("appModule")
            .service("managerViewService", service);
}());
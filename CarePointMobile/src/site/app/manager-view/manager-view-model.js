(function () {
    angular.module("appModule")
            .factory("managerViewModule", function (managerViewModelFactory, managerViewService, $q, $filter) {
                function managerViewModule() {
                    this.constructor();
                }

                managerViewModule.prototype = {
                    data: {},
                    searchParamiter: {},
                    viewVariables: {},
                    branchList: [],
                    getJobCardDetailsListData: {
                        dateList: [],
                        totalJobCardList: []
                    },
                    constructor: function () {
                        var that = this;
                        this.searchParamiter = managerViewModelFactory.searchParamiter();
                        this.viewVariables = managerViewModelFactory.viewVariables();

                        managerViewService.loadBranchList()
                                .success(function (data) {

                                    that.branchList = data;
                                });

                    },
                    getJobCardDetails: function (branch, fromDate, toDate) {
                        var defer = $q.defer();
                        var that = this;
                        var formatFromDate = $filter('date')(new Date(fromDate), "yyyy-MM-dd");
                        var formatToDate = $filter('date')(new Date(toDate), "yyyy-MM-dd");
                        managerViewService.getJobCardDetails(branch, formatFromDate, formatToDate)
                                .success(function (data) {
                                    that.viewVariables.pendingJobCard = data[0][0];
                                    that.viewVariables.compliteJobCard = data[0][1];
                                    that.viewVariables.totalJobCard = data[0][2];
                                    defer.resolve();
                                })
                                .error(function () {
                                    defer.reject();
                                });
                        return defer.promise;
                    },
                    getSalesDetails: function (branch, fromDate, toDate) {
                        var defer = $q.defer();
                        var that = this;
                        var formatFromDate = $filter('date')(new Date(fromDate), "yyyy-MM-dd");
                        var formatToDate = $filter('date')(new Date(toDate), "yyyy-MM-dd");
                        managerViewService.getSalesDetails(branch, formatFromDate, formatToDate)
                                .success(function (data) {
                                    that.viewVariables.totalIncome = parseFloat(data[0][0]);
                                    that.viewVariables.payAmount = parseFloat(data[0][1]);
                                    that.viewVariables.creditAmount = parseFloat(data[0][2]);
                                    defer.resolve();
                                })
                                .error(function () {
                                    defer.reject();
                                });
                        return defer.promise;
                    },
                    getJobCardDetailsList: function (branch, fromDate, toDate) {
                        var defer = $q.defer();
                        var that = this;
                        var formatFromDate = $filter('date')(new Date(fromDate), "yyyy-MM-dd");
                        var formatToDate = $filter('date')(new Date(toDate), "yyyy-MM-dd");
                        managerViewService.getJobCardDetailsList(branch, formatFromDate, formatToDate)
                                .success(function (data) {
                                    angular.forEach(data, function (value) {
                                        that.getJobCardDetailsListData.dateList.push(value[0]);
                                        that.getJobCardDetailsListData.totalJobCardList.push(value[3]);
                                    });
                                    defer.resolve();
                                })
                                .error(function () {
                                    defer.reject();
                                });
                        return defer.promise;
                    }
                };
                return managerViewModule;
            });
}());

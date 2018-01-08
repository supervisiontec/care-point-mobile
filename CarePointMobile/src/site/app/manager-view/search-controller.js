(function () {
//module
    angular.module("searchModule", []);
    //controller
    angular.module("searchModule")
            .controller("searchController", function ($scope, $window, systemConfig, managerViewModule) {
                $scope.model = new managerViewModule();
                $scope.ui = {};


                $scope.ui.searchParamiter = function (searchParamiter) {
                    $window.location.href = systemConfig.apiUrl + "#/manager-view/" + searchParamiter.branch + "/" + searchParamiter.fromDate + "/" + searchParamiter.toDate;
                };

            });
}());


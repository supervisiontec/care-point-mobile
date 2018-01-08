(function () {
//module
    angular.module("managerViewModule", []);
    //controller
    angular.module("managerViewModule")
            .controller("managerViewController", function ($scope, $routeParams, managerViewModule) {

                $scope.model = new managerViewModule();
                $scope.ui = {};
                $scope.ui.mode = "DASHBOARD";

                var branch = $routeParams.branch;
                var fromDate = $routeParams.fromDate;
                var toDate = $routeParams.toDate;
                $scope.model.getJobCardDetails(branch, fromDate, toDate);
                $scope.model.getSalesDetails(branch, fromDate, toDate);
                
                $scope.series = ['TOTAL VEHICLES'];
                $scope.colors = ['#8BC34A'];
                $scope.radioModel = 'Full';

                $scope.ui.viewJobCardDetailsList = function () {
                    $scope.ui.mode = "JOBCARD_DETAIL_CHART";
                    $scope.model.getJobCardDetailsList(branch, fromDate, toDate);
                };

            });
}());


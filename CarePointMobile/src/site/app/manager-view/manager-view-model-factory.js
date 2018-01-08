(function () {
    angular.module("appModule")
            .factory("managerViewModelFactory", function () {
                var factory = {};

                factory.searchParamiter = function () {
                    var data = {
                        "branch": null,
                        "fromDate": null,
                        "toDate": null
                    };
                    return data;
                };
                
                factory.viewVariables = function () {
                    var data = {
                        "pendingJobCard": 0,
                        "compliteJobCard": 0,
                        "totalJobCard": 0,
                        "totalIncome": 0,
                        "creditAmount": 0,
                        "payAmount": 0
                    };
                    return data;
                };

                return factory;
            });
}());



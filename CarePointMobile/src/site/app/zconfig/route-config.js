(function () {
    //constants
    angular.module("appModule")
            .constant("systemConfig", {
                apiUrl:
                        location.hostname === 'localhost'
                        ? "http://localhost:8080"
                        : location.protocol + "//" + location.hostname + (location.port ? ':' + location.port : '')
            });




    angular.module("appModule")
            .config(function ($routeProvider) {
                $routeProvider

                        .when("/", {
                            redirectTo: "/manager-serach"
                        })

                        .when("/manager-view/:branch/:fromDate/:toDate", {
                            templateUrl: "app/manager-view/manager-view.html",
                            controller: "managerViewController"
                        })
                        .when("/manager-serach", {
                            templateUrl: "app/manager-view/serach-paramiter-view.html",
                            controller: "searchController"
                        })

                        .otherwise({
                            redirectTo: "/"
                        });
            });
}());
var app = angular.module('myApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8081/springboot',
    USER_SERVICE_API : 'http://localhost:8080/api/person/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'resources/templates/list',
                controller:'PersonController',
                controllerAs:'ctrl',
                resolve: {
                    People: function ($q, PersonService) {
                        console.log('Load all people');
                        var deferred = $q.defer();
                        PersonService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);


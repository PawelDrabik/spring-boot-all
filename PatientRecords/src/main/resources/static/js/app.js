var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/register',{
            templateUrl: '/views/register/register.html',
            controller: 'registerController'
        })
        .when('/listParticipants',{
            templateUrl: '/views/list/listParticipants.html',
            controller: 'listParticipantsController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

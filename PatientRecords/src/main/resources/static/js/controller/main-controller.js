app.controller('mainController', function ($scope, $window, $location, $http) {
    var $ctrl = this;

    $scope.showSection = true;

    $ctrl.$onInit = function () {
    };

    $scope.showLink = function () {
        $scope.showSection = false;
    };

});

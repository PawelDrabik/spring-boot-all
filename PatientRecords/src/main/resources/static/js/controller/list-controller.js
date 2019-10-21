app.controller('listParticipantsController', function ($scope, $window, $location, $http) {
    var $ctrl = this;

    $scope.clinicalInfos = [{}];
    $ctrl.participant = {
        name: '',
        age: '',
        height: '',
        weight: '',
        bloodPressure: ''
    };

    $scope.previous = function () {
        $window.location.href = '/';
    };

    var getParticipants = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/getParticipants'
        }).then(function successCallback(response) {
            $scope.clinicalInfos = response.data.participants;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    getParticipants();

});

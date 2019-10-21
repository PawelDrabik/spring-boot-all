app.controller('registerController', function ($scope, $window, $location, $http) {
    var $ctrl = this;

    $scope.participantAdded = '';

    $ctrl.$onInit = function () {
    };

    $scope.previous = function () {
        $window.location.href = '/';
    };

    $scope.addNewParticipant = function () {
        var formData = {
            name: $scope.eventForm.name.$viewValue,
            age: $scope.eventForm.age.$viewValue,
            height: $scope.eventForm.height.$viewValue,
            weight: $scope.eventForm.weight.$viewValue,
            bloodPressure: $scope.eventForm.bloodPressure.$viewValue
        };

        $http({
            method: 'POST',
            url: 'http://localhost:8080/addParticipant',
            data: angular.toJson(formData)
        }).then(function successCallback(response) {
            console.log('response: ' + JSON.stringify(response.data));
            $scope.participantAdded = 'A new participant added successfully.';
            $scope.participant.name = '';
            $scope.participant.age = '';
            $scope.participant.height = '';
            $scope.participant.weight = '';
            $scope.participant.bloodPressure = '';
        }, function errorCallback(response) {
            console.log(response.statusText);
            $scope.participantAdded = '';
        });
    }
});

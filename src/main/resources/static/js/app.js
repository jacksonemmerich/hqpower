angular.module('hqApp', [])
.factory('hqService', ['$http', function($http) {

    function listar(callback) {
        $http({
            method:'GET',
            url:'/hq/'
        }).success(function (data) {
            if (callback) callback(data)
        });
    }

    function salvar(hq, callback) {
        $http({
            method:'POST',
            url:'/hq/salvar',
            data:JSON.stringify(hq)
        }).success(function (data) {
            if (callback) callback(data)
        });
    }

    return {
        listar:listar,
        salvar:salvar
    };
}])
.controller('hqCtrl', ['$scope', 'hqService',function($scope, hqService) {

    hqService.listar(function(hqs) {
        $scope.hqs = hqs;
    });

    $scope.salvar = function(hq) {
        hqService.salvar(hq, function(hq) {
            $scope.hqs.push(hq);
        });
    }
}]);

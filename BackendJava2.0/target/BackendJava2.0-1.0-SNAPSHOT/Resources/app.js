var app = angular.module('usuarioApp', []);
app.controller('usuariosController', function ($scope,$http) {
    var api='http://localhost:8084/BackendJava2.0/rest/';
    $scope.dadoUsuario=undefined;
    $scope.novo=function(){
         $scope.dadoUsuario={};
    };
    $scope.salvar = function (dadoUsuario) {
        var metodo='POST';
        if (dadoUsuario.id) {
            metodo='PUT';
        }
        $http({
            method:metodo,
            url:api+'usuarios/',
            data:dadoUsuario
        }).then(function successCallback(response){
            atualizarTabela();
        }, function errorCallback(response) {
            ocorreuErro();
        });
    };
    $scope.alterar=function(dadoUsuario){
        $scope.dadoUsuario=dadoUsuario;
    };

    $scope.excluir = function (dadoUsuario) {
        $scope.dadoUsuario=dadoUsuario;
        $http({
            method:'DELETE',
            url:api+'usuarios/'+dadoUsuario.id+'/'
        }).then(function successCallback(response){
            atualizarTabela();
        }, function errorCallback(response) {
            ocorreuErro();
        });
    };
   
    function ocorreuErro(){
        alert("Ocorreu um erro inesperado!");
    }
    function atualizarTabela(){
         $http({
            method:'GET',
            url:api+'usuarios/'
        }).then(function successCallback(response){
            $scope.dadosResponse=response.data;
            $scope.dadoUsuario=undefined;
        }, function errorCallback(response) {
            ocorreuErro();
        });
    } 
    function activate(){
        atualizarTabela();
    }
    activate();
});




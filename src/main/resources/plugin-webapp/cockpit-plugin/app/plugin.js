define(['angular'], function(angular) {

  var ngModule = angular.module('cockpit.plugin.cockpit-plugin', []);

  var DashboardController = function($scope, $http, Uri) {

    $http.get(Uri.appUri("plugin://cockpit-plugin/:engine/process-instance"))
      .success(function(data) {
        $scope.processInstanceCounts = data;
      });
  };

  DashboardController.$inject = ["$scope", "$http", "Uri"];


  var Configuration = function Configuration(ViewsProvider) {

    ViewsProvider.registerDefaultView('cockpit.processes.dashboard', {
      id: 'cockpit-plugin',
      label: 'Camunda Cockpit Plugin',
      url: 'plugin://cockpit-plugin/static/app/dashboard.html',
      controller: DashboardController,

      // make sure we have a higher priority than the default plugin
      priority: 12
    });
  };

  Configuration.$inject = ['ViewsProvider'];

  ngModule.config(Configuration);
  ngModule.controller('DashboardController', [ '$scope' ]);

  return ngModule;
});

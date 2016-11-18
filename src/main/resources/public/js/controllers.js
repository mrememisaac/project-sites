

angular.module('app.controllers', []).controller('SiteListController', function($scope, $state, popupService, $window, Site) {
  $scope.sites = Site.query(); //fetch all sites. Issues a GET to /api/vi/sites

  $scope.deleteSite = function(site) { // Delete a Site. Issues a DELETE to /api/v1/sites/:id
    if (popupService.showPopup('Really delete this?')) {
      site.$delete(function() {
        $scope.sites = Site.query(); 
        $state.go('sites');
      });
    }
  };
}).controller('SiteViewController', function($scope, $stateParams, Site) {
  $scope.site = Site.get({ id: $stateParams.id }); //Get a single site. Issues a GET to /api/v1/sites/:id
}).controller('SiteCreateController', function($scope, $state, $stateParams, Site) {
  $scope.site = new Site();  //create new site instance. Properties will be set via ng-model on UI

  $scope.addSite = function() { //create a new sites. Issues a POST to /api/v1/sites
    $scope.site.$save(function() {
      $state.go('sites'); // on success go back to the list i.e. site state.
    });
  };
}).controller('SiteEditController', function($scope, $state, $stateParams, Site) {
  $scope.updateSite = function() { //Update the edited site. Issues a PUT to /api/v1/sites/:id
    $scope.site.$update(function() {
      $state.go('sites'); // on success go back to the list i.e. sites state.
    });
  };

  $scope.loadSite = function() { //Issues a GET request to /api/v1/sites/:id to get a shipwreck to update
    $scope.site = Site.get({ id: $stateParams.id });
  };

  $scope.loadSite(); // Load a site which can be edited on UI
});

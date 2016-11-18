angular.module('app.services', []).factory('Site', function($resource) {
  return $resource('/api/v1/sites/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});

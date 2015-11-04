var app = angular.module("BookLog", ['ngRoute', 'ngAnimate', 'ui.bootstrap']);

app.config(function ($routeProvider) {
	$routeProvider
		.when('/view1',
			{
				controller: 'BookLogController',
				templateUrl: 'app/partials/bookLogMainView.html'
			})
		.otherwise({ redirectTo: '/view1' });
	
app.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);	
		
});

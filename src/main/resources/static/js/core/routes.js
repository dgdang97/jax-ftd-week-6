angular
.module('app')
.config(['$routeProvider', 'loginRoute', 'homeRoute', 
         function config($routeProvider, loginRoute, homeRoute) {
	
	$routeProvider.
		when('/home', {
			
			templateUrl: homeRoute,
			controller: 'HomeController',
			controllerAs: 'homeController'
				
		}).
		when('/login/:id', {
			
			templateUrl: loginRoute + 'user/userTemplate.html',
			controller: 'UserController',
			controllerAs: 'userController'

		}).
		when('/login', {
			
			templateUrl: loginRoute + 'login/loginUserTemplate.html',
			controller: 'LoginUserController',
			controllerAs: 'loginUserController'
				
		}).
		when('/admin', {
			
			templateUrl: loginRoute + 'admin/adminTemplate.html',
			controller: 'AdminController',
			controllerAs: 'adminController',
			 resolve: {
				 allLocations: function(AdminService){
					 return AdminService.getAllLocations()
					 }
				  }
				
		}).
		when('/user', {
			
			templateUrl: loginRoute + 'user/userTemplate.html',
			controller: 'UserController',
			controllerAs: 'userController'
				
		}).
		otherwise('/login');
}])
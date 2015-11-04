var controllers = {};

controllers.BookLogController = function ($scope, $http) {
	var selectedRow = null;
	
	findAll($scope, $http);
	/*
	$scope.bookLogEntries = [
			{title:'Pena',author:'Stadi',readingDate:'2015-11-12'}, 
			{title:'Arttu',author:'Manse',readingDate:'2015-11-12'}, 
			{title:'Artsi',author:'Stadi',readingDate:'2015-11-12'}, 
			{title:'Eikka',author:'Turku',readingDate:'2015-11-12'}
		];
		*/
	
	$scope.selectEntry=function(index, entryListItem){
		selectedRow = index;
		$scope.selectedEntryId=entryListItem.id;
		findById($scope, $http);
    }
	
	//

	$scope.saveEntry=function() {
		saveEntry($scope, $http);
	}
	
	$scope.createEntry=function() {
		createEntry($scope, $http);
	}
	
	$scope.removeEntry=function() {
		removeEntry($scope, $http);
	}
	
	//
	
	$scope.addAuthor=function() {
		var newAuthor = "<author name>";
		$scope.selectedEntry.book.authors.push(newAuthor);
	}
	
	$scope.removeAuthor=function(index) {
		$scope.selectedEntry.book.authors.splice(index,1);
	}
	
	$scope.addTransalator=function() {
		var newTranslator = "<translator name>";
		$scope.selectedEntry.book.translators.push(newTranslator);
	}
	
	$scope.removeTranslator=function(index) {
		$scope.selectedEntry.book.translators.splice(index,1);
	}
	
	
};

app.controller(controllers);



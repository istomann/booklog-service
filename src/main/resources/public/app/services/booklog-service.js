function findAll($scope, $http) {

	$http.get("http://localhost:8080/booklog/api/v1/entries/").
		success( function(data) {
			$scope.bookLogEntries = data;
		}).
		error( function(data, status, headers, config) {
			$scope.errorMessage = status + " %=% " + headers + " %=% " + data;
		}
	);

}

function findById($scope, $http) {
	$http.get("http://localhost:8080/booklog/api/v1/entries/" + $scope.selectedEntryId).
		success( function(data) {
			$scope.selectedEntry = data;
		}).
		error( function(data, status, headers, config) {
			$scope.errorMessage = status + " %=% " + headers + " %=% " + data;
		}
	);	
}

function saveEntry($scope, $http) {
	if ($scope.selectedEntry == null) {
		$scope.errorMessage = "No entry selected to save"
		return;
	}
	$http.put("http://localhost:8080/booklog/api/v1/entries", $scope.selectedEntry).
		success( function(data) {
			$scope.selectedEntry = data;
		}).
		error( function(data, status, headers, config) {
			$scope.errorMessage = status + " %=% " + headers + " %=% " + data;
		}
	);
}

function createEntry($scope, $http) {
	$scope.newEntry = {
			book : {
				title:'New Title',
				authors:  ['Author'],
			},
			notes : {
				readingDate: new Date().toJSON()					
			}
	};
	$http.post("http://localhost:8080/booklog/api/v1/entries", $scope.newEntry).
		success( function(data) {
			$scope.selectedEntry = data;
			
			var listItem = {
					title: data.book.title,
					author: data.book.authors[0],
					readingDate: data.notes.readingDate
			}
			$scope.bookLogEntries.add(listItem);					
			
		}).
		error( function(data, status, headers, config) {
			$scope.errorMessage = status + " %=% " + headers + " %=% " + data;
		}
	);
	
}

function removeEntry($scope, $http) {
	if ($scope.selectedEntry == null) {
		$scope.errorMessage = "No entry selected to remove"
		return;
	}
	$http.delete("http://localhost:8080/booklog/api/v1/entries/" + $scope.selectedEntry.id).
		success( function() {
			for( var i=0, l=$scope.bookLogEntries.length; i<l; i++ ) {
			    if ($scope.bookLogEntries[i].id == $scope.selectedEntry.id) {
			    	$scope.bookLogEntries.splice(i, 1);
			    	break;
			    }
			}
			$scope.selectedEntry = null;
		}).
		error( function(data, status, headers, config) {
			$scope.errorMessage = status + " %=% " + headers + " %=% " + data;
		}
	);
}
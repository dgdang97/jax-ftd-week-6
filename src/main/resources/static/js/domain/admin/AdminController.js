angular.
module('app').
controller('AdminController', ['AdminService', '$location', 'allLocations', 'allViewTimes', function(AdminService, $location, allLocations, allViewTimes) {
//	if (loggedInAdmin === false) {
//		$location.path('/home')
//	}
//	
	var ctrl = this
	ctrl.url = "/login"
	
	var date = new Date()
	var currentTable = "Total"
	
	ctrl.currentDate = date.toString()
		
	ctrl.locations = allLocations.data
	ctrl.viewTimes = allViewTimes.data
	
	ctrl.views = ["Anonymous", "User", "Total", "Yearly", "Monthly", "Weekly"]
	ctrl.selectedView = "Total"
	
	ctrl.index = allLocations.data.length
		
	ctrl.labels = [ctrl.locations[0].locationName]
	ctrl.yearlyData = [ctrl.viewTimes[0].yearlyView]
	ctrl.monthlyData = [ctrl.viewTimes[0].monthlyView]
	ctrl.weeklyData = [ctrl.viewTimes[0].weeklyView]

	for (var i = 1; i < ctrl.index; i++) {
		ctrl.labels.push(ctrl.locations[i].locationName)
		ctrl.yearlyData.push(ctrl.viewTimes[i].yearlyView)
		ctrl.monthlyData.push(ctrl.viewTimes[i].monthlyView)
		ctrl.weeklyData.push(ctrl.viewTimes[i].weeklyView)
	}
	

	
	ctrl.viewLabel = "Yearly Views"
	ctrl.data = ctrl.yearlyData	
		
	var ctx = document.getElementById("Chart");
	var viewChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ctrl.labels,
	        datasets: [{
	            label: ctrl.viewLabel,
	            data: ctrl.data,
	            backgroundColor: [
	                'rgb(255, 99, 132)',
	                'rgb(54, 162, 235)',
	                'rgb(255, 206, 86)',
	                'rgb(75, 192, 192)',
	                'rgb(153, 102, 255)',
	                'rgb(255, 159, 64)'
	            ],
	            borderWidth: 1
	        }]
	    }
	})
	
	ctrl.selectView = function(view) {
		for (var i = 0; i < ctrl.index; i++) {
			document.getElementById(currentTable + i).style.display = "none";
			document.getElementById(view + i).style.display = "table-cell";
		}
		ctrl.selectedView = view
		currentTable = view
		
		document.getElementById("Table").style.display = "block"
		document.getElementById("Chart").style.display = "none"
	}
		
	ctrl.newLocation = function() {
		if (ctrl.name != null)
		var location = {
				"locationName" : ctrl.name,
				"locationDetails" : ctrl.details
		}
		AdminService.newLocation(location).then(function(result) {
			ctrl.message = result.data
			alert(ctrl.message.response)
		})
	}

	ctrl.showChart = function(chart) {
		if (chart === 'Year') {
			viewChart.data.datasets[0].label = "Yearly Views"
			viewChart.data.datasets[0].data = ctrl.yearlyData
		} else if ( chart === 'Month') {
			viewChart.data.datasets[0].label = "Monthly Views"
			viewChart.data.datasets[0].data = ctrl.monthlyData
		} else if (chart === 'Week') {
			viewChart.data.datasets[0].label = "Weekly Views"
			viewChart.data.datasets[0].data = ctrl.weeklyData
		}
		
		ctrl.selectedView = chart + "ly Chart"
		viewChart.update()
		
		document.getElementById("Table").style.display = "none"
		document.getElementById("Chart").style.display = "block"
	}
	
}]);
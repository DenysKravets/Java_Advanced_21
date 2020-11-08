/**
 * 
 */

//
function sendPeriodicalRequest(id) {

	alert("Added to bucket!");

	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "http://localhost:8080/addPeriodicalToBucket?id=" + id,
		success: function(){
			console.log("success!");
		}
	})

}



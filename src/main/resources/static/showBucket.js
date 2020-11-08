/**
 * 
 */

//
function sendRemoveRequest(element, id) {

	element.parentElement.parentElement.style.display = "none";

	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "http://localhost:8080/removePeriodicalFromBucket?id=" + id,
		success: function(){
			console.log("success!");
		}
	})

}



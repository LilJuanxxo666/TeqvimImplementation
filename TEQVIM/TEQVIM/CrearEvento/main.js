$(document).ready () => {

    $.ajax({
        url: "http://localhost:8080/publiuco/api/evento",
        type: "POST",
        dataType: "json",
        success: function(res){
           console.log(res);
        }
    })
}

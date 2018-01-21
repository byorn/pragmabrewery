$(document).ready(function() {

    checkTemperature();

    function checkTemperature(){

            $.ajax({
                    url: "http://localhost:8080/getBeerTemperature"
                }).then(function(data) {
                            if(data){
                                   var len = data.length;
                                   var txt = "";
                                   if(len > 0){

                                       txt += "<tr><th>Beer Container</th><th>Temperature</th> <th>Status</th> </tr>";


                                       for(var i=0;i<len;i++){

                                               txt += "<tr class=' " + getClassForTableRow(data[i].status) + "'><td>"+data[i].beerName+"</td><td>"+data[i].temperature+"</td><td>"+data[i].status+"</td></tr>";

                                       }
                                       if(txt != ""){
                                           $("#table").html("");
                                           $("#table").append(txt);
                                       }
                                   }
                                   setTimeout(checkTemperature,5000);
                               }
            });
        console.log("check temp");
    }


});

function getClassForTableRow(status){
        if(status=="alert"){
            return "label-danger";
        }

        return "";
}
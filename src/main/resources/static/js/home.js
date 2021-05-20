$(function() {
    $(".btn-search").on('click',function(e) {
        var valDepartureDateAndTime = $("#departureDateAndTime").val();
        var valArrivalDateAndTime = $("#arrivalDateAndTime").val();
        var erFlg = false;
        var html = "";
        $('.errRow').remove();

        if (valDepartureDateAndTime == "") {
            html += "<tr class='errRow'><td class='errMsgRed'>E-00-0001: Field Departure Date And Time is required.</td><br/></tr>";
            erFlg = true;
        }
        
        if (valDepartureDateAndTime != "" && valArrivalDateAndTime != "") {
            if (valDepartureDateAndTime > valArrivalDateAndTime) {
                html += "<tr class='errRow'><td class='errMsgRed'> E-00-0010 : Arrival Date And Time must be greater than Departure Date And Time </td><br/></tr>";
                  erFlg = true;
            }
        }

        if (erFlg) {
            $('#errClientDiv').css('display', '');
            $('#errClientRow').css('display', '');
            $('#errClientRow').append(html);
            $('.errMsgRed').css('text-align', 'center');
        } else {
            $('#searchForm').submit();
        }
    });
});
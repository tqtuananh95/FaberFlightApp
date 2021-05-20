$(function() {
    // Change format Money
    jQuery.each($('.table').find('.btn'), function (i, el) {
        $(el).text(formatMoney($(el).text()));
        i++;
    });
});

// add info Modal
function addModal(id) {
    var html = '';
    
    var orderForm = new Object();
    $.each(dlistFlight, function( index, value ) {
        if (value.flightID == id) {
            html +='<div class="dlist-div">';
              html +='<label>Flight from: <b>'+ value.departureAirport.departureAirportName +' -> '+ value.arrivalAirport.arrivalAirportName +'</b></label>';
              html +='</div>';
              html +='<div>';
              html +='<label>adults: <b>'+ detailList.adult +'</b>, seniors (65+): <b>'+ detailList.senior +'</b>, children: <b>'+ detailList.children +'</b></label>';
              html +='</div>';
              html +='<div>';
              html +='<label>Check-in at: Pacific Airlines counter.</label>';
              html +='</div>';
              html +='<div>';
              html +='<label>Baggage policy:</label>';
              html +='<label>- Hand luggage: 7kg (according to BL standard).</label>';
              html +='<label>- Checked baggage: 1 piece 23kg.</label>';
              html +='</div>';
              
              // new flightForm
              var flightForm = new Object();
              flightForm['flightID'] = value.flightID;
              // new departureAirportForm
              var departureAirportForm = new Object();
              departureAirportForm['departureAirportId'] = value.departureAirport.departureAirportId;
              // new arrivalAirportForm
              var arrivalAirportForm = new Object();
              arrivalAirportForm['arrivalAirportId'] = value.arrivalAirport.arrivalAirportId;
              
            orderForm['flight'] = flightForm;
            orderForm['departureAirport'] = departureAirportForm;
            orderForm['arrivalAirport'] = arrivalAirportForm;
            orderForm['departureDateAndTime'] = value.departureDateAndTime;
            orderForm['arrivalDateAndTime'] = value.arrivalDateAndTime;
            orderForm['totalAdultSeniorChild'] = detailList.adult +','+ detailList.senior +','+ detailList.children;
            orderForm['pricePerFlight'] = value.price;
            orderForm['totalPriceForOrder'] = (value.price * detailList.adult) + (value.price * detailList.senior) + (value.price * detailList.children);
        }
    });
    $.each(alistFlight, function( index, value ) {
        if (value.flightID == id) {
            html +='<div class="alist-div">';
              html +='<label>Flight from: <b>'+ value.departureAirport.departureAirportName +' -> '+ value.arrivalAirport.arrivalAirportName +'</b></label>';
              html +='</div>';
              html +='<div>';
              html +='<label>adults: <b>'+ detailList.adult +'</b>, seniors (65+): <b>'+ detailList.senior +'</b>, children: <b>'+ detailList.children +'</b></label>';
              html +='</div>';
              html +='<div>';
              html +='<label>Check-in at: Pacific Airlines counter.</label>';
              html +='</div>';
              html +='<div>';
              html +='<label>Baggage policy:</label>';
              html +='<label>- Hand luggage: 7kg (according to BL standard).</label>';
              html +='<label>- Checked baggage: 1 piece 23kg.</label>';
              html +='</div>';
              
              // new flightForm
              var flightForm = new Object();
              flightForm['flightID'] = value.flightID;
              // new departureAirportForm
              var departureAirportForm = new Object();
              departureAirportForm['departureAirportId'] = value.departureAirport.departureAirportId;
              // new arrivalAirportForm
              var arrivalAirportForm = new Object();
              arrivalAirportForm['arrivalAirportId'] = value.arrivalAirport.arrivalAirportId;
              
            orderForm['flight'] = flightForm;
            orderForm['departureAirport'] = departureAirportForm;
            orderForm['arrivalAirport'] = arrivalAirportForm;
            orderForm['departureDateAndTime'] = value.departureDateAndTime;
            orderForm['arrivalDateAndTime'] = value.arrivalDateAndTime;
            orderForm['totalAdultSeniorChild'] = detailList.adult +','+ detailList.senior +','+ detailList.children;
            orderForm['pricePerFlight'] = value.price;
            orderForm['totalPriceForOrder'] = (value.price * detailList.adult) + (value.price * detailList.senior) + (value.price * detailList.children);
        }
    });
    
    $('.modal-body').append(html);
    
    // show hide Button
    if(detailList.arrivalDateAndTime != "") {
        $('.btn-register').hide();
        orderForm['returnType'] = 2;
    } else {
        orderForm['returnType'] = 1;
        $('.btn-register').show();
        $('.btn-continue').hide();
    }
    
    if ($('.modal').find('.alist-div').length == 1 && $('.modal').find('.dlist-div').length == 1) {
        $('.btn-continue').hide();
        $('.btn-register').show();
    }
    
    list.push(orderForm);
    console.log("list", list);
}

$(".btn-reselect").on('click',function(e) {
    jQuery.each($('.modal-body').find('div'), function (i, el) {
        $(el).remove();
        i++;
    });
    
    // set list []
    list = [];
})
$(".btn-register").on('click',function(e) {
    $.ajax({
        type: "POST",
        data: JSON.stringify(list),
        contentType: "application/json",
        url: "/order",
        cache: false,
        timeout: 600000,
    }).done(function (data) {
        openSnack(data.modalMessage, 3, SNACK_SUCCESS);
        setTimeout(function(){
           location.href = '/order';
        }, 1000);
    }).fail(function (errs) {
           openSnack(errs.responseText, 3, SNACK_ERR);
    });
});
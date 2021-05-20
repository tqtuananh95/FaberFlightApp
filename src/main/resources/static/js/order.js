$(function() {
    // Change format Money pricePerFlight
    jQuery.each($('.table').find('.pricePerFlight'), function (i, el) {
        $(el).val(formatMoney($(el).val()));
        $(el).attr("title", $(el).val());
        i++;
    });
    
    // Change format Money totalPriceForOrder
    jQuery.each($('.table').find('.totalPriceForOrder'), function (i, el) {
        $(el).val(formatMoney($(el).val()));
        $(el).attr("title", $(el).val());
        i++;
    });
    
    // Change format Money totalAdultSeniorChild
    jQuery.each($('.table').find('.totalAdultSeniorChild'), function (i, el) {
        var textTotal = "";
        $.each($(el).val().split(','), function( index, value ) {
            if (index == 0) {
                textTotal +="Adult: " + value;
            }
            if (index == 1) {
                textTotal +=" Senior: " + value;
            }
            if (index == 2) {
                textTotal +=" Child: " + value;
            }
        });
        $(el).val(textTotal);
        $(el).attr("title", textTotal);
        i++;
    });
});
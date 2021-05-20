// function format Money
function formatMoney(x) {
    return Number(x).toLocaleString('en-US') + 'K';
}

var SNACK_ERR = 'ERR';
var SNACK_SUCCESS = 'SUCCESS';
var SNACK_WARNING = 'WARN';
function openSnack(msg, timeout, type) {
    var snackEl = $('#snackbar');
    if (type === SNACK_ERR) {
        snackEl.css("background-color", "#f44336");

    } else if (type === SNACK_WARNING) {
        snackEl.css("background-color", "#ff9800");

    } else {
        snackEl.css("background-color", "#4caf50");
    }

    if (!timeout) {
        timeout = 3;
    }

    if (!msg) {
        msg = 'undefined';
    }

    snackEl.text(msg);
    snackEl.fadeIn();

    setTimeout(function () {
        snackEl.fadeOut()
    }, timeout * 1000);
}
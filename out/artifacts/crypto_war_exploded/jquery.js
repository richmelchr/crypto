$(document).ready(function() {
    $('#encryptBtn').click(function() {
        $.ajax({
            url: 'Servlet',
            data: {
                radioSelect: $('encryptSelect' + ' input:checked').val(),
                optionA: $('#mult').val(),
                optionB: $('#add').val(),
                encryptText: $('#encryptText').val(),
                decryptText: ""
            },
            success: function(responseText) {
                $('#result' +' p').text(responseText);
            }
        });
    });

    $("#decryptBtn").click(function() {
        $.ajax({
            url: 'Servlet',
            data: {
                radioSelect: $('input:checked').val(),
                encryptText: "",
                decryptText: $("#decryptText").val()
            },
            success: function(responseText) {
                $('#result' +' p').text(responseText);
            }
        })
    });

    $("#decryptSelect").click(function() {
        var radioSelect = $('#decryptSelect' + ' input:checked').val();
        $(".selections").css("display", "none");    //hide all decrypt option DOM elements
        if (radioSelect == "shift") {
            $(".shift").css("display", "block");    //show shift decrypt options
        } else if (radioSelect == "affine") {
            $(".affine").css("display", "block");   //show affine decrypt options
        } else if (radioSelect == "rsa") {
            $(".rsa").css("display", "block");      //show RSA decrypt options
        }
    });

});

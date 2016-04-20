$(document).ready(function() {
    $('#encryptBtn').click(function() {
        $.ajax({
            url: 'Servlet',
            data: {
                radioSelect: $('input:checked').val(),
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

});

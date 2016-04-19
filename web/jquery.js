$(document).ready(function() {
    $('#encryptBtn').click(function() {
        $.ajax({
            url : 'Servlet',
            data : {
                encryptText : $('#encryptText').val()
            },
            success : function(responseText) {
                $('#result' +' p').text(responseText);
            }
        });
    });
});

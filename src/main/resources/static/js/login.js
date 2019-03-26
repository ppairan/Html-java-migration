$(document).ready(function() {
    //$('#username').focus();

    $('#submit').click(function(event) {

        event.preventDefault(); // prevent PageReLoad

       var ValidEmail = $('#username').val() === 'Admin'; // User validate
       var ValidPassword = $('#password').val() === '123'; // Password validate



        if (ValidEmail === true && ValidPassword === true) { // if ValidEmail & ValidPassword
           $('.valid').css('display', 'block');

            window.location.href = "/start"; // go to home.html
        }
        else {
            $('.error').css('display', 'block'); // show error msg

        }
    });
    $('#password').keydown(function(e){
    if(e.keycode == 13){
    $('#password').trigger("click");
    }});



    $(document).keypress(function(event){
    var keycode = (event.keycode ? event.keycode : event.which);
    if(keycode == "13"){
           event.preventDefault(); // prevent PageReLoad

           var ValidEmail = $('#username').val() === 'Admin'; // User validate
           var ValidPassword = $('#password').val() === '123'; // Password validate



            if (ValidEmail === true && ValidPassword === true) { // if ValidEmail & ValidPassword
               $('.valid').css('display', 'block');

                window.location.href = "/start";

            }
            else {
                $('.error').css('display', 'block'); // show error msg
                console.log("nö");
            }
    }

    });
});
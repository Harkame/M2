$(document).ready(function() {
    "use strict";

    alert('script');

    $('#tp1-1 li').first().css('font-weight', 'bold');


    $('#tp1-1 .description').insertAfter('#tp1-1 h2');


    $('#tp1-2 input').focusout(function()
    {
        alert($(this).val());
    });

    $('#tp1-3 .todo').hide('slow');
    //$('#tp1-3 .todo').fadeOut('slow');
    //$.ema();

    let checkbox = document.createElement('input');
    checkbox.id = 'hide_checkbox';
    checkbox.type = "checkbox";
    checkbox.value = 1;
    checkbox.name = "todo[]";

    document.body.appendChild(checkbox);

    checkbox.addEventListener( 'change', function() {
        if(this.checked) {
            $('.todo').show('slow');
        } else {
            $('.todo').hide('slow');
        }
    });

    //TODO
    /*
    $.extend($ema, function()
    {

    });
    */
});

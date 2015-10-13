(function () {
    document.getElementById('next').addEventListener("click", function (event) {
        console.log('next clicked');
    });

    document.getElementById('back').addEventListener("click", function (event) {
        console.log('back clicked');
    });

    document.getElementById('cancel').addEventListener("click", function (event) {
        console.log('cancel clicked');
    });
    
    document.getElementById('finish').addEventListener("click", function (event) {
        console.log('finish clicke');
    });
    
    function alternativeClicked(event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (DOMUtils.containClass(parent, "selected"))
            DOMUtils.removeClass(parent, "selected");
        else
            DOMUtils.addClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa2');
        if (DOMUtils.containClass(parent, "selected"))
            DOMUtils.removeClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa3');
        if (DOMUtils.containClass(parent, "selected"))
            DOMUtils.removeClass(parent, "selected");
    }

    document.getElementById('alternative1').addEventListener("click", alternativeClicked);
    document.getElementById('alternative2').addEventListener("click", alternativeClicked);
    document.getElementById('alternative3').addEventListener("click", alternativeClicked);

})();
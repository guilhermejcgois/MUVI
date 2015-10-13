(function () {
    function shouldHideFooter(getingOutFrom) {
        var footer = document.getElementsByTagName('footer')[0];
        
        if (!DOMUtils.containClass(footer, "hide"))
            DOMUtils.addClass(footer, "hide")
    }

    document.getElementById('goto').addEventListener("click", function (event) {
        console.log('goto clicked');
    });

    document.getElementById('backto').addEventListener("click", function (event) {
        console.log('backto clicked');
    });

    document.getElementsById('amore').addEventListener("click", function (event) {
        var a = event.target || event.srcElement;
        var aparentparent = a.parentNode.parentNode;
        var footer = aparentparent.children[2];
        if (containClass(footer, "hide"))
            removeClass(footer, "hide");
        else
            addClass(footer, "hide");
    });

})();
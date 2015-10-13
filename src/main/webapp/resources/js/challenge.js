(function () {
    function addClass(object, className) {
        object.className = object.className + " " + className;
    }
    function removeClass(object, className) {
        object.className = object.className.replace(className, "");
    }
    function containClass(object, className) {
        return object.className.search(className) !== -1;
    }
    function gofromto(from, to) {
        addClass(document.getElementById(from), "hide");
        removeClass(document.getElementById(to), "hide");
    }
    function controlMenu(event) {
        var target = event.target || event.srcElement;
        var type = event.type;
        console.log(target);
        console.log(type);

        var openCloseDiv = document.getElementById('openclose-div');
        var modalDiv = document.getElementById('modal-div');
        var menuBtn = document.getElementById('menu-btn');
        var menuSection = document.getElementById('menu-section');

        if (!containClass(menuBtn, "opened") && ((type === 'click' && target.id === 'menu-btn')/* || verificar se foi um touchmove */)) {
            addClass(openCloseDiv, "opened");
            addClass(menuBtn, "opened");
            addClass(modalDiv, "show-transition");
            addClass(menuSection, "show-transition");
            addClass(menuSection.children[0], "show-transition");
            addClass(menuSection.children[1], "show-transition");
            addClass(menuSection.children[2], "show-transition");
        } else {
            removeClass(openCloseDiv, "opened");
            removeClass(menuBtn, "opened");
            removeClass(modalDiv, "show-transition");
            removeClass(menuSection, "show-transition");
            removeClass(menuSection.children[0], "show-transition");
            removeClass(menuSection.children[1], "show-transition");
            removeClass(menuSection.children[2], "show-transition");
        }
    }
    function controlCenarios(event) {
        var target = event.target || event.srcElement;
        var li1 = document.getElementById('menu-li1');
        var lili1 = document.getElementById('menu-lili1');
        var li2 = document.getElementById('menu-li2');
        var lili2 = document.getElementById('menu-lili2');

        if (target.id === 'menu-li1') {
            if (containClass(li2, "opened")) {
                removeClass(li2, "opened");
                removeClass(lili2, "show");
            }
            if (containClass(li1, "opened")) {
                removeClass(li1, "opened");
                removeClass(lili1, "show");
            } else {
                addClass(li1, "opened");
                addClass(lili1, "show");
            }
        } else if (target.id === 'menu-li2') {
            if (containClass(li1, "opened")) {
                removeClass(li1, "opened");
                removeClass(lili1, "show");
            }
            if (containClass(li2, "opened")) {
                removeClass(li2, "opened");
                removeClass(lili2, "show");
            } else {
                addClass(li2, "opened");
                addClass(lili2, "show");
            }
        }
    }

    document.getElementById('dsf1proximo').addEventListener("click", function (event) {
        gofromto('dsf1', 'dsf2');
    });
    document.getElementById('dsf2proximo').addEventListener("click", function (event) {
        gofromto('dsf2', 'dsf3');
    });
    document.getElementById('dsf3proximo').addEventListener("click", function (event) {
        gofromto('dsf3', 'dsf4');
    });

    document.getElementById('dsf2anterior').addEventListener("click", function (event) {
        gofromto('dsf2', 'dsf1');
    });
    document.getElementById('dsf3anterior').addEventListener("click", function (event) {
        gofromto('dsf3', 'dsf2');
    });
    document.getElementById('dsf4anterior').addEventListener("click", function (event) {
        gofromto('dsf4', 'dsf3');
    });

    document.getElementById('dsf1cancelar').addEventListener("click", function (event) {
        document.getElementById('dsf1cancelar').children[0].click();
    });
    document.getElementById('dsf2cancelar').addEventListener("click", function (event) {
        document.getElementById('dsf2cancelar').children[0].click();
    });
    document.getElementById('dsf3cancelar').addEventListener("click", function (event) {
        document.getElementById('dsf3cancelar').children[0].click();
    });
    document.getElementById('dsf4cancelar').addEventListener("click", function (event) {
        document.getElementById('dsf4cancelar').children[0].click();
    });

    document.getElementById('openclose-div').addEventListener("click", controlMenu);

    document.getElementById('modal-div').addEventListener("click", controlMenu);

    document.getElementById('menu-li1').addEventListener("click", controlCenarios);

    document.getElementById('menu-li2').addEventListener("click", controlCenarios);

    document.addEventListener("keypress", function (event) {
        if (!containClass(document.getElementById('menu-btn'), "opened"))
            switch (event.keyCode) {
                case 37: // left
                    if (!containClass(document.getElementById('dsf2'), "hide"))
                        document.getElementById('dsf2anterior').click();
                    else if (!containClass(document.getElementById('dsf3'), "hide"))
                        document.getElementById('dsf3anterior').click();
                    else if (!containClass(document.getElementById('dsf4'), "hide"))
                        document.getElementById('dsf4anterior').click();
                    break;
                case 39: // right
                    if (!containClass(document.getElementById('dsf2'), "hide"))
                        document.getElementById('dsf2proximo').click();
                    else if (!containClass(document.getElementById('dsf3'), "hide"))
                        document.getElementById('dsf3proximo').click();
                    else if (!containClass(document.getElementById('dsf1'), "hide"))
                        document.getElementById('dsf1proximo').click();
                    else
                        document.getElementById('goto').click();
                    break;
            }
    });

    document.getElementById('dsf1alternativa1').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa2');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa3');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf1alternativa2').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa1');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa3');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf1alternativa3').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa2');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf1alternativa1');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf2alternativa1').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa2');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa3');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf2alternativa2').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa1');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa3');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf2alternativa3').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;
        var parent = target.parentNode;

        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
        else
            addClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa2');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");

        parent = document.getElementById('dsf2alternativa1');
        if (containClass(parent, "selected"))
            removeClass(parent, "selected");
    });

    document.getElementById('dsf3alternativa1').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf3alternativa2');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf3alternativa3');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

    document.getElementById('dsf3alternativa2').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf3alternativa1');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf3alternativa3');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

    document.getElementById('dsf3alternativa3').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf3alternativa2');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf3alternativa1');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

    document.getElementById('dsf4alternativa1').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf4alternativa2');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf4alternativa3');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

    document.getElementById('dsf4alternativa2').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf4alternativa1');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf4alternativa3');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

    document.getElementById('dsf4alternativa3').addEventListener("click", function (event) {
        var target = event.target || event.srcElement;

        if (containClass(target, "selected"))
            removeClass(target, "selected");
        else
            addClass(target, "selected");

        target = document.getElementById('dsf4alternativa2');
        if (containClass(target, "selected"))
            removeClass(target, "selected");

        target = document.getElementById('dsf4alternativa1');
        if (containClass(target, "selected"))
            removeClass(target, "selected");
    });

})();
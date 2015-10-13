(function () {
    function addClass(object, className) {
        console.log('Adicionando a classe ' + className + ' para o elemento ' + object);
        object.className = object.className + " " + className;
    }
    function removeClass(object, className) {
        console.log('Removendo a classe ' + className + ' do elemento ' + object);
        object.className = object.className.replace(className, "");
    }
    function containClass(object, className) {
        console.log('Verificando se o elemento ' + object + ' possui a classe ' + className);
        return object.className.search(className) !== -1;
    }
    function gofromto(from, to) {
        addClass(document.getElementById(from), "hide");
        removeClass(document.getElementById(to), "hide");
    }
    function controlMenu(event) {
        var target = event.target || event.srcElement;
        var type = event.type;

        var openCloseDiv = document.getElementById('openclose-div');
        var modalDiv = document.getElementById('modal-div');
        var menuBtn = document.getElementById('menu-btn');
        var menuSection = document.getElementById('menu-section');

        if (!containClass(menuBtn, "opened") && ((type === 'click' && target.id === 'menu-btn')/* || verificar se foi um touchmove */)) {
            console.log('Abrindo o menu');
            addClass(openCloseDiv, "opened");
            addClass(menuBtn, "opened");
            //removeClass(modalDiv, "hide-transition");
            addClass(modalDiv, "show-transition");
            //removeClass(menuSection, "hide-transition");
            addClass(menuSection, "show-transition");
            //removeClass(menuSection.children[0], "hide-transition");
            addClass(menuSection.children[0], "show-transition");
            //removeClass(menuSection.children[1], "hide-transition");
            addClass(menuSection.children[1], "show-transition");
            //removeClass(menuSection.children[2], "hide-transition");
            addClass(menuSection.children[2], "show-transition");
        } else {
            console.log('Fechando o menu');
            removeClass(openCloseDiv, "opened");
            removeClass(menuBtn, "opened");
            removeClass(modalDiv, "show-transition");
            //addClass(modalDiv, "hide-transition");
            removeClass(menuSection, "show-transition");
            //addClass(menuSection, "hide-transition");
            removeClass(menuSection.children[0], "show-transition");
            //addClass(menuSection.children[0], "hide-transition");
            removeClass(menuSection.children[1], "show-transition");
            //addClass(menuSection.children[1], "hide-transition");
            removeClass(menuSection.children[2], "show-transition");
            //addClass(menuSection.children[2], "hide-transition");
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
    function shouldHideFooter(getingOutFrom) {
        var a = amores[getingOutFrom - 1];
        var aparentparent = a.parentNode.parentNode;
        var footer = aparentparent.children[2];
        if (!containClass(footer, "hide"))
            addClass(footer, "hide")
    }

    document.addEventListener("keypress", function (event) {
        if (!containClass(document.getElementById('menu-btn'), "opened"))
            switch (event.keyCode) {
                case 37: // left
                    if (!containClass(document.getElementById('obj2'), "hide"))
                        document.getElementById('backto1').click();
                    else if (!containClass(document.getElementById('obj3'), "hide"))
                        document.getElementById('backto2').click();
                    else if (!containClass(document.getElementById('obj4'), "hide"))
                        document.getElementById('backto3').click();
                    break;
                case 39: // right
                    if (!containClass(document.getElementById('obj2'), "hide"))
                        document.getElementById('goto3').click();
                    else if (!containClass(document.getElementById('obj3'), "hide"))
                        document.getElementById('goto4').click();
                    else if (!containClass(document.getElementById('obj1'), "hide"))
                        document.getElementById('goto2').click();
                    else
                        document.getElementById('goto').click();
                    break;
            }
    });/*

    document.getElementById('goto2').addEventListener("click", function (event) {
        gofromto('obj1', 'obj2');
        shouldHideFooter(1);
    });

    document.getElementById('goto3').addEventListener("click", function (event) {
        gofromto('obj2', 'obj3');
        shouldHideFooter(2);
    });

    document.getElementById('goto4').addEventListener("click", function (event) {
        gofromto('obj3', 'obj4');
        shouldHideFooter(3);
    });

    document.getElementById('goto').addEventListener("click", function (event) {
        document.getElementById('goto').children[0].click();
    });

    document.getElementById('backto1').addEventListener("click", function (event) {
        gofromto('obj2', 'obj1');
        shouldHideFooter(2);
    });

    document.getElementById('backto2').addEventListener("click", function (event) {
        gofromto('obj3', 'obj2');
        shouldHideFooter(3);
    });

    document.getElementById('backto3').addEventListener("click", function (event) {
        gofromto('obj4', 'obj3');
        shouldHideFooter(4);
    });*/

    document.getElementById('openclose-div').addEventListener("click", controlMenu);

    document.getElementById('modal-div').addEventListener("click", controlMenu);

    document.getElementById('menu-li1').addEventListener("click", controlCenarios);

    document.getElementById('menu-li2').addEventListener("click", controlCenarios);

    var amores = document.getElementsByClassName('amore');
    for (var amore in amores) {
        if (amores[amore].tagName)
            amores[amore].addEventListener("click", function (event) {
                var a = event.target || event.srcElement;
                var aparentparent = a.parentNode.parentNode;
                var footer = aparentparent.children[2];
                if (containClass(footer, "hide"))
                    removeClass(footer, "hide")
                else
                    addClass(footer, "hide")
            });
    }
})();
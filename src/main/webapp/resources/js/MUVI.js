var MUVI = MUVI || {
    menu: function (event) {
        var target = event.target || event.srcElement;
        var type = event.type;

        var openCloseDiv = document.getElementById('openclose-div');
        var modalDiv = document.getElementById('modal-div');
        var menuBtn = document.getElementById('menu-btn');
        var menuSection = document.getElementById('menu-section');

        if (!DOMUtils.containClass(menuBtn, "opened") && ((type === 'click' && target.id === 'menu-btn')/* || verificar se foi um touchmove */)) {
            console.log('Abrindo o menu');
            DOMUtils.addClass(openCloseDiv, "opened");
            DOMUtils.addClass(menuBtn, "opened");
            //DOMUtils.removeClass(modalDiv, "hide-transition");
            DOMUtils.addClass(modalDiv, "show-transition");
            //DOMUtils.removeClass(menuSection, "hide-transition");
            DOMUtils.addClass(menuSection, "show-transition");
            //DOMUtils.removeClass(menuSection.children[0], "hide-transition");
            DOMUtils.addClass(menuSection.children[0], "show-transition");
            //DOMUtils.removeClass(menuSection.children[1], "hide-transition");
            DOMUtils.addClass(menuSection.children[1], "show-transition");
            //DOMUtils.removeClass(menuSection.children[2], "hide-transition");
            addDOMUtils.Class(menuSection.children[2], "show-transition");
        } else {
            console.log('Fechando o menu');
            DOMUtils.removeClass(openCloseDiv, "opened");
            DOMUtils.removeClass(menuBtn, "opened");
            DOMUtils.removeClass(modalDiv, "show-transition");
            //DOMUtils.addClass(modalDiv, "hide-transition");
            DOMUtils.removeClass(menuSection, "show-transition");
            //DOMUtils.addClass(menuSection, "hide-transition");
            DOMUtils.removeClass(menuSection.children[0], "show-transition");
            //DOMUtils.addClass(menuSection.children[0], "hide-transition");
            DOMUtils.removeClass(menuSection.children[1], "show-transition");
            //DOMUtils.addClass(menuSection.children[1], "hide-transition");
            DOMUtils.removeClass(menuSection.children[2], "show-transition");
            //DOMUtils.addClass(menuSection.children[2], "hide-transition");
        }
    },
    keyboard: function (left, right) {
        document.addEventListener("keypress", function (event) {
            if (!DOMUtils.containClass(document.getElementById('menu-btn'), "opened"))
                switch (event.keyCode) {
                    case 37: // left
                        left();
                        break;
                    case 39: // right
                        right();
                        break;
                }
            else
                if (event.keyCode == 27 && DOMUtils.containClass(document.getElementById('menu-btn'), 'oepned'))
                    document.getElementById('modal-div').click();
        });
    },
    
    cenariosMenu: function (event) {
        // TODO refatorar
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

};

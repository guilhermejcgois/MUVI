(function () {
    var currentItem = 0;
    
    var load = function (next) {
        var xhr;

        try {
            xhr = new XMLHttpRequest();
        } catch (e) {
            try {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("Desculpe, mas seu navegador e' suportado pelo museu. =(");
                return;
            }
        }

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                var navigationItem = JSON.parse(xhr.responseText);
                
                console.log(navigationItem);
                
                document.getElementById('title').innerHtml = navigationItem.text.name;
                document.getElementById('object-text').children[0].innerHtml = navigationItem.text.text;
                document.getElementById('divmore').innerHtml = navigationItem.toknowmore.text;
                document.getElementById('image').src = navigationItem.image.urlAddress;
            }
        };
        
        if (next) {
            xhr.open("POST", "/visita-guiada/proximo", false);
            
            currentItem++;
        } else {
            xhr.open("POST", "/visita-guiada/anterior", false);
            currentItem--;
        }
        
        xhr.send();
        
        document.getElementById('state').innerHtml = currentItem + ' de ' + numItems;
    };

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

    document.getElementById('amore').addEventListener("click", function (event) {
        var a = event.target || event.srcElement;
        var aparentparent = a.parentNode.parentNode;
        var footer = aparentparent.children[2];
        if (containClass(footer, "hide"))
            removeClass(footer, "hide");
        else
            addClass(footer, "hide");
    });
    
    load(true);

})();
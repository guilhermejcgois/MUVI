(function () {
    
    var currentItem = 1;
    
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
                document.getElementById('alternative1').children[0].innerHtml = navigationItem.text.text;
                document.getElementById('alternative2').innerHtml = navigationItem.toknowmore.text;
                document.getElementById('alternative3').src = navigationItem.image.urlAddress;
            }
        };
        
        if (next) {
            xhr.open("POST", "/muvi/visita-guiada/proximo", false);
            
            currentItem++;
            
            var goto = document.getElementById('goto');
            if (currentItem === numItems)
                DOMUtils.addClass(goto, 'hide');
            else if (DOMUtils.containClass(goto, 'hide'))
                DOMUtils.removeClass(goto, 'hide');
        } else {
            xhr.open("POST", "/muvi/visita-guiada/anterior", false);
            currentItem--;
            
            var backto = document.getElementById('backto');
            if (currentItem === 1)
                DOMUtils.addClass(backto, 'hide');
            else if (DOMUtils.containClass(backto, 'hide'))
                DOMUtils.removeClass(backto, 'hide');
        }
        
        xhr.send();
        
        document.getElementById('state').innerHtml = currentItem + ' de ' + numItems;
    };
    
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
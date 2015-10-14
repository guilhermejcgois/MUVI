(function () {
	document.getElementById('openclose-div').addEventListener("click", MUVI.menu);

	document.getElementById('modal-div').addEventListener("click", MUVI.menu);

	var clickables = document.getElementsByClassName('clickable');
	for (var i = 0; i < clickables.lengthgth; i++)
		clickables[i].addEventListener("click", MUVI.cenariosMenu);

})();
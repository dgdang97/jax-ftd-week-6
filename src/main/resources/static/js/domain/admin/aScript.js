function changeView(tab) {
	hideViews()
	document.getElementById(tab).style.display = "block"
	if (tab === 'home') {
		document.getElementById('audio').pause()
		document.getElementById('audio').load()
		document.getElementById('audio').play()
	} else {
		document.getElementById('audio').pause()
	}
}

function hideViews() {
	document.getElementById('home').style.display = "none"
	document.getElementById('newUrl').style.display = "none"
	document.getElementById('viewUrl').style.display = "none"
}

function showList() {
    document.getElementById("dropDown").style.display = "inline-block"
}
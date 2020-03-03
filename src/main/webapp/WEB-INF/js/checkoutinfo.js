function doOnClick() {
    const button = document.getElementById("buttonId");
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById("fn").removeAttribute("readonly");
        document.getElementById("ln").removeAttribute("readonly");
        document.getElementById("pa").removeAttribute("readonly");
        document.getElementById("em").removeAttribute("readonly");
        document.getElementById("ad").removeAttribute("readonly");
    } else {
        button.value = 'edit';
        send();
        document.getElementById("fn").setAttribute("readonly", true);
        document.getElementById("ln").setAttribute("readonly", true);
        document.getElementById("pa").setAttribute("readonly", true);
        document.getElementById("em").setAttribute("readonly", true);
        document.getElementById("ad").setAttribute("readonly", true);
    }
return false;
}

function send() {
    let formData = new FormData(document.forms.userdata);

    let xhr = new XMLHttpRequest();
    xhr.open("PUT", "/account");
    xhr.send(formData);

    return false;
}
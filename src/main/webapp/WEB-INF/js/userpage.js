function doOnClick(clicked_id) {
    const button = document.getElementById(clicked_id);
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById(button.previousElementSibling.id).removeAttribute("readonly");
    } else {
        button.value = 'edit';
        send();
        document.getElementById(button.previousElementSibling.id).setAttribute("readonly", true);
    }
    return false;
}

function send() {
    let formData = new FormData(document.forms.userdata);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/account");
    xhr.send(formData);

    return false;
}
function doOnClick(clicked_id) {
    const button = document.getElementById(clicked_id);
    edit(clicked_id, button.previousElementSibling.id);

    return false;
}

function edit(clicked_id, inputId) {
    const button = document.getElementById(clicked_id);
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById(inputId).removeAttribute("readonly");
    } else {
        button.value = 'edit';
        send();
        document.getElementById(inputId).setAttribute("readonly", true);
    }
}

function send() {
    let formData = new FormData(document.forms.userdata);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/account");
    xhr.send(formData);

    return false;
}
function doOnClick(clicked_id, id) {
    const button = document.getElementById(clicked_id);
    edit(clicked_id, button.previousElementSibling.id, id);

    return false;
}

function edit(clicked_id, inputId, id) {
    const button = document.getElementById(clicked_id);
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById(inputId).removeAttribute("readonly");
    } else {
        button.value = 'edit';
        send(id);
        document.getElementById(inputId).setAttribute("readonly", true);
    }
}

function send(id) {
     let formData = new FormData(document.forms.productdata);

     let xhr = new XMLHttpRequest();
     xhr.open("POST", "/manage/edit/"+id);
     xhr.send(formData);

     return false;
 }

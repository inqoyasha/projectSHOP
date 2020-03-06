function doOnClick(clicked_id, id) {
    const button = document.getElementById(clicked_id);
    if(button.value.toLowerCase() == 'edit'){
        button.value = 'save';
        document.getElementById(button.previousElementSibling.id).removeAttribute("readonly");
    } else {
        button.value = 'edit';
        send(id);
        document.getElementById(button.previousElementSibling.id).setAttribute("readonly", true);
    }

    return false;
}

function send(id) {
     let formData = new FormData(document.forms.productdata);

     let xhr = new XMLHttpRequest();
     xhr.open("POST", "/manage/edit/"+id);
     xhr.send(formData);

     return false;
 }

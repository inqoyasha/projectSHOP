function doOnClick(clicked_id, id) {
    const button = document.getElementById(clicked_id);
        switch(clicked_id) {
            case "editBtn1":
                edit(clicked_id, 'pn', id);
                break;
            case "editBtn2":
                edit(clicked_id, 'ph', id);
                break;
            case "editBtn3":
                edit(clicked_id, 'pr', id);
                break;
            case "editBtn4":
                edit(clicked_id, 'qu', id);
                break;
            case "editBtn5":
                edit(clicked_id, 'de', id);
                break;
            case "editBtn6":
                edit(clicked_id, 'ma', id);
                break;
            case "editBtn7":
                edit(clicked_id, 'ca', id);
                break;
        }
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

function doOnClick(clicked_id, id) {
    const button = document.getElementById(clicked_id);
        switch(clicked_id) {
            case "editBtn1":
                var inputId = 'pn';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn2":
                var inputId = 'ph';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn3":
                var inputId = 'pr';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn4":
                var inputId = 'qu';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn5":
                var inputId = 'de';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn6":
                var inputId = 'ma';
                edit(clicked_id, inputId, id);
                break;
            case "editBtn7":
                var inputId = 'ca';
                edit(clicked_id, inputId, id);
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

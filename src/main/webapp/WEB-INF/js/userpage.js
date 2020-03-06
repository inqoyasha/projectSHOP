function doOnClick(clicked_id) {
    switch(clicked_id) {
      case "editBtn1":
            edit(clicked_id, 'fn');
            break;
      case "editBtn2":
            edit(clicked_id, 'ln');
            break;
      case "editBtn3":
            edit(clicked_id, 'pa');
            break;
      case "editBtn4":
            edit(clicked_id, 'em');
            break;
      case "editBtn5":
            edit(clicked_id, 'ad');
            break;
       }
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
function doOnClick(clicked_id) {
    switch(clicked_id) {
      case "editBtn1":
            var inputId = 'fn';
            edit(clicked_id, inputId);
            break;
      case "editBtn2":
            var inputId = 'ln';
            edit(clicked_id, inputId);
            break;
      case "editBtn3":
            var inputId = 'pa';
            edit(clicked_id, inputId);
            break;
      case "editBtn4":
            var inputId = 'em';
            edit(clicked_id, inputId);
            break;
      case "editBtn5":
            var inputId = 'ad';
            edit(clicked_id, inputId);
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
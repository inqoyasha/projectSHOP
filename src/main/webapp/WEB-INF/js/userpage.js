function doOnClick(clicked_id) {
const button = document.getElementById(clicked_id);
switch(clicked_id) {
      case "editBtn1":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("fn").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("fn").setAttribute("readonly", true);
            }
            break;
      case "editBtn2":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("ln").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("ln").setAttribute("readonly", true);
            }
            break;
      case "editBtn3":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("pa").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("pa").setAttribute("readonly", true);
            }
            break;
      case "editBtn4":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("em").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("em").setAttribute("readonly", true);
            }
            break;
      case "editBtn5":
            if(button.value.toLowerCase() == 'edit'){
                button.value = 'save';
                document.getElementById("ad").removeAttribute("readonly");
            } else {
                button.value = 'edit';
                send();
                document.getElementById("ad").setAttribute("readonly", true);
            }
            break;
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
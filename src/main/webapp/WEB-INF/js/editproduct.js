function doOnClick(clicked_id) {
const button = document.getElementById(clicked_id);
switch(clicked_id) {
  case "editBtn1":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("pn").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("pn").setAttribute("readonly", true);
        }
        break;
  case "editBtn2":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("ph").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("ph").setAttribute("readonly", true);
        }
        break;
  case "editBtn3":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("pr").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("pr").setAttribute("readonly", true);
        }
        break;
  case "editBtn4":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("qu").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("qu").setAttribute("readonly", true);
        }
        break;
  case "editBtn5":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("de").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("de").setAttribute("readonly", true);
        }
        break;
  case "editBtn6":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("ma").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("ma").setAttribute("readonly", true);
        }
        break;
  case "editBtn7":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("ac").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("ac").setAttribute("readonly", true);
        }
        break;
  case "editBtn8":
        if(button.value.toLowerCase() == 'edit'){
            button.value = 'save';
            document.getElementById("ca").removeAttribute("readonly");
        } else {
            button.value = 'edit';
            send();
            document.getElementById("ca").setAttribute("readonly", true);
        }
        break;
}
return false;
}


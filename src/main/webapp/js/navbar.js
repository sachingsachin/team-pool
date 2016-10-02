

function addProduct() {

    var tbl = document.createElement("table");
    tbl.border=1;
    $(tbl).attr("id", "addProductTbl");

    var labelRow = tbl.insertRow(-1);
    var valueRow = tbl.insertRow(-1);

    labelRow.insertCell(-1).innerHTML = "Name";
    valueRow.insertCell(-1).innerHTML = "<input type='text'>";

    labelRow.insertCell(-1).innerHTML = "Start Date";
    valueRow.insertCell(-1).innerHTML = "<input type='text'>";

    labelRow.insertCell(-1).innerHTML = "Email";
    valueRow.insertCell(-1).innerHTML = "<input type='text'>";

    var tbody = document.createElement('tbody');
    tbl.appendChild(tbody);

    // Clear the dialog's previous children and add the new contents
    $("#dialogDiv table").remove();
    $("#dialogDiv")[0].appendChild(tbl);

    $("#dialogDiv").dialog({
      resizable: true,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "Add": function() {
          $( this ).dialog( "close" );
        },
        Cancel: function() {
          $( this ).dialog( "close" );
        }
      }
    });
}

function addTeam() {
}

function addUser() {
}

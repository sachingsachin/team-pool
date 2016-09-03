window.onload = function() {
    ajaxProductSummary();
}


function ajaxProductSummary() {
    $.ajax({
        type: "POST",
        url: "/product/summary",
        //data: data,
        success: successProductSummary,
        //dataType: dataType
    });
}

function addHeaderCell(row, html) {
    var th = document.createElement("th");
    th.innerHTML = html;
    row.appendChild(th);
}

function successProductSummary(data, responseType, xhrObject) {

    var tbl = document.createElement ("TABLE");
    tbl.border=1;
    $(tbl).attr("id", "productsTbl");
    $(tbl).addClass("tablesorter");

    $("#productsDiv")[0].appendChild(tbl);

    var header = tbl.createTHead();
    var row = header.insertRow(-1);
    addHeaderCell(row, "Name");
    addHeaderCell(row, "started");
    addHeaderCell(row, "brief description");
    addHeaderCell(row, "email");
    addHeaderCell(row, "slack channel");
    addHeaderCell(row, "jira link");
    addHeaderCell(row, "detailed docs");
    addHeaderCell(row, "github repos");
    addHeaderCell(row, "quick start examples");

    var tbody = document.createElement('tbody');
    tbl.appendChild(tbody);
    //var tbody = tbl.getElementsByTagName('tbody')[0];
    for (var i=0; i<data.products.length; i++) {
        var product = data.products[i];
        var row = tbody.insertRow(-1);

        row.insertCell(-1).innerHTML = product.name;
        row.insertCell(-1).innerHTML = product.started;
        row.insertCell(-1).innerHTML = product.briefDescription;
        row.insertCell(-1).innerHTML = product.productEmail;
        row.insertCell(-1).innerHTML = product.slackChannel;
        row.insertCell(-1).innerHTML = product.jiraLink;
        row.insertCell(-1).innerHTML = product.detailedDocsUrl;
        row.insertCell(-1).innerHTML = product.githubRepos;
        row.insertCell(-1).innerHTML = product.quickStartExampleLinks;
    }

    $("#productsTbl").tablesorter();
}

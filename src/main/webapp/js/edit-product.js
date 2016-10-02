window.onload = function() {
    ajaxProductDetail();
}


function ajaxProductDetail() {
	var currentURL = window.location.href.split('/');
	currentURL = currentURL[currentURL.length-1];
    $.ajax({
        type: "POST",
        url: "/product/detail?name="+currentURL,
        //data: data,
        success: successProductDetail,
        //dataType: dataType
    });
}

function showField (parent, label, inputType, id, value) {

	var newElements;
	if (inputType == "text") {
	    newElements = $.parseHTML(label + ": <input type=" + inputType + " id=" + id + " value=\"" + value + "\">");
	} else if (inputType == "textarea") {
		newElements = $.parseHTML(label + ":<BR><textarea id=" + id + " style='width:100%'>" + value + "</textarea>");
	}

	// DocumentFragments are DOM Nodes. They are never part of the main DOM tree.
	// Since the document fragment is in memory and not part of the main DOM tree, appending children
	// to it does not cause page reflow (computation of element's position and geometry).
	// Consequently, using document fragments often results in better performance.

	var docFrag = document.createDocumentFragment();
	for(var i = 0; i < newElements.length; i++) {
	  docFrag.appendChild(newElements[i]);
	}
	parent.appendChild(docFrag);
}

function successProductDetail (data, responseType, xhrObject) {

	if (!data || !data.product) {
		alert("Cannot find the given product. Sorry!");
		return;
	}

	var formEle = $("#editProductForm")[0];
    var tbl = document.createElement ("TABLE");
    $("#editProductForm")[0].appendChild(tbl);
    $(tbl).attr("id", "productTbl");

    var row = tbl.insertRow(-1); var cell = row.insertCell(-1);
	showField(cell, "Name", "text", "name", data.product.name);



	cell = row.insertCell(-1);
	showField(cell, "Email", "text", "productEmail", data.product.productEmail);

	cell = row.insertCell(-1);
	showField(cell, "Slack", "text", "slackChannel", data.product.slackChannel);

	row = tbl.insertRow(-1); cell = row.insertCell(-1); cell.colSpan = 3;
	showField(cell, "Detailed docs", "textarea", "detailedDocsUrl", data.product.detailedDocsUrl);

	row = tbl.insertRow(-1); cell = row.insertCell(-1); cell.colSpan = 3;
	showField(cell, "Description", "textarea", "briefDescription", data.product.briefDescription);

	row = tbl.insertRow(-1); cell = row.insertCell(-1); cell.colSpan = 3;
	showField(cell, "Github repos", "textarea", "githubRepos", data.product.githubRepos);

	row = tbl.insertRow(-1); cell = row.insertCell(-1);
	showField(cell, "Quick start examples", "text", "quickStartExampleLinks", data.product.quickStartExampleLinks);

	row = tbl.insertRow(-1); cell = row.insertCell(-1);
	showField(cell, "Slack", "text", "slackChannel", data.product.slackChannel);

	$("#productTbl > tbody > tr > td").css({"padding":"7px"});
}

/**
 * Example code when jsonform library is used.
 * Schema is obtained from http://jsonschema.net/#/ and then edited to fit the needs of jsonform.
 * But it is better not to use any form-generation library
 * because it becomes very hard to customize anything and the schema also needs to be hand-edited.
 */
function successProductDetailWithJsonForm(data, responseType, xhrObject) {

	if (!data || !data.product) {
		alert("Cannot find the given product. Sorry!");
		return;
	}

	var schema = {
			  "$schema": "http://json-schema.org/draft-04/schema#",
			  type: "object",
			  "properties": {
			    "product": {
			      type: "object",
			      "properties": {
			        "name": {
			          type: "string",
			          title: "Name"
			        },
			        "briefDescription": {
			          type: "textarea",
			          title: "Brief"
			        },
			        "productEmail": {
			          type: "string",
			          title: "Email"
			        },
			        "slackChannel": {
			          type: "string",
			          title: "Slack-channel"
			        },
			        "jiraLink": {
			          type: "string",
			          title: "Jira"
			        },
			        "detailedDocsUrl": {
			          type: "string",
			          title: "Detailed docs"
			        },
			        "githubRepos": {
			          type: "textarea",
			          title: "Github repositories"
			        },
			        "quickStartExampleLinks": {
			          type: "textarea",
			          title: "Quick start examples"
			        }
			      }
			    },
			    "teams": {
			      type: "array",
			      "items": {
			        type: "object",
			        title: "Teams",
			        "properties": {
			          "name": {
			            type: "string",
			            title: "Name"
			          },
			          "briefDescription": {
			            type: "string",
			            title: "Brief"
			          },
			          "teamHomepage": {
			            type: "string",
			            title: "Homepage"
			          }
			        }
			      }
			    },
			    "users": {
			      type: "array",
			      "items": {
			        type: "object",
			        title: "Project members",
			        "properties": {
			          "fname": {
			            type: "string",
			            title: "First name"
			          },
			          "lname": {
			            type: "string",
			            title: "Last name"
			          },
			          "id1": {
			            type: "string",
			            title: "id1"
			          },
			          "id2": {
			            type: "string",
			            title: "id2"
			          },
			          "id3": {
			            type: "string",
			            title: "id3"
			          },
			          "id4": {
			            type: "string",
			            title: "id2"
			          },
			          "status": {
			            type: "string",
			            title: "status"
			          }
			        }
			      }
			    }
			  }
			};

	$("#editProductForm").jsonForm({
      schema: schema,
      value: data,
      onSubmit: function (errors, values) {
        if (errors) {
          $('#res').html('<p>I beg your pardon?</p>');
        }
        else {
          $('#res').html('<p>Hello ' + values.name + '.' +
            (values.age ? '<br/>You are ' + values.age + '.' : '') +
            '</p>');
        }
      }
    });
}
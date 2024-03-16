loardAllDesignation();
$("#save-designation-btn").click(() => {
  saveDesignation();
});

function saveDesignation() {
  let designationName = $("#designationName").val();
  let remarks = $("#remarks").val();
  console.log(designationName, remarks);

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8001/api/v1/designation",
    async: true,
    data: JSON.stringify({
      designationName: designationName,
      remarks: remarks,
    }),
    success: function (res) {
      if (res.code == 200) {
        swal("Designation Saved!", res.message, "success");
        loardAllDesignation();
        clearAllDesignation();
      }
    },
  });
}

function clearAllDesignation() {
  $("#designationName").val(" ");
  $("#remarks").val(" ");
}
function loardAllDesignation() {
  $.ajax({
    method: "GET",
    url: "http://localhost:8001/api/v1/designation",
    async: true,
    success: function (res) {
      if (res.code == 200) {
        $("#designation-tbl-dat").empty();
        for (let designation of res.data) {
          let row = `<tr>
             <td class="px-4 text-center">${designation.did}</td>
        <td class="px-4 text-center">${designation.designationName}</td>
        <td class="px-4 text-center">${designation.remarks}</td>
            </tr>`;
          $("#designation-tbl-dat").append(row);
        }
        blindClickEventDesignation();
      }
    },
    error: function (xhr, exception) {
      swal(
        "Sorry!",
        "Opps, something went wrong. Designation Get All Error.",
        "error"
      );
    },
  });
}
function blindClickEventDesignation() {
  $("#designation-tbl-dat > tr").click(function () {
    let did = $(this).children().eq(0).text();
    let designationName = $(this).children().eq(1).text();
    let remarks = $(this).children().eq(2).text();

    $("#dId").val(did);
    $("#designationName").val(designationName);
    $("#remarks").val(remarks);
  });
}

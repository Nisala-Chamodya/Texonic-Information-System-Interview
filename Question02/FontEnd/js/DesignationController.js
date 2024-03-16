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

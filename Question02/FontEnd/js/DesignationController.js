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
        clearAllDesignation();
      }
    },
  });
}

function clearAllDesignation() {
  $("#designationName").val(" ");
  $("#remarks").val(" ");
}

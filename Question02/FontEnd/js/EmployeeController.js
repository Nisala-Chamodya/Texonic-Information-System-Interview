/*loard all designation */
loardAllDesignation();
function loardAllDesignation() {
  $.ajax({
    method: "GET",
    url: "http://localhost:8001/api/v1/designation",
    async: true,
    success: function (res) {
      if (res.code == 200) {
        $("#designationlist").empty();
        for (let designation of res.data) {
          console.log(designation.designationName);
          let row = `
             
      <option> ${designation.designationName}</option>
        
            `;
          $("#designationlist").append(row);
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

$("#empSaveBtn").click(() => {
  saveHotel();
});
function saveHotel() {
  let eId = $("#eId").val();
  let fName = $("#fName").val();
  let designation = $("#designation").val();
  let doj = $("#doj").val();
  let isManager = $("#isManager").val();

  console.log(eId, fName, designation, doj, isManager);

  $.ajax({
    method: "POST",
    contentType: "application/json",
    url: "http://localhost:8002/api/v1/employee",
    async: true,
    data: JSON.stringify({
      fullName: fName,
      designation: designation,
      dateOfJoin: doj,
      isManager: isManager,
    }),
    success: function (res) {
      if (res.code == 200) {
        swal("Employee Saved!", res.message, "success");
      }
    },
    error: function (ob) {
      swal(
        "Sorry!",
        "Opps, something went wrong. Employee Save Error.",
        "error"
      );
    },
  });
}

function loardAllEmployee() {}

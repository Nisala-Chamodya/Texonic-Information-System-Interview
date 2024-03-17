/*loard all designation */
loardAllEmployee();
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
        loardAllEmployee();
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

$("#empUpdateBtn").click(() => {
  updateEmployee();
});
$("#empDeleteBtn").click(() => {
  deleteEmployee();
});
function updateEmployee() {
  let eId = $("#eId").val();
  let fName = $("#fName").val();
  let designation = $("#designation").val();
  let doj = $("#doj").val();
  let isManager = $("#isManager").val();

  $.ajax({
    method: "PUT",
    contentType: "application/json",
    url: "http://localhost:8002/api/v1/employee/" + eId,
    async: true,
    data: JSON.stringify({
      fullName: fName,
      designation: designation,
      dateOfJoin: doj,
      isManager: isManager,
    }),
    success: function (res) {
      if (res.code == 200) {
        swal("Employee Updated!", res.message, "success");
        loardAllEmployee();
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

function loardAllEmployee() {
  $.ajax({
    method: "GET",
    url: "http://localhost:8002/api/v1/employee",
    async: true,
    success: function (res) {
      if (res.code === 200) {
        $("#emp-details").empty();
        for (let employees of res.data) {
          let row = `<tr>
                 
        <td class="px-4 text-center">${employees.emId}</td>
        <td class="px-4 text-center">${employees.fullName}</td>
        <td class="px-4 text-center">${employees.designation}</td>
        <td class="px-4 text-center">${employees.dateOfJoin}</td>
        <td class="px-4 text-center">${employees.isManager}</td>
        
        </tr>`;
          $("#emp-details").append(row);
        }
        bindClickEventEmployees();
      }
    },
    error: function (xhr, exception) {
      swal(
        "Sorry!",
        "Opps, something went wrong. Employees Get All Error.",
        "error"
      );
    },
  });
}

function clearAllEmployeeDetails() {
  $("#eId").val(" ");
  $("#fName").val(" ");
  $("#designation").val(" ");
  $("#doj").val(" ");
  $("#isManager").val("");
}
function bindClickEventEmployees() {
  $("#emp-details > tr").click(function () {
    let eid = $(this).children().eq(0).text();
    let fname = $(this).children().eq(1).text();
    let Designation = $(this).children().eq(2).text();
    let doj = $(this).children().eq(3).text();
    let isManager = $(this).children().eq(4).text();

    $("#eId").val(eid);
    $("#fName").val(fname);
    $("#designation").val(Designation);
    $("#doj").val(doj);
    $("#isManager").val(isManager);
  });
}
function deleteEmployee() {
  let eId = $("#eId").val();
  Swal.fire({
    title: "Are you sure?",
    text: "You won't be able to revert this!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Yes, delete it!",
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        url: "http://localhost:8002/api/v1/employee/" + eId,
        method: "DELETE",
        async: true,
        success: function (res) {
          if (res.code == 200) {
            Swal.fire({
              title: "Deleted!",
              text: "Your file has been deleted.",
              icon: "success",
            });
            loardAllEmployee();
            clearAllEmployeeDetails();
          }
        },
      });
    }
  });
}

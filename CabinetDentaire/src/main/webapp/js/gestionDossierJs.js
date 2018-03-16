/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showConsultation(that) {

    $.ajax({
        type: "POST",
        url: "showConsultation.action",
        data: "patientId=" + $(that).parent().prev().prev().prev().prev().prev().prev().text(),
        success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
    });
}

$(document).ready(function () {
    $('#dossierTable').dataTable();
});


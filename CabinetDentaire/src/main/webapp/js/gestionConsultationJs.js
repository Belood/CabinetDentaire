
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function fetchRow(that) {
    $("#dossierID").val($(that).parent().prev().prev().prev().prev().prev().text());
    $("#consultationNum").val($(that).parent().prev().prev().prev().prev().text());
    $("#typeConsultation").val($(that).parent().prev().prev().prev().text());
    $("#dateConsultation").val($(that).parent().prev().prev().text());
    $("#observations").val($(that).parent().prev().text());
    
}

function updateRecordConsultation() {
    $.ajax({
        type: "POST",
        url: "updateConsultation.action",
        data:"dossierID="+$("#dossierID").val()+ "&consultationNum=" + $("#consultationNum").val() + "&typeConsultation=" + $("#typeConsultation").val() +
                "&dateConsultation=" + $("#dateConsultation").val() + "&observations=" + $("#observations").val(),
        success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
    });
}

function deleteConsultation(that) {
    if (confirm('Confirmer la suppression')) {
        $.ajax({
            type: "POST",
            url: "deleteConsultation.action",
            data: "dossierID=" + (that).parent().prev().prev().prev().prev().prev().text(),
            success: function (data) {
                if (data.status === "Delete Successful") {
                    alert("Consultattion successfully deleted");
                    $(that).closest('tr').remove();

                } else {
                    alert("Suppression failed");
                }
            },
            error: function () {
                alert("Une erreur s'est produite.");
            }
        });
    }
}


$(document).ready(function () {
    $('#consultationTable').dataTable();
});

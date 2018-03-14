/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function fetchRow(that) {
    $("#patientId").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#nom").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#prenom").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#addresse").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#dateNaissance").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#numTel").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().text());
    $("#email").val($(that).parent().prev().prev().prev().prev().prev().prev().text());
    $("#profession").val($(that).parent().prev().prev().prev().prev().prev().text());
    $("#sexe").val($(that).parent().prev().prev().prev().prev().text());
    $("#age").val($(that).parent().prev().prev().prev().text());
    $("#numSS").val($(that).parent().prev().prev().text());
    $("#numAssurance").val($(that).parent().prev().text());
}

function updateRecord() {
    $.ajax({
        type: "POST",
        url: "updatePatient.action",
        data:"patientId="+$("#patientId").val()+"&nom=" + $("#nom").val() + "&prenom=" + $("#prenom").val() + "&addresse=" + $("#addresse").val() +
                "&dateNaissance=" + $("#dateNaissance").val() + "&numTel=" + $("#numTel").val()+"&email=" + $("#email").val()+"&profession=" + $("#profession").val()+
                "&sexe=" + $("#sexe").val()+"&age=" + $("#age").val()+"&numSS=" + $("#numSS").val()+"&numAssurance=" +$("#numAssurance").val(),
        success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
    });
}

function deletePatient(that) {
    if (confirm('Confirmer la suppression')) {
        $.ajax({
            type: "POST",
            url: "deletePatient.action",
            data: "patientId=" + $(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),
            success: function (data) {
                if (data.status === "Delete Successful") {
                    alert("Patient successfully deleted");
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
function showConsultation(that) {
    
        $.ajax({
            type: "POST",
            url: "showConsultation.action",
            data: "patientId=" + $(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),
            success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
        });
    }



$(document).ready(function () {
    $('#patientTable').dataTable();
});

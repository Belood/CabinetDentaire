/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function fetchRow(that) {
    $("#personnelID").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#cabinetID").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#nom").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#prenom").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#addresse").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#dateNaissance").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#numTel").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#email").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().text());
    $("#age").val($(that).parent().prev().prev().prev().prev().prev().prev().prev().text());
    $("#salaire").val($(that).parent().prev().prev().prev().prev().prev().prev().text());
    $("#dateEmbauche").val($(that).parent().prev().prev().prev().prev().prev().text());
    $("#login").val($(that).parent().prev().prev().prev().prev().text());
    $("#password").val($(that).parent().prev().prev().prev().text());
    $("#niveauDroits").val($(that).parent().prev().prev().text());
    $("#discriminator").val($(that).parent().prev().text());
}

function updateRecordEmploye() {
    $.ajax({
        type: "POST",
        url: "updateEmploye.action",
        data:"personnelID="+$("#personnelID").val()+ "&nom=" + $("#nom").val() + "&prenom=" + $("#prenom").val() +
                "&addresse=" + $("#addresse").val() + "&dateNaissance=" + $("#dateNaissance").val()+"&numTel=" + $("#numTel").val()+"&email=" + $("#email").val()+
                "&age=" + $("#age").val()+"&salaire=" + $("#salaire").val()+"&dateEmbauche=" + $("#dateEmbauche").val()+"&login=" +$("#login").val()+"&password=" +$("#password").val()
                +"&niveauDroits=" +$("#niveauDroits").val()+"&discriminator=" +$("#discriminator").val(),
        success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
    });
}

function deleteEmploye(that) {
    if (confirm('Confirmer la suppression')) {
        $.ajax({
            type: "POST",
            url: "deleteEmploye.action",
            data: "personnelID=" + $(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text(),
            success: function (data) {
                if (data.status === "Delete Successful") {
                    alert("Employe successfully deleted");
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
    $('#personnelTable').dataTable();
});

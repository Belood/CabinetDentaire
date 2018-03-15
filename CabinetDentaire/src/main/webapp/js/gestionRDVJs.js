/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function fetchRowRDV(that)
{
    $("#RdvID").val($(that).parent().prev().prev().prev().prev().prev().prev().text());
    $("#RdvNum").val($(that).parent().prev().prev().prev().prev().prev().text());
    $("#PatientID").val($(that).parent().prev().prev().prev().prev().text());
    $("#RdvDate").val($(that).parent().prev().prev().prev().text());
    $("#Heure").val($(that).parent().prev().prev().text());
    $("#Motif").val($(that).parent().prev().text());
}

function updateRecordRDV() {
    $.ajax({
        type: "POST",
        url: "updateRDV.action",
        data:"RdvNum="+$("#RdvNum").val()+"&RdvID=" + $("#RdvID").val()+"&PatientID=" + $("#PatientID").val() + "&RdvDate=" + $("#RdvDate").val() + "&Heure=" + $("#Heure").val() +
                "&Motif=" + $("#Motif").val(),
        success: function (result) {
            $("#resp").html(result.status);
        },
        error: function (result) {
            alert("Some error occured.");
        }
    });
}

function deleteRDV(that) {
    if (confirm('Confirmer la suppression')) {
        $.ajax({
            type: "POST",
            url: "deleteRDV.action",
            data: "RdvID=" + $(that).parent().prev().prev().prev().prev().prev().prev().text(),
            success: function (data) {
                if (data.status === "Delete Successful") {
                    alert("RDV successfully deleted");
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

//Help
$(document).ready(function () {
    $('#patientTable').dataTable();
});



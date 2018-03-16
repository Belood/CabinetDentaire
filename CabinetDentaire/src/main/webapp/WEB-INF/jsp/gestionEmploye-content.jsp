<%-- 
    Document   : gestionEmploye-content
    Created on : 10 mars 2018, 22:31:38
    Author     : USER
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/gestionEmployeJs.js" charset="utf-8"></script>
<div class="col-xs-2">
    <h2>Ajout d'un employe</h2>
    <s:form action="AddEmploye" method="post" enctype="multipart/form-data" theme="bootstrap" cssClass="form-vertical">
        <s:textfield placeholder="Nom" name="nom" />
        <s:textfield placeholder="Prenom" name="prenom" />
        <s:textfield placeholder="Addresse" name="addresse" />
        <s:textfield type="date" label="DateNaissance" name="dateNaissance"/>
        <s:textfield placeholder="NumTel" name="numTel" />
        <s:textfield placeholder="Email"  name="email"/>
        <s:textfield placeholder="Age"  name="age"/>
        <s:textfield placeholder="Salaire"  name="salaire"/>
        <s:textfield type="date" label="DateEmbauche" name="dateEmbauche"/>
        <s:textfield placeholder="Login"  name="login"/>
        <s:textfield placeholder="Password"  name="password"/>
        <s:select name = "niveauDroits" label = "NiveauDroits"
            list = "{0,1,2,3}" />
        <s:select name = "Discriminator" label = "Emploi"
            list="{'Dentiste','Infirmier','Secretaire'}" />
        <s:submit cssClass="btn btn-info center-block" value="Ajouter" />
    </s:form>
</div>
<div class="col-xs-10">
    <h2 class="text-center">Liste des employés</h2>
    <table class="table table-bordered table-hover table-condensed" id="personnelTable">
        <thead>
            <tr>
                <th>Personnel ID </th>
                <th>Cabinet ID </th>
                <th>Nom </th>
                <th>Prenom </th>
                <th>Addresse </th>
                <th>DateNaissance </th>
                <th>NumTel </th>
                <th>Email </th>
                <th>Age </th>
                <th>Salaire </th>
                <th>DateEmbauche </th>
                <th>Login </th>
                <th>Password </th>
                <th>NiveauDroits </th>
                <th>Discriminator </th>
                <th>Action</th>
            </tr>
        </thead>
        <s:iterator value="employeList">
            <tr>
                <td><s:property value="personnelID" /></td>
                <td><s:property value="cabinetID" /></td>
                <td><s:property value="nom" /></td>
                <td><s:property value="prenom" /></td>
                <td><s:property value="addresse" /></td>
                <td><s:property value="dateNaissance" /></td>
                <td><s:property value="numTel" /></td>
                <td><s:property value="email" /></td>
                <td><s:property value="age" /></td>
                <td><s:property value="salaire" /></td>
                <td><s:property value="dateEmbauche" /></td>
                <td><s:property value="login" /></td>
                <td><s:property value="password" /></td>
                <td><s:property value="niveauDroits" /></td>
                <td><s:property value="discriminator" /></td>
                <td>
                    <button onclick="fetchRow(this)" class="btn btn btn-info" data-toggle="modal" data-target="#updateModal">Update</button>
                    <button onclick="deleteEmploye(this)" class="btn btn btn-danger">Delete</button>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="container-fluid" id="updateForm">
    <div class="modal fade" id="updateModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Update New Information</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="hidden" name="personnelID" id="personnelID">
                                <input type="text" name="nom" id="nom" class="form-control input-sm" placeholder="Nom">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="prenom" id="prenom" class="form-control input-sm" placeholder="Prenom">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" name="addresse" id="addresse" class="form-control input-sm" placeholder="Addresse">
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="dateNaissance" id="dateNaissance" class="form-control input-sm" placeholder="Date de naissance">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="numTel" id="numTel" class="form-control input-sm" placeholder="Num Telephone">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="email" id="email" class="form-control input-sm" placeholder="Email">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="age" id="age" class="form-control input-sm" placeholder="Age">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="salaire" id="salaire" class="form-control input-sm" placeholder="salaire">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="date" name="dateEmbauche" id="dateEmbauche" class="form-control input-sm" placeholder="DateEmbauche">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="login" id="login" class="form-control input-sm" placeholder="Login">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="password" id="password" class="form-control input-sm" placeholder="Password">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="niveauDroits" id="niveauDroits" class="form-control input-sm" placeholder="NiveauDroits">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="text" name="disciminator" id="discriminator" class="form-control input-sm" placeholder="Discriminator">
                            </div>
                        </div>
                    </div>
                    <button onclick="updateRecordEmploye();" class="btn btn-info btn-block">Update</button>
                    <div id="resp" class="text-center" style="margin-top: 13px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

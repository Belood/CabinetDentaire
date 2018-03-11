<%-- 
    Document   : header
    Created on : 9 mars 2018, 19:31:36
    Author     : Alexandre
--%>
<nav class="navbar navbar-inverse fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="#">Saguenay Teeth</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Acceuil</a></li>
                <li><a href="#">Employés(Admin only)</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="GestionPatient">Gestion des patients</a></li>
                        <li><a href="#">Dossiers</a></li>
                        <li><a href="#">Rendez-vous</a></li>
                        <li><a href="#">Visites</a></li>
                    </ul>
                </li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Se deconnecter</a></li>
            </ul>
        </div>
    </div>
</nav>
<script src="${pageContext.request.contextPath}/js/headerJs.js"></script>
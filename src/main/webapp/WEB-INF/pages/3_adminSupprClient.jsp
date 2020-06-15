<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core"
	xmlns:p="http://primefaces.org/ui">

<h:head>
	<title>Facelet Ajout</title>
</h:head>
<h:body>

	<h:form>
		<p:breadCrumb>
			<p:menuitem value="Consultation" url="1_adminConsultation.xhtml" />
			<p:menuitem value="AjoutCategorie" url="1_adminAjoutCategorie.xhtml" />
			<p:menuitem value="AjoutProduit" url="1_adminAjoutProduit.xhtml" />
			<p:menuitem value="ModifCategorie" url="1_adminModifCategorie.xhtml" />
			<p:menuitem value="ModifProduit" url="1_adminModifProduit.xhtml" />
			<p:menuitem value="SupprCategorie" url="1_adminSupprCategorie.xhtml" />
			<p:menuitem value="SupprProduit" url="1_adminSupprProduit.xhtml" />
		</p:breadCrumb>
	</h:form>

	<h:form>
		<h:panelGrid columns="2">
			ID: <p:inputText value="#{clientMB.client.idClient}" />

			<h:commandButton value="Supprimer" action="#{clientMB.deleteClient}" />
		</h:panelGrid>
	</h:form>

	<h:messages />
</h:body>

</html>

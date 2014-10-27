<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>

<checkers>
<status>success</status>
<player firstName="${user.player.firstname}" lastName="${user.player.lastname}" email="${user.player.email}" id="${user.player.id}" version="${user.player.version}">
 <user username="${user.username}" id="${user.id}"/>
</player>
</checkers>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>

<checkers>
<status>success</status>
<player firstName="${user.username}" lastName="${user.lastname}" email="${user.email}" id=$"{user.id}" version=$"{user.version}">
 <user username="${user.username}" id="${user.id}"/>
</player>
</checkers>


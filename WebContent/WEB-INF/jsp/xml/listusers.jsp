<%@ page trimDirectiveWhitespaces="true" isELIgnored="false" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>
<checkers>
	<status>success</status>
	<players>
		<c:forEach var="user" items="${users}">
		<player firstName="${user.player.firstName}" lastName="${user.player.lastName}" email="${user.player.email}" id="${user.player.id}" version="${user.player.version}">
			<user username="${user.username}" id="${user.id}" version="${user.version}" />
		</player>
		</c:forEach>
	</players>
</checkers>
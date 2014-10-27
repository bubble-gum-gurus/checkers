<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>
<checkers>
<status>success</status>
 <games>
<c:forEach var="game" items="${games}">
  <game id="${game.id}" status="${game.status.id}">
   <firstPlayer refid="${game.firstPlayer.id}" />
   <secondPlayer refid="${game.secondPlayer.id}" />
   <currentPlayer refid="${game.currentPlayer.id}" />
   <pieces>
    <c:forEach items="${game.pieces}" var="row"> 
    	<c:forEach items="${row}" var="char">                   
        	<c:out value="${char}"/>
    	</c:forEach>
	</c:forEach>
   </pieces>
  </game>
</c:forEach>
 </games>
</checkers>
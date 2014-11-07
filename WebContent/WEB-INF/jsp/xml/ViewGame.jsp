<%@ page trimDirectiveWhitespaces="true" isELIgnored="false" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>
<checkers>
<status>success</status>
  <game id="${game.id}" status="${game.status.id}">
   <firstPlayer refid="${game.firstPlayer.id}" />
   <secondPlayer refid="${game.secondPlayer.id}" />
   <currentPlayer refid="${game.currentPlayer.id}" />
   <pieces>${game}</pieces>
  </game>
</checkers>

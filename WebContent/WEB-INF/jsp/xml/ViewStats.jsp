<%@ page trimDirectiveWhitespaces="true" isELIgnored="false" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8"?>

<checkers>
<status>success</status>
<player firstName="Stuart" lastName="Thiel" email="sthiel@encs.concordia.ca" id="1" version="1">
 <user username="sthiel" id="1" version="1">
 <games>
  <game id="1" status="0">
  <firstPlayer refid="1" />
  <secondPlayer refid="2" />
  <currentPlayer refid="1" />
  </game>
  <game id="2" status="1">
  <firstPlayer refid="1" />
  <secondPlayer refid="2" />
  <currentPlayer refid="1" />
  </game>
 </games>
</player>
</checkers>
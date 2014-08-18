<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="langs"
	class="hr.web.aplikacije.i18n.SupportedLanguages" scope="request" />
<c:set var="locale" value="${ param.locale }" />
<c:if test="${((locale == null) || (locale eq '')) }">
	<c:set var="locale" value="hr" />
</c:if>
<c:forEach items="${langs.getLangs() }" var="lang">
	<c:if test="${ locale ne lang.getLanguage() }">
		<a href='<c:out value="?locale=${lang.getLanguage()}" />'
			id="languageLink"> <c:out value="${lang.getDisplayLanguage()}" /></a>
	</c:if>
</c:forEach>
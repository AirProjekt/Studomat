<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="langs"
	class="hr.web.aplikacije.i18n.SupportedLanguages" scope="request" />
<c:set var="resName" value="messages_hr" />
<c:if test="${((param.locale!= null) && !(param.locale eq '')) }">
	<c:forEach items="${langs.getLangs() }" var="lang">
		<c:if test="${param.locale eq lang.getLanguage() }">
			<c:set var="resName" value="messages_${param.locale}" />
		</c:if>
	</c:forEach>
</c:if>
<fmt:setBundle scope="request" basename="${ resName }" />
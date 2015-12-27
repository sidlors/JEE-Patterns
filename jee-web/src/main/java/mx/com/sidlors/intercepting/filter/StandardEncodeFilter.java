package mx.com.sidlors.intercepting.filter;

import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StandardEncodeFilter extends BaseEncodeFilter {
	// Creates new StandardEncodeFilter
	public StandardEncodeFilter() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws java.io.IOException, javax.servlet.ServletException {

		String contentType = servletRequest.getContentType();
		if ((contentType == null) || contentType.equalsIgnoreCase("application/x-www-form-urlencoded")) {
			translateParamsToAttributes(servletRequest, servletResponse);
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	private void translateParamsToAttributes(ServletRequest request, ServletResponse response) {
		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] values;
			values = request.getParameterValues(paramName);
			if (values.length == 1)
				request.setAttribute(paramName, values[0]);
			else
				request.setAttribute(paramName, values);
		}
	}
}
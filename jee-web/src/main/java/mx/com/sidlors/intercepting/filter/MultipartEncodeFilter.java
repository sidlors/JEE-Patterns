package mx.com.sidlors.intercepting.filter;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;


public class MultipartEncodeFilter extends BaseEncodeFilter {
	
	
	private static final Logger logger = Logger.getLogger(MultipartEncodeFilter.class);

	public MultipartEncodeFilter() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws java.io.IOException, ServletException {

		String contentType = servletRequest.getContentType();
		// Only filter this request if it is multipart encoding
		if (contentType.startsWith("multipart/form-data")) {
			try {
				String uploadFolder = getFilterConfig().getInitParameter("UploadFolder");
				if (uploadFolder == null)
					uploadFolder = ".";
				/**
				 * The MultipartRequest class is: Copyright (C) 2001 by Jason
				 * Hunter <jhunter@servlets.com>. All rights reserved.
				 **/
				MultipartRequest multi = new MultipartRequest(servletRequest, uploadFolder, 1 * 1024 * 1024);
				Enumeration params = multi.getParameterNames();
				while (params.hasMoreElements()) {
					String name = (String) params.nextElement();
					String value = multi.getParameter(name);
					servletRequest.setAttribute(name, value);
				}
				Enumeration files = multi.getFileNames();
				while (files.hasMoreElements()) {
					String name = (String) files.nextElement();
					String filename = multi.getFilesystemName(name);
					String type = multi.getContentType(name);
					File f = multi.getFile(name);
					// At this point, do something with the
					// file, as necessary
				}
			} catch (IOException e) {
				logger.error("error reading or saving file" + e);
			}
		} // end if
		filterChain.doFilter(servletRequest, servletResponse);
	} // end method doFilter()
}
package org.icec.web.common;

import org.springframework.beans.factory.annotation.Value;

public class BaseController {
	@Value("${default_page_size}")  
	private int default_page_size=10;

	public int getDefault_page_size() {
		return default_page_size;
	}

	public void setDefault_page_size(int default_page_size) {
		this.default_page_size = default_page_size;
	} 
	 
}

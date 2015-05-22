package cn.cms.test;

import javax.servlet.http.Cookie;

public class MyCookie extends Cookie{

	public MyCookie(String name, String value) {
		super(name, value);
	}

	@Override
	public String toString() {
		return "Cookie [getName()=" + getName() + ", getValue()="
				+ getValue() + ", getMaxAge()=" + getMaxAge()
				+ ", getComment()=" + getComment() + ", getDomain()="
				+ getDomain() + ", getPath()=" + getPath() + ", getSecure()="
				+ getSecure() + ", getVersion()=" + getVersion()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}


	
}

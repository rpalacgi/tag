package com.robbi.tag;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import javax.servlet.jsp.*;
import java.io.*;

public class SimpleTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print("Cool!");
	}
}
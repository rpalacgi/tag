package com.robbi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TagController {
	@RequestMapping(value = "/simpletag", method = RequestMethod.GET)
	public String showSimpleTag() {
		return "simpleTag";
	}
	
	@RequestMapping(value = "/hellotag", method = RequestMethod.GET)
	public String showHelloTag() {
		return "helloTag";
	}
	
	@RequestMapping(value = "/bodytag", method = RequestMethod.GET)
	public String showBodyTag() {
		return "bodyTag";
	}
	
	@RequestMapping(value = "/attributetag", method = RequestMethod.GET)
	public String showAttributeTag() {
		return "attributeTag";
	}
	
	@RequestMapping(value = "/cubetag", method = RequestMethod.GET)
	public String showCubeTag() {
		return "cubeTag";
	}
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String showPrintRecordTag() {
		return "printRecordTag";
	}
}

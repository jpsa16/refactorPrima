package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.productos.models.service.fabrica.LoggerDemo;
import com.formacionbdi.springboot.app.productos.models.service.fabrica.LoggerFabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private LoggerFabrica loggerFabrica;
	
	@GetMapping("/listar")
	public String listar(){
		LoggerDemo logToConsole = loggerFabrica.getLoggerDemo("logToConsole");
		LoggerDemo logToFile = loggerFabrica.getLoggerDemo("logToFile");
		LoggerDemo logToDatabase = loggerFabrica.getLoggerDemo("logToDatabase");

		/*logToConsole.logMessage("mensaje logToConsole message");
		logToConsole.logWarning("mensaje logToConsole warning");
		logToConsole.logError("mensaje logToConsole error");

		logToFile.logMessage("mensaje logToFile message");
		logToFile.logWarning("mensaje logToFile warning");
		logToFile.logError("mensaje logToFile error");*/

		logToDatabase.logMessage("logToDatabase message");
		logToDatabase.logWarning("logToDatabase warning");
		logToDatabase.logError("logToDatabase error");

		return "ok";
	}
	

}

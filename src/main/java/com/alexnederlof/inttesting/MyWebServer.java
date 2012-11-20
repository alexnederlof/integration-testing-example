package com.alexnederlof.inttesting;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Simple Webserver backed by Jetty that can used as a main class.
 */
public class MyWebServer {

	public static final int PORT = 9090;
	public static final String BASE_URL = "http://localhost:" + PORT + '/';

	public static void main(String[] args) throws Exception {
		MyWebServer server = new MyWebServer();
		server.start();
		server.join();
	}

	public static WebAppContext buildWebAppContext() {
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setWar(new File("src/main/webapp/").getAbsolutePath());
		return webAppContext;
	}

	private final Server server;

	public MyWebServer() {
		this.server = new Server(PORT);
		server.setHandler(buildWebAppContext());
	}

	public void start() throws Exception {
		server.start();
	}

	public void stop() throws Exception {
		server.stop();
	}

	private void join() throws InterruptedException {
		server.join();
	}

}

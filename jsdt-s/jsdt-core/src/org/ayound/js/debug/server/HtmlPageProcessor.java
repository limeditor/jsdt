/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2008-2011 ayound@gmail.com
 * This program and the accompanying materials
 * are made available under the terms of the Apache License 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 * All rights reserved.
 *
 * Created on 2008-10-26
 *******************************************************************************/
package org.ayound.js.debug.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import org.ayound.js.debug.engine.CharsetDetector;
import org.ayound.js.debug.resource.JsResourceManager;
import org.ayound.js.debug.script.ScriptCompileUtil;
import org.mozilla.javascript.EvaluatorException;

/**
 *
 * the processor to resolver home page. the home page have some html code and
 * javascript code
 */
public class HtmlPageProcessor extends AbstractProcessor {

	public HtmlPageProcessor(String requestUrl, String postData,
			JsDebugResponse response,
			Map<String, String> requestHeader, ResponseInfo info) {
		super(requestUrl, postData, response,  requestHeader, info);
	}

	@Override
	public synchronized void process() {
		try {
			URL url = this.computeRemoteURL();
			String resourcePath = url.getPath();
			JsResourceManager.createFile(resourcePath, getInfo());
			String realPath = JsResourceManager.getResourceRealPath(resourcePath);
			String encoding = getInfo().getEncoding();
			if (encoding == null||"gzip".equals(encoding)) {
				CharsetDetector detector = new CharsetDetector();
				detector.detect(realPath);
				encoding = detector.getCharset();
			}
			JsDebugServer.setDefaultEncoding(getInfo().getEncoding());
			getResponse().writeHTMLHeader(encoding,
					getInfo().getResponseHeader());
			// write debug javascript file before any one
			getResponse()
					.writeln("<script type=\"text/javascript\">", encoding);
			InputStream inputStream = HtmlPageProcessor.class
					.getResourceAsStream("debug.js");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String line = null;
			int debugLine = 2;
			try {
				while ((line = reader.readLine()) != null) {
					getResponse().writeln(line, encoding);
					debugLine++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				inputStream.close();
				reader.close();
			}
			JsDebugServer.setDebugLine(debugLine);

			getResponse().writeln("</script>", encoding);
			StringBuffer buffer = new StringBuffer();
			InputStream homeStream = new FileInputStream(realPath);
			BufferedReader homeInputStream = new BufferedReader(
					new InputStreamReader(homeStream, encoding));
			line = null;
			while ((line = homeInputStream.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			String scriptContent = buffer.toString();
			JsDebugServer.addHtmlPage(realPath);
			JsDebugServer.addResource(realPath);
			// compile html file by javascript engine
			try {
				JsDebugServer.getJsEngine()
						.compileHtml(realPath, scriptContent);
			} catch (EvaluatorException e) {
				JsDebugServer.compileError(e.getMessage(), realPath,
						e.getLineNumber());
			}
			String[] lines = scriptContent.split("\n");
			for (int i = 0; i < lines.length; i++) {
				String htmlLine = lines[i];
				String jsLine = htmlLine;
				if (JsDebugServer.getJsEngine().canBreakLine(realPath, i + 1)) {
					jsLine = ScriptCompileUtil.compileHtmlLine(lines,
							realPath, i);//
				}
				getResponse().writeln(jsLine, encoding);
			}
			lines = null;
			scriptContent = null;
			buffer = null;
			try {
				homeInputStream.close();
			} catch (IOException e) {

			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			getResponse().close();
		}
	}
}

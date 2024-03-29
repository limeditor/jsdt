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
package org.ayound.js.debug.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ayound.js.debug.model.JsDebugStackFrame;
import org.ayound.js.debug.resource.JsResourceManager;
import org.ayound.js.debug.server.IDebugServer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class JsDebugCorePlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.ayound.js.debug.core";

	public static final String MODEL_ID = "org.ayound.js.debug.model";

	// The shared instance
	private static JsDebugCorePlugin plugin;

	// record the used port
	private static Set<Integer> usedPorts = new HashSet<Integer>();

	private List<IResourceListener> resourceListeners = new ArrayList<IResourceListener>();

	private List<IEvalListener> evalListeners = new ArrayList<IEvalListener>();

	public void usePort(int port) {
		usedPorts.add(port);
	}

	public boolean hasPort(int port) {
		return usedPorts.contains(port);
	}

	public void removePort(int port) {
		usedPorts.remove(port);
	}

	/**
	 * The constructor
	 */
	public JsDebugCorePlugin() {
		plugin = this;
	}

	public void addEvalListener(IEvalListener listener) {
		evalListeners.add(listener);
	}

	public void removeEvalListener(IEvalListener listener) {
		evalListeners.remove(listener);
	}

	public void addResourceListener(IResourceListener listener) {
		resourceListeners.add(listener);
	}

	public void updateEval(final JsDebugStackFrame frame) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				for (IEvalListener listener : evalListeners) {
					listener.update(frame);
				}
			}
		});
	}

	public void removeResourceListener(IResourceListener listener) {
		resourceListeners.remove(listener);
	}

	public void addResource(final String resource, final IDebugServer server) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				for (IResourceListener listener : resourceListeners) {
					listener.addResource(resource, server);
				}
			}
		});
	}

	public void removeResource(final String resource, final IDebugServer server) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				for (IResourceListener listener : resourceListeners) {
					listener.removeResource(resource, server);
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		JsResourceManager.removeDebugProject();
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static JsDebugCorePlugin getDefault() {
		return plugin;
	}

}

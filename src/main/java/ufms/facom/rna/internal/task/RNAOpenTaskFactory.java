package ufms.facom.rna.internal.task;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

import ufms.facom.rna.internal.RNACreateNetworkAction;
import ufms.facom.rna.internal.util.RNAUtil;

public class RNAOpenTaskFactory implements TaskFactory {

	private final CySwingApplication swingApplication;
	private final CyServiceRegistrar registrar;
	private final RNAUtil rnaUtil;
	private final RNACreateNetworkAction createNetworkAction;
	
	public RNAOpenTaskFactory(	final CySwingApplication swingApplication,
			 					final CyServiceRegistrar registrar,
			 					final RNAUtil rnaUtil,
			 					final RNACreateNetworkAction createNetworkAction) {
		this.swingApplication = swingApplication;
		this.registrar = registrar;
		this.rnaUtil = rnaUtil;
		this.createNetworkAction = createNetworkAction;
	}
	
	@Override
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new RNAOpenTask(swingApplication, registrar, rnaUtil, createNetworkAction));
	}

	@Override
	public boolean isReady() {
		return !rnaUtil.isOpened();
	}

}

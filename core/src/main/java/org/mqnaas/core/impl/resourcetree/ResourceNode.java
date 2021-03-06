package org.mqnaas.core.impl.resourcetree;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.mqnaas.core.api.IApplication;
import org.mqnaas.core.api.IResource;

/**
 * 
 * @author Isart Canyameres Gimenez (i2cat)
 * 
 */
public class ResourceNode {

	private IResource				content;

	private ApplicationNode			parent;
	private Class<? extends IApplication> parentInterface;
	
	private List<CapabilityNode>	children;
	

	public ResourceNode() {
		children = new CopyOnWriteArrayList<CapabilityNode>();
	}

	public ResourceNode(IResource resource) {
		this();
		content = resource;
	}

	public ResourceNode(IResource resource, ApplicationNode parent, Class<? extends IApplication> parentInterface) {
		this();
		content = resource;
		this.parent = parent;
		this.parentInterface = parentInterface;
	}

	/**
	 * @return the content
	 */
	public IResource getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(IResource content) {
		this.content = content;
	}

	/**
	 * @return the parent
	 */
	public ApplicationNode getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(ApplicationNode parent) {
		this.parent = parent;
	}

	/**
	 * @return the children
	 */
	public List<CapabilityNode> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<CapabilityNode> children) {
		this.children = children;
	}

	/**
	 * 
	 * @return the parentInterface
	 */
	public Class<? extends IApplication> getParentInterface() {
		return parentInterface;
	}

	/**
	 * 
	 * @param parentInterface the parentInterface to set
	 */
	public void setParentInterface(Class<? extends IApplication> parentInterface) {
		this.parentInterface = parentInterface;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder(getClass().getSimpleName());
		sb.append(" [");
		
		sb.append("resource=").append(content);
//		sb.append(", parent=").append(parent).append(" (").append(parentInterface).append(")");
		sb.append(", children:");
		
		for ( CapabilityNode child : children ) {
			sb.append("\n  ").append(child);
		}

		sb.append("]");
		
		return sb.toString();
	}

}

package org.icec.common.model;

public class JsTreeData {
	private String id;
	private String parent;
	private String text;
	private TreeState state;
	private Object ext;
	public JsTreeData() {}
	public JsTreeData(String id, String parent, String text,Object ext) {
		super();
		this.id = id;
		this.parent = parent;
		this.text = text;
		this.state = new TreeState(false);
		this.ext=ext;
	}
	public JsTreeData(String id, String parent, String text, boolean opened,Object ext) {
		super();
		this.id = id;
		this.parent = parent;
		this.text = text;
		this.state = new TreeState(opened);
		this.ext=ext;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getParent() {
		return parent;
	}


	public void setParent(String parent) {
		this.parent = parent;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public TreeState getState() {
		return state;
	}


	public void setState(TreeState state) {
		this.state = state;
	}

	public class TreeState{
		private boolean opened=false ;
		private boolean disabled=false;
		private boolean selected=false;
		public TreeState(){}
		public TreeState(boolean opened){
			this.opened=opened;
		}
		public boolean isOpened() {
			return opened;
		}

		public void setOpened(boolean opened) {
			this.opened = opened;
		}
		public boolean isDisabled() {
			return disabled;
		}
		public void setDisabled(boolean disabled) {
			this.disabled = disabled;
		}
		public boolean isSelected() {
			return selected;
		}
		public void setSelected(boolean selected) {
			this.selected = selected;
		}
		
	}

	public Object getExt() {
		return ext;
	}
	public void setExt(Object ext) {
		this.ext = ext;
	}
	

}


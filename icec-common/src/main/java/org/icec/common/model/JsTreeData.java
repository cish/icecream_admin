package org.icec.common.model;

public class JsTreeData {
	private String id;
	private String parent;
	private String text;
	private TreeState state;
	public JsTreeData() {}
	public JsTreeData(String id, String parent, String text) {
		super();
		this.id = id;
		this.parent = parent;
		this.text = text;
		this.state = new TreeState(false);
	}
	public JsTreeData(String id, String parent, String text, boolean opened) {
		super();
		this.id = id;
		this.parent = parent;
		this.text = text;
		this.state = new TreeState(opened);
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
	

}


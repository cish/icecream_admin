package org.icec.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.icec.common.model.JsTreeData;
import org.icec.common.model.TreeModel;

public class TreeBuild {
	/** 
     * 使用递归方法建树 
     * @param TreeModels 
     * @return 
     */  
    public static List<? extends TreeModel> buildByRecursive(List<? extends TreeModel> treeModels) {
    	 
        List<TreeModel> trees = new ArrayList<TreeModel>();  
        for (TreeModel treeModel : treeModels) {  
            if ((treeModel.getParentId()==0)) {  
                findChildren(treeModel,treeModels,trees);  
            }  
        }  
        return trees;  
    }  
  
    /** 
     * 递归查找子节点 
     * @param TreeModels 
     * @return 
     */  
    private static void findChildren(TreeModel treeModel,List<? extends TreeModel> treeModels,List<TreeModel> trees) {  
    	trees.add(treeModel);
    	//treeModels.remove(treeModel);
    	boolean flag=false;
    	for (TreeModel it : treeModels) { 
    		
    		 if(treeModel.getId().equals(it.getParentId())) {  
    			 findChildren(it,treeModels,trees); 
    			 flag=true; 
    		 }else {
    			 if(flag==true) {
    				 break;
    			 }
    		 }
        }  
       
    }  
    
    public static List<JsTreeData> buildJsTree(List<? extends TreeModel> treeModels) {
    	 List<JsTreeData> trees = new ArrayList<JsTreeData>();  
         for (TreeModel treeModel : treeModels) {  
             if ((treeModel.getParentId()==0)) { 
            	 JsTreeData data=new JsTreeData(treeModel.getId()+"","#",treeModel.getName(), true,treeModel);
            	 trees.add(data);
                 findChildren2jstree(treeModel,treeModels,trees);  
             }  
         }  
    	return trees;
    }
    private static void  findChildren2jstree (TreeModel treeModel,List<? extends TreeModel> treeModels,List<JsTreeData> trees) {  
    	for (TreeModel it : treeModels) { 
    		 if(treeModel.getId().equals(it.getParentId())) {  
    			 JsTreeData data=new JsTreeData(it.getId()+"",it.getParentId()+"",it.getName(),it);
            	 trees.add(data);
    			 findChildren2jstree(it,treeModels,trees); 
    		 } 
        }  
       
    }  
    
    
    
}

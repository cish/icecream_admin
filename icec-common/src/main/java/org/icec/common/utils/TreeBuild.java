package org.icec.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.icec.common.model.TreeModel;

public class TreeBuild {
	/** 
     * 使用递归方法建树 
     * @param TreeModels 
     * @return 
     */  
    public static List<?> buildByRecursive(List<?> treeModels) {
    	List<TreeModel> treeModels2=(List<TreeModel>) treeModels;
        List<TreeModel> trees = new ArrayList<TreeModel>();  
        for (TreeModel treeModel : treeModels2) {  
            if ((treeModel.getPid()==0)) {  
                findChildren(treeModel,treeModels2,trees);  
            }  
        }  
        return trees;  
    }  
  
    /** 
     * 递归查找子节点 
     * @param TreeModels 
     * @return 
     */  
    private static void findChildren(TreeModel treeModel,List<TreeModel> treeModels,List<TreeModel> trees) {  
    	trees.add(treeModel);
    	//treeModels.remove(treeModel);
    	boolean flag=false;
    	for (TreeModel it : treeModels) { 
    		
    		 if(treeModel.getId().equals(it.getPid())) {  
    			 findChildren(it,treeModels,trees); 
    			 flag=true; 
    		 }else {
    			 if(flag==true) {
    				 break;
    			 }
    		 }
        }  
       
    }  
}

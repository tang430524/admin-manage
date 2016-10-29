package org.bumishi.admin.domain.modle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xieqiang on 2016/10/29.
 * id   label   path        level order
 * 1    水果      0           1   1
 * 2    苹果      0,1         2   1
 * 3    梨子      0,1         2   2
 * 4    雪梨      0,1,3       3   1
 * 5    鸭梨      0,1,3       3   2
 */
public class TreeModel {

    private int id;

    private String label;

    private String path="0";  //父节点的路径与父节点的id路径，用","分开，0表示父节点是根节点

    private int order=1;  //排序

    private List<TreeModel> childNodes=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLevel() {
        return path.split(",").length;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public TreeModel newChildNode(int nodeId,String label,int order){
        TreeModel node=new TreeModel();
        node.path =this.path +","+this.id;
        node.id=nodeId;
        node.order=order;
        node.label=label;
        return node;
    }

    @Override
    public String toString() {
        return label+"-"+ path +"-"+id+"-"+order;
    }

    public static List<TreeModel> buildTree(List<TreeModel> nodes){
        if(nodes==null || nodes.isEmpty()){
            return null;
        }
        List<TreeModel> firstLevels=nodes.stream().filter(node->node.getLevel()==1).collect(Collectors.toList());
        firstLevels.sort((node1,node2)->Integer.valueOf(node1.getOrder()).compareTo(Integer.valueOf(node2.getOrder())));
        firstLevels.stream().forEach(node-> findChild(node,nodes));
        return firstLevels;
    }

    private static void findChild(TreeModel currentNode,List<TreeModel> nodeList){
        List<TreeModel> childrens=nodeList.stream().filter(node->node.getPath().equals(currentNode.getPath()+","+currentNode.getId())).collect(Collectors.toList());
        currentNode.childNodes=childrens;
        if(childrens==null || childrens.isEmpty()){
            return;
        }
        childrens.sort((node1,node2)->Integer.valueOf(node1.getOrder()).compareTo(Integer.valueOf(node2.getOrder())));
        childrens.stream().forEach(node->findChild(node,nodeList));

    }

    public static void show(List<TreeModel> nodes){
       if(nodes==null || nodes.isEmpty()){
           return;
       }
        nodes.sort((o1,o2)->Integer.valueOf(o1.getOrder()).compareTo(Integer.valueOf(o2.getOrder())));
       nodes.sort((o1, o2) -> (o1.getPath()+","+o1.getId()).compareTo(o2.getPath()+","+o2.getId()));

       nodes.stream().forEach(node->{
           for(int i=1;i<node.getLevel();i++){
                      System.out.print("\t");
           }
           System.out.println(node);
       });
    }

    public static void printTree(List<TreeModel> nodes){
        if(nodes==null || nodes.isEmpty()){
            return;
        }
        nodes.forEach(item->{
            System.out.println(item);
            printTree(item.childNodes);
        });
    }

    public static void main(String[] arg){
        List<TreeModel> nodes=new ArrayList<>();
        TreeModel fruit=new TreeModel();
        fruit.setId(1);
        fruit.setLabel("水果");
        fruit.setPath("0");
        fruit.setOrder(2);
        nodes.add(fruit);

        TreeModel apple=fruit.newChildNode(7,"苹果",2);
        nodes.add(apple);
        nodes.add(apple.newChildNode(4,"红富士",2));
        nodes.add(apple.newChildNode(15,"山东苹果",1));

        TreeModel lizi=fruit.newChildNode(8,"梨子",1);
        nodes.add(lizi);
        nodes.add(lizi.newChildNode(77,"雪梨",1));
        nodes.add(lizi.newChildNode(31,"鸭梨",2));

        TreeModel shucai=new TreeModel();
        shucai.setId(101);
        shucai.setLabel("蔬菜");
        shucai.setPath("0");
        shucai.setOrder(1);
         nodes.add(shucai);
        nodes.add(shucai.newChildNode(213,"白菜",2));
       // TreeModel.show(nodes);

        List<TreeModel> tree=TreeModel.buildTree(nodes);

          printTree(tree);






    }

}

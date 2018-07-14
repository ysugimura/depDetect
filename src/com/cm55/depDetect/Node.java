package com.cm55.depDetect;


public interface Node {

  /** 名称を取得する */
  public String getName();
  
  /** ツリー構造のルートを取得する */
  public PkgNode getRoot();
  
  /** このノードの親パッケージを得る */
  public PkgNode getParent();
  
  /** このノード以下のノードをすべて訪問する */
  public void visit(Visitor<Node> visitor);
  
  /** このノード以下のすべてのクラスノードを訪問する */
  public void visitClasses(Visitor<ClsNode>visitor);

  /** このノード以下のすべてのパッケージノードを訪問する */
  public void visitPackages(Visitor<PkgNode>visitor);
}

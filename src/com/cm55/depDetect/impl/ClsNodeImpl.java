package com.cm55.depDetect.impl;

import com.cm55.depDetect.*;

/**
 * クラスノード
 * @author ysugimura
 */
public class ClsNodeImpl extends NodeImpl implements ClsNode {
 
  /** import文配列 */
  public final Imports imports;

  /** このクラスが依存するパッケージノード集合 */
  private RefsImpl depsTo;

  /** このクラスが依存する不明import文集合 */
  private UnknownsImpl unknowns;
  
  /**
   * 親ノード、クラス名称、import文配列を指定する
   * @param parent このクラスノードの親となるパッケージノード
   * @param name クラス名称
   * @param imports import文配列
   */
  public ClsNodeImpl(PkgNodeImpl parent, String name, Imports imports) {
    super(parent, name);
    check();
    this.imports = imports;
  }   

  @Override
  public NodeKind getKind() {
    return NodeKind.CLASS;
  }
  
  @Override
  public RefsImpl getDepsTo() {
    return depsTo;
  }

  @Override
  public UnknownsImpl getUnknowns() {
    return unknowns;
  }
  
  /** 依存を構築し、自身に格納する */
  ClsDeps buildDeps() {
    ClsDeps clsDeps = imports.createDependencies(this.parent);
    this.depsTo = clsDeps.depends;
    this.unknowns = clsDeps.unknowns;
    return clsDeps;
  }
}

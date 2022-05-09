package com.missiongroup.starring.modular.vhis.data.websocket.consistenthash;

public class VirtualNode<T extends Node> implements Node {
    final T physicalNode;
    final int replicaIndex;

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.replicaIndex = replicaIndex;
        this.physicalNode = physicalNode;
    }

    @Override
    //返回虚拟节点hash key值
    public String getKey() {
        return physicalNode.getKey() + "_" + replicaIndex;
    }
    //判断是否为同一个虚拟节点
    public boolean isVirtualNodeOf(T pNode) {
        return physicalNode.getKey().equals(pNode.getKey());
    }
    //返回虚拟节点对应的物理节点编号
    public T getPhysicalNode() {
        return physicalNode;
    }
}

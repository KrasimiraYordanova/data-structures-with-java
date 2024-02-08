package exercises.lab01LinearDataStructure_exercises.Interfaces;


import implementations.Tree;

import java.util.List;

public interface AbstractTree<E> {
    List<E> orderBfs();
    List<E> orderDfs();
    void addChild(E parentKey, Tree<E> child);
    void removeNode(E nodeKey);
    void swap(E firstKey, E secondKey);
}

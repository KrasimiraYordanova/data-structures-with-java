package exercises.lab01LinearDataStructure_exercises.implementations;

import exercises.lab01LinearDataStructure_exercises.Interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for(Tree<E> child : children) {
            this.children.add(child);
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> childrenQueue = new java.util.ArrayDeque<>();

        childrenQueue.offer(this);

        while(!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            result.add(current.key);

            for(Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);

        return result;
    }

    private void doDfs(Tree<E> treeNode, List<E> result) {
        for(Tree<E> child : treeNode.children) {
            this.doDfs(child, result);
        }

        result.add(treeNode.key);
    }


    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = find(parentKey);

        if(search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    private Tree<E> find(E parentKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while(!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if(current.key.equals(parentKey)) {
                return current;
            }

            for(Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }
        return null;
    }

    @Override
    public void removeNode(E nodeKey) {

    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }
}


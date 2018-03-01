package com.pramati.learning;

import com.pramati.learning.observable.impl.BlogPost;
import com.pramati.learning.observer.impl.Subscriber;

public class App {
    public static void main(String[] args){
        Subscriber p1=new Subscriber();
        p1.setName("John");
        BlogPost post=new BlogPost();
        post.setPostName("Trie");
        post.setData("In computer science, a trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes), is a kind of search tree—an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings. Unlike a binary search tree, no node in the tree stores the key associated with that node; instead, its position in the tree defines the key with which it is associated. All the descendants of a node have a common prefix of the string associated with that node, and the root is associated with the empty string. Values are not necessarily associated with every node. Rather, values tend only to be associated with leaves, and with some inner nodes that correspond to keys of interest. For the space-optimized presentation of prefix tree, see compact prefix tree.");
        post.subscribe(p1);
        post.setData(post.getData()+" new update ");
        post.subscribe(new Subscriber("Jane"));
        post.setData(post.getData()+" some update ");

    }
}

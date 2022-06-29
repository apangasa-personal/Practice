package scaler.DSA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
             // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();
             // @return the single integer that this NestedInteger holds, if it holds a single integer
             // Return null if this NestedInteger holds a nested list
             public Integer getInteger();
             // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return empty list if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
}

public class FlattenNestedListIterator implements Iterator<Integer> {
    Stack<NestedInteger> elements = new Stack<>();
    FlattenNestedListIterator(ArrayList<NestedInteger> nestedList) {
        if(nestedList == null)
            return;
        for(int i = 0; i<nestedList.size();i++)
            elements.push(nestedList.get(i));
    }
    @Override
    public boolean hasNext() {
        while(!elements.isEmpty()){
            NestedInteger top = elements.peek();
            if(top.isInteger()){
                return true;
            }else{
                elements.pop();
                for(int i=top.getList().size()-1; i>=0; i--){
                    elements.push(top.getList().get(i));
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return elements.pop().getInteger();
    }
}

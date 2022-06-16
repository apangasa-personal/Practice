package leetCode;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}


class FreqStack {
    HashMap<Integer, Integer> frequencies;
    HashMap<Integer, Stack<Integer>> frequencyStack;
    public FreqStack() {
        frequencies = new HashMap<>();
        frequencyStack = new HashMap<>();
    }

    public void push(int val) {
        frequencies.put(val, frequencies.getOrDefault(val,0) + 1);
        int frequencyOfVal = frequencies.get(val);
        if(frequencyStack.get(frequencyOfVal) == null)
            frequencyStack.put(frequencyOfVal, new Stack<>());
        Stack<Integer> frequencyElements = frequencyStack.get(frequencyOfVal);
        frequencyElements.push(val);
        frequencyStack.put(frequencyOfVal,frequencyElements);
    }

    public int pop() {
        if(frequencyStack.size() == 0)
            return 0;
        int maxFrequency = (int)frequencyStack.keySet().toArray()[frequencyStack.keySet().toArray().length - 1];
        int element = frequencyStack.get(maxFrequency).pop();
        if(frequencyStack.get(maxFrequency).size() == 0)
            frequencyStack.remove(maxFrequency);
        frequencies.put(element, frequencies.get(element) - 1);
        if(frequencies.get(element) == 0)
            frequencies.remove(element);
        return element;

    }
}
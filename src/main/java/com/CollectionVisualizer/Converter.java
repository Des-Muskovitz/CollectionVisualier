package main.java.com.CollectionVisualizer;

import java.util.*;

public class Converter <T> {

    public Converter() {
    }

    public Map<Integer, T> converter(List<T> list){
        Map<Integer, T> output = new HashMap<>();

        for(int i = 0; i < list.size(); i++){
            output.put(i, list.get(i));
        }
        return output;
    }

    public Map<T, T> converter(Map<T, T> map){
        return map;
    }

    public Map<Integer, T> converter(Set<T> set){
        Map<Integer, T> output = new HashMap<>();
        int i = 0;
        Iterator<T> iterator = set.iterator();

        while(iterator.hasNext()){
            output.put(i, iterator.next());
            i++;
        }
        return output;
    }
}

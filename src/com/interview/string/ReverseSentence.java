package com.interview.string;

public class ReverseSentence {

    public void reverseSentence(){
        String s = "Beyond Square Solutions";
        String[] array = s.split("\\s");
        int low = 0;
        int high = array.length;
        while (low < high){
            String temp = array[low];
            array[low] = array[high-1];
            array[high-1] = temp;
            low++;
            high--;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<array.length; i++)
            sb.append(array[i]+" ");
        System.out.println(sb.toString());
    }
}

package series;


public interface Series {
    int getNext();
    
    void reset();
    
    void setStart(int x);

    default int[] getNextArray(int x) {
        int[] values = new int[x];
        for(int i=0; i < x; i++) {
            values[i] = getNext();
        }
        return values;
    }
}

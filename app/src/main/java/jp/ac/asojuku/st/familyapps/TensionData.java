package jp.ac.asojuku.st.familyapps;

/**
 * Created by AHKNT on 2016/11/02.
 */

public class TensionData {
    private int number;
    private int addition;
    private String comment;
    // Constructor
    public TensionData(int number, int addition, String comment) {
        this.number = number;
        this.addition = addition;
        this.comment = comment;
    }

    public int getNumber() {
        return number;
    }

    public int getAddition() {
        return addition;
    }

    public String getComment() {
        return comment;
    }
}
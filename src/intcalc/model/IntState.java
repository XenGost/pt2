package intcalc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IntState {
    private int[] state;

    public IntState() {
        this.state = new int[]{0};
    }

    public IntState(int[] state) {
        this.state = state;
    }

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

}

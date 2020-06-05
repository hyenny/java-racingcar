package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

public class RacingCar {
    private int position;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(ForwardingRule forwardingRule) {
        if (forwardingRule.canForward()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

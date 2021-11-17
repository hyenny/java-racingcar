package racingcar;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private int carCount;
    private int racingCount;
    private List<Car> cars = new ArrayList<>();
    private Random random;


    private RacingCar(int carCount, int racingCount, Random random) {
        this.carCount = carCount;
        this.racingCount = racingCount;
        this.random = random;

        if (carCount > 0) {
            addCar(carCount);
        }
    }

    public static RacingCar create(int carCount, int racingCount) {
        if (carCount < 1 || racingCount < 1) {
            throw new IllegalArgumentException("1 이상 입력해야 합니다.");
        }
        return new RacingCar(carCount, racingCount, new Random());
    }

    private void addCar(int num) {
        for (int i = 0; i < num; i++) {
            cars.add(new Car(cars.size() + 1));
        }
    }

    public void start() {
        ResultView.println("실행결과");
        for (int i = 0; i < racingCount; i++) {
            race();
            ResultView.println("");
        }
    }

    private void race() {
        for (int i = 0; i < cars.size(); i++) {
            Car current = cars.get(i);
            current.move(random.nextInt(RANDOM_BOUND));
            ResultView.printCarDistance(current.getDistance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carCount == racingCar.carCount && racingCount == racingCar.racingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carCount, racingCount);
    }
}

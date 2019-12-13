package cleancode;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class UtilsVsVO {
    public List<CarModel> filterCarModels(CarSearchCriteria criteria, List<CarModel> models) {
        List<CarModel> results = new ArrayList<>(models);
        results.removeIf(model -> !new Interval(model.getStartYear(), model.getEndYear())
                .intersects(new Interval(criteria.getStartYear(), criteria.getEndYear())));
        System.out.println("More filtering logic");
        return results;
    }
}

@Data
class Interval {
    private final int start, end;
    // http://world.std.com/~swmcd/steven/tech/interval.html
    public boolean intersects(Interval other) {
        return start <= other.getEnd() && other.getStart() <= end;
    }
}


class CarSearchCriteria {
    private final int startYear;
    private final int endYear;

    public CarSearchCriteria(int startYear, int endYear) {
        if (startYear > endYear) throw new IllegalArgumentException("start larger than end");
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }
}

class CarModel {
    private final int startYear;
    private final int endYear;

    public CarModel(int startYear, int endYear) {
        if (startYear > endYear) throw new IllegalArgumentException("start larger than end");
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getStartYear() {
        return startYear;
    }
}
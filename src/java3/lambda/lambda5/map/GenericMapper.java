package java3.lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenericMapper {

    public static <T,R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> returnList = new ArrayList<R>();
        for(T ele : list) {
            returnList.add(mapper.apply(ele));
        }
        return returnList;
    }
}

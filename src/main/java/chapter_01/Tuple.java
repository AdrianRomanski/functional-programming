package chapter_01;

public class Tuple<T, U> {

    private final T _1;
    private final U _2;

    public Tuple(T t, U u) {
        this._1 = t;
        this._2 = u;
    }

    public T get_1() {
        return _1;
    }

    public U get_2() {
        return _2;
    }
}

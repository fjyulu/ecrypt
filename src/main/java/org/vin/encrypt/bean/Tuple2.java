package org.vin.encrypt.bean;

public class Tuple2<T, U> {

    public T t;
    public U u;

    public Tuple2() {}

    public Tuple2(T t, U v) {
        this.t = t;
        this.u = v;
    }


    @Override
    public String toString() {
        return "Tuple2{" +
                "t=" + t +
                ", v=" + u +
                '}';
    }
}

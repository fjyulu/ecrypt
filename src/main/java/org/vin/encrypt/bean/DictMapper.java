package org.vin.encrypt.bean;

public class DictMapper<T, U> extends Tuple2<T, U> {


    public DictMapper(T t, U u) {
        this.t = t;
        this.u = u;
    }


    @Override
    public String toString() {
        return this.t + " -> " + this.u;
    }
}
